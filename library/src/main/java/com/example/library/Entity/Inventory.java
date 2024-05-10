package com.example.library.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;
	
	private String iSBN;
	private Date storeTime;
	private String status;
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public Date getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Inventory() {
		
	}
	
	public Inventory(int inventoryId, String iSBN, Date storeTime, String status ) {
		this.inventoryId = inventoryId;
		this.iSBN = iSBN;
		this.storeTime = storeTime;
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ",ISBN = " + iSBN + ",storeTime = " + storeTime + ",status = " + status + "]"; 
	}
}
