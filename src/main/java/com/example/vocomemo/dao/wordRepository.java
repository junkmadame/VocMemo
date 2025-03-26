package com.example.vocomemo.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.vocomemo.entity.Word;

@Repository
public interface wordRepository extends JpaRepository<Word, Long>{
	Word findByWordContent(String wordContent);
}
