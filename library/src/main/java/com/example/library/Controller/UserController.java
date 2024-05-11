package com.example.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.User;
import com.example.library.Service.IUserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private IUserService userservice;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		User aduser =userservice.signup(user);
		if (aduser != null) {
			return ResponseEntity.ok(aduser);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestBody User user){
		int loginmesg = userservice.login(user);
		if (loginmesg == 1) {
			session.setAttribute("phonenumber", user.getPhoneNumber());
			session.setAttribute("username",user.getUserName());
			return "login_success";
		}else {
			return "login_fail";
		}
	}
}
