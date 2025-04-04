package com.example.vocomemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vocomemo.dao.WordCategoryRepository;
import com.example.vocomemo.entity.WordCategory;

@Service
public class WordCategoryService {

	@Autowired
	private  WordCategoryRepository wordCategoryRepository;
	
	public WordCategory createCategory(WordCategory wordCategory) {
		return wordCategoryRepository.save(wordCategory);
	}
	
	//Read Word
	public WordCategory readCategory(Long id) {
		return wordCategoryRepository.findById(id).orElse(null);
	}
	
	//Update Word
	public WordCategory updateCategory(WordCategory wordCategory, Long id) {
	    // 查詢是否有該 id 的資料
	    WordCategory existingCategory = wordCategoryRepository.findById(id).orElse(null);
	    if (existingCategory == null) {
	        return null; // 找不到資料則返回 null
	    }
	    // 更新單字內容
	    existingCategory.setDescription(wordCategory.getDescription());
	    existingCategory.setName(wordCategory.getName());
	    wordCategoryRepository.save(existingCategory); // 保存更新後的單字
	    return existingCategory; // 返回更新後的單字
	}
	
	//Delete Word
	public void deleteCategory(Long id) {
		wordCategoryRepository.deleteById(id);
	}
}
