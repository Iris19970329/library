package com.example.library.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Borrowingrecord implements Serializable {

	@Id
	private int userId;
	
	@Id
	private String iSBN;
	
	private LocalDateTime borrowingTime;
	private LocalDateTime returnTime;
	private int status;
	
	private String bookname;



	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int i) {
		this.userId = i;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String string) {
		this.iSBN = string;
	}

	public LocalDateTime getBorrowingTime() {
		return borrowingTime;
	}

	public void setBorrowingTime(LocalDateTime borrowingTime) {
		this.borrowingTime = borrowingTime;
	}

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}

	public Borrowingrecord( ) {
		
	}
	
	
	
}
