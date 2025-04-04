package com.example.vocomemo.entity;

import com.example.vocomemo.entity.WordCategory;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "words")
public class Word {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wordid")
	private Long id;
	
	@Column(name = "word_content")
	private String wordContent;
	@Column(name = "word_definition")
	private String wordDefinition;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private WordCategory wordCategory;
	
	
	//Spring JPA 需要一個無參數的建構子
	public Word() {

	}
	
	public Word(String wordContent, String wordDefinition, WordCategory wordCategory){
		this.wordContent = wordContent;
		this.wordDefinition = wordDefinition;
		this.wordCategory = wordCategory;
	}
	
	public void setId(Long id ) {
		this.id= id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setWordContent(String wordContent) {
		this.wordContent = wordContent;
	}
	
	public void setWordDefinition(String wordDefinition) {
		this.wordDefinition = wordDefinition;
	}
	
	public String getWordContent() {
		return wordContent;
	}
	
	public String getWordDefinition() {
		return wordDefinition;
	}
	
	public void setWordCategory(WordCategory wordCategory) {
		this.wordCategory = wordCategory;
	}
	
	public WordCategory getWordCategory() {
		return wordCategory;
	}
}
