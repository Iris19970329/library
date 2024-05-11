package com.example.library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Dao.IBookDao;
import com.example.library.Entity.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookDao bookdao;
	
	@Override
	public List<Book> findBook(){
		List<Book> allbook = bookdao.findAll();
		return allbook;
	};
}
