package com.example.vocomemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.vocomemo.VocMemoApplication;
import com.example.vocomemo.dao.wordRepository;
import com.example.vocomemo.entity.Word;
import com.example.vocomemo.service.WordService;

@SpringBootTest(classes = VocMemoApplication.class)
public class wordServiceTest {

    @Mock  // 用於模擬 Spring 上下文中的 bean
    private wordRepository wordRepository;

    @InjectMocks
    private WordService wordService;

    @Test
    public void testCreateWord() {
        Word word = new Word("apple", "蘋果");
        when(wordRepository.save(word)).thenReturn(word);

        // 測試創建單字的方法
        assertEquals(word, wordService.createWord(word));
    }
}
