package com.example.library.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@IdClass(Borrowingrecord.BorrowingrecordId.class)
public class Borrowingrecord implements Serializable {

	@Id
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId")
	private User userId;
	
	@Id
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "inventoryId")
	private Inventory inventoryId;
	
	private Date borrowingTime;
	private Date returnTime;
	



	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Inventory getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Inventory inventoryId) {
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
	    private User userId;
	    private Inventory inventoryId;
	    
	    public BorrowingrecordId() {
			
		}
	    
	    public BorrowingrecordId(User userId, Inventory inventoryId) {

	    	this.userId=userId;
	    	this.inventoryId=inventoryId;
		}
	    }
	
	
	
}
