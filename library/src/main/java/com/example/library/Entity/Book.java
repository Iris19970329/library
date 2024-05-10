package com.example.library.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	private String iSBN;
	
	private String name;
	private String author;
	private String introduction;
	
	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Book( ) {
		
	}
	
	public Book(String iSBN,String name, String author, String introduction) {
		this.iSBN = iSBN;
		this.name = name;
		this.author = author;
		this.introduction = introduction;
		
	}
	
	@Override
	public String toString() {
		return "Book [ISBN=" + iSBN + ",name = " + name + ",author = " + author + ",introduction = " + introduction + "]"; 
	}
	
}
