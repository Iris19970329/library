package com.example.library.Service;

import org.springframework.stereotype.Service;

import com.example.library.Entity.MyException;
import com.example.library.Entity.User;

@Service
public interface IUserService {
	void signup(User user) throws MyException;
	User login(User user)  throws MyException;
}
