package com.example.vocomemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vocomemo.entity.Word;
import com.example.vocomemo.service.WordService;

import org.springframework.ui.Model;

import java.util.ArrayList;
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
    @PutMapping("/updateWord/{id}")
    public ResponseEntity<Word> updateWord(@PathVariable Long id, @RequestBody Word word) {
        // 這裡確認了如果找不到資料會回傳 404
        Word updatedWord = wordService.updateWord(word, id);
        if (updatedWord == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 回傳 404
        }
        return ResponseEntity.ok(updatedWord); // 更新成功則回傳 200 和更新後的資料
    }

    // 刪除單字
    @DeleteMapping("/deleteWord/{id}")
    public void deleteWord(@PathVariable Long id) {
        wordService.deleteWord(id);
    }

    @GetMapping("/allwords")
    public List<Word> getAllWords() {
        List<Word> words = wordService.getAllWords();
        return words != null ? words : new ArrayList<>(); // 防止 null，返回空陣列
    }

//    // 測驗單字
//    @PostMapping("/check/{id}")
//    public String checkWord(@PathVariable Long id) {
//        return wordService.checkWordCorrectness(id);
//    }
//
//    // 隨機取得單字
//    @GetMapping("/random")
//    public Word getRandomWord() {
//        return wordService.getRandomWord();
//    }
    
    @GetMapping("/serverStatus")
    public String serverStatus() {
    	return "Server is running";
    }
}
