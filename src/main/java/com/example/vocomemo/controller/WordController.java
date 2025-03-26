package com.example.vocomemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.vocomemo.entity.Word;
import com.example.vocomemo.service.WordService;

import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    // 創建單字
    @PostMapping("/createWord")
    public Word createWord(@RequestBody Word word) {
    	
        return wordService.createWord(word);
    }

    // 讀取單字
    @GetMapping("/{id}")
    public Word readWord(@PathVariable Long id) {
        return wordService.readWord(id);
    }

    // 更新單字
    @PutMapping("/{id}")
    public Word updateWord(@RequestBody Word word, @PathVariable Long id) {
        return wordService.updateWord(word, id);
    }

    // 刪除單字
    @DeleteMapping("/{id}")
    public void deleteWord(@PathVariable Long id) {
        wordService.deleteWord(id);
    }

    // 取得所有單字
    @GetMapping("/")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    // 測驗單字
    @PostMapping("/check/{id}")
    public String checkWord(@PathVariable Long id) {
        return wordService.checkWordCorrectness(id);
    }

    // 隨機取得單字
    @GetMapping("/random")
    public Word getRandomWord() {
        return wordService.getRandomWord();
    }
    
    @GetMapping("/serverStatus")
    public String serverStatus() {
    	return "Server is running";
    }
}
