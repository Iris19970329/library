package com.example.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Book;
import com.example.library.Entity.Borrowingrecord;
import com.example.library.Entity.MyException;
import com.example.library.Entity.RequestVO;
import com.example.library.Entity.ResponseVO;
import com.example.library.Service.IBookService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BookController {

	
	@Autowired
	IBookService bookservice;
	
	@GetMapping("/findBook")
	public ResponseEntity<List<Book>> findBook() {
		//List<Book> result = bookservice.findBook();
		List<Book> result = bookservice.getAllBooks();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/borrowBook")
	public ResponseVO borrowBook(HttpSession session, @RequestBody RequestVO requestVo) {
		ResponseVO result = new ResponseVO();
		try{
			String phonenumber = (String) session.getAttribute("phonenumber");
	        if (phonenumber == null) {
	            throw new MyException("0008", "尚未登入");
	        }
	        requestVo.setUserphonenumber(phonenumber);
			bookservice.borrowBook(requestVo);
			result.setResponsecode("0000");
			result.setResponsedescription("借閱完成");
		}catch(MyException e) {
			result.setResponsecode(e.getCode());
			result.setResponsedescription(e.getMessage());
		}
		return result;
	}
	
	@PostMapping("/returnBook")
	public ResponseVO returnBook(HttpSession session, @RequestBody RequestVO requestVo) {
		ResponseVO result = new ResponseVO();
		try{
			String phonenumber = (String) session.getAttribute("phonenumber");
	        if (phonenumber == null) {
	            throw new MyException("0008", "尚未登入");
	        }
	        requestVo.setUserphonenumber(phonenumber);
			bookservice.returnBook(requestVo);
			result.setResponsecode("0000");
			result.setResponsedescription("歸還完成");
		}catch(MyException e) {
			result.setResponsecode(e.getCode());
			result.setResponsedescription(e.getMessage());
		}
		return result;
	}
	
	@GetMapping("/getBorrowRecord")
	public ResponseEntity<List<Borrowingrecord>> returnBook(HttpSession session) {
		    String phonenumber = (String) session.getAttribute("phonenumber");
			System.out.println(phonenumber);

		    List<Borrowingrecord> result = bookservice.getBorrowRecord(phonenumber);
			
			return ResponseEntity.ok(result);
		    
	}
	

}
