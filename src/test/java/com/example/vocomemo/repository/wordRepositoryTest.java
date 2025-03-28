package com.example.vocomemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.vocomemo.dao.wordRepository;
import com.example.vocomemo.entity.Word;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class wordRepositoryTest {

    @Autowired
    private wordRepository wordRepository;

    @BeforeEach
    public void setup() {

        // 在每個測試方法執行前，先清空所有的資料，確保每個測試方法都有一致的初始狀態
        wordRepository.deleteAll();

        // 新增測試資料
        wordRepository.saveAll(Arrays.asList(
            new Word("apple", "蘋果"),
            new Word("banana", "香蕉"),
            new Word("orange", "橘子")
        ));
    }
    
    @Test
    public void testWordRepository() {
        // 確認資料庫中是否有單字 "apple"
        Word word = wordRepository.findByWordContent("apple");
        assertNotNull(word);  // 確保找到的單字不為 null
        assertEquals("apple", word.getWordContent());  // 確保單字名稱正確
        assertEquals("蘋果", word.getWordDefinition());  // 確保意思正確
    }
}
