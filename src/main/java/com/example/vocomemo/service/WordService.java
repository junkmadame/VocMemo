package com.example.vocomemo.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.vocomemo.dao.wordRepository;
import com.example.vocomemo.entity.Word;

@Service
public class WordService {

	@Autowired
	private wordRepository wordRepository;
	
	//Create Word
	public Word createWord(Word word) {
		return wordRepository.save(word);
	}
	
	//Read Word
	public Word readWord(Long id) {
		return wordRepository.findById(id).get();
	}
	
	//Update Word
	public Word updateWord(Word word, Long id) {
		Word existingWord = wordRepository.findById(id).orElseThrow(()->new RuntimeException("Word not found"));
		existingWord.setWordContent(word.getWordContent());
		existingWord.setWordDefinition(word.getWordDefinition());
		return wordRepository.save(existingWord);
	}
	
	//Delete Word
	public void deleteWord(Long id) {
		wordRepository.deleteById(id);
	}
	
	//Get all Words
	public List<Word> getAllWords() {
		List<Word> 	words = wordRepository.findAll();
		if (words.isEmpty()) {
			return null;
		}
		return words;
	}
	
	//check Word Correctness or not
	public String checkWordCorrectness(Long id) {
		Scanner scanner = new Scanner(System.in);
		String word1 = scanner.nextLine();
		scanner.close();
		Word word2 = wordRepository.findById(id).get();
		if (word1.equals(word2.getWordContent())) {
			return "Word is correct";
		} else
			return "Word is incorrect";
	}
	
	public Word getRandomWord() {
		List<Word> words = wordRepository.findAll(); //word可能經過刪除，為了避免找到空值所以先把所有word都丟進list方便處理
		if(words.isEmpty()) { //要是根本沒單字就回傳null
			return null;
		} 
		Random random = new Random();
		return words.get(random.nextInt(words.size())); 
	}
}
