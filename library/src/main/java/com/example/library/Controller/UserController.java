package com.example.library.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.MyException;
import com.example.library.Entity.ResponseVO;
import com.example.library.Entity.User;
import com.example.library.Service.IUserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private IUserService userservice;

	@PostMapping("/signup")
	public ResponseVO signup(@RequestBody User user) {
		ResponseVO responseVO = new ResponseVO();
		try {
			userservice.signup(user);
			responseVO.setResponsecode("0000");
			responseVO.setResponsedescription("註冊成功");
		} catch (MyException e) {
			responseVO.setResponsecode(e.getCode());
			responseVO.setResponsedescription(e.getMessage());
		}
		return responseVO;
	}

	@PostMapping("/login")
	public ResponseVO login(HttpSession session, @RequestBody User user) {
		ResponseVO responseVO = new ResponseVO();
		try {
			User userinfo = userservice.login(user);

			if (userinfo != null) {
				session.setAttribute("phonenumber", userinfo.getPhoneNumber());
				session.setAttribute("username", userinfo.getUserName());

				responseVO.setResponsecode("0000");
				responseVO.setResponsedescription("登入成功");
			} else {
				responseVO.setResponsecode("0005");
				responseVO.setResponsedescription("登入失敗");
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		return responseVO;
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
	    session.invalidate();
	  
	    return ResponseEntity.ok("logout_success");
	}

	@GetMapping("/checkLogin")
	public Map<String, Object> checkLogin(HttpSession session) {
	    Map<String, Object> response = new HashMap<>();
	    String phonenumber = (String) session.getAttribute("phonenumber");
	    String username = (String) session.getAttribute("username");
	    if (phonenumber != null) {
	        response.put("loggedIn", true);
	        response.put("phonenumber", phonenumber);
	        response.put("username", username);
	    } else {
	        response.put("loggedIn", false);
	    }
	    return response;
	}

}
