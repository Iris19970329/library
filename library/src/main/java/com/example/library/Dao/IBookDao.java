package com.example.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Entity.Book;

public interface IBookDao extends JpaRepository<Book, String> {

}
