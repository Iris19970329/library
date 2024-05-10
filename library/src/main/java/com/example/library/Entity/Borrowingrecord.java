package com.example.library.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(Borrowingrecord.BorrowingrecordId.class)
public class Borrowingrecord implements Serializable {

	@Id
	private int userId;
	
	@Id
	private int inventoryId;
	
	private Date borrowingTime;
	private Date returnTime;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Date getBorrowingTime() {
		return borrowingTime;
	}

	public void setBorrowingTime(Date borrowingTime) {
		this.borrowingTime = borrowingTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Borrowingrecord( ) {
		
	}
	
	
	public static class BorrowingrecordId implements Serializable {
	    private int userId;
	    private int inventoryId;
	    
	    public BorrowingrecordId() {
			
		}
	    
	    public BorrowingrecordId(int userId, int inventoryId) {

	    	this.userId=userId;
	    	this.inventoryId=inventoryId;
		}
	    }
	
	
	
}
