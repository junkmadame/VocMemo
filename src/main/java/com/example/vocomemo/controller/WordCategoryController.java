package com.example.vocomemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vocomemo.dao.WordCategoryRepository;
import com.example.vocomemo.entity.WordCategory;
import com.example.vocomemo.service.WordCategoryService;

@RestController
@RequestMapping("/category")
public class WordCategoryController {
	
	@Autowired
    private WordCategoryService wordCategoryService;
    @Autowired
	private  WordCategoryRepository wordCategoryRepository;

    // 創建單字分類
    @PostMapping("/createCategory")
    public WordCategory createCategory(@RequestBody WordCategory wordCategory) {
    	
        return wordCategoryService.createCategory(wordCategory);
    }

    // 讀取單字分類
    @GetMapping("/{id}")
    public WordCategory readCategory(@PathVariable Long id) {
        return wordCategoryService.readCategory(id);
    }

    // 更新單字分類
    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<WordCategory> updateCategory(@PathVariable Long id, @RequestBody WordCategory wordCategory) {
        // 這裡確認了如果找不到資料會回傳 404
        WordCategory updatedCategory = wordCategoryService.updateCategory(wordCategory, id);
        if (updatedCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 回傳 404
        }
        return ResponseEntity.ok(updatedCategory); // 更新成功則回傳 200 和更新後的資料
    }

    // 刪除單字分類
    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	wordCategoryService.deleteCategory(id);
    }
    
    @GetMapping
    public List<WordCategory> getAllCategories() {
        return wordCategoryRepository.findAll(); // 或在 service 中包一層
    }

}
