package com.example.library.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.Entity.Book;

@Service
public interface IBookService {
	List<Book> findBook();
}
