package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.Entity.Book;
import com.example.library.Entity.Borrowingrecord;
import com.example.library.Entity.MyException;
import com.example.library.Entity.RequestVO;
import com.example.library.Entity.ResponseVO;

@Service
public interface IBookService {
	List<Book> getAllBooks();
	List<Borrowingrecord> getBorrowRecord(String phonenumber);
	void borrowBook(RequestVO requestVo) throws MyException;
	void returnBook(RequestVO requestVo) throws MyException;

}
