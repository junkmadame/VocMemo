package com.example.vocomemo.dao;

import com.example.vocomemo.entity.WordCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordCategoryRepository extends JpaRepository<WordCategory, Long> {

}
