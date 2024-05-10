package com.example.library.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String phoneNumber;
	private String password;
	private String userName;
	private Date registrationTime;
	private Date lastLoginTime;
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public User() {
		
	}
	
	public User(int userId,String phoneNumber, String password, String userName, Date registrationTime, Date lastLoginTime ) {
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userName = userName;
		this.registrationTime = registrationTime;
		this.lastLoginTime = lastLoginTime;
	}
	
	@Override
	public String toString() {
		return "User [ userId=" +  userId + ",phoneNumber = " + phoneNumber + ",password = " + password + ",userName = " + userName +
				",registrationTime" + registrationTime + ",lastLoginTime" + lastLoginTime + "]"; 
	}
}
