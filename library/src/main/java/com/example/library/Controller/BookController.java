package com.example.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Book;
import com.example.library.Service.IBookService;

@RestController
public class BookController {

	
	@Autowired
	IBookService bookservice;
	
	@GetMapping("/findBook")
	public ResponseEntity<List<Book>> findBook() {
		List<Book> result = bookservice.findBook();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/test01")
	public String test01() {
		return "test01";
	}
	
	@GetMapping("/test02")
	public String test02() {
		return "test02";
	}

}
