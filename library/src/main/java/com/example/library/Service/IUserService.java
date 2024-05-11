package com.example.library.Service;

import org.springframework.stereotype.Service;

import com.example.library.Entity.User;

@Service
public interface IUserService {
	User signup(User user);
	int login(User user);
}
