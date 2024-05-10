package com.example.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Entity.Borrowingrecord;
import com.example.library.Entity.Borrowingrecord.BorrowingrecordId;

public interface IBorrowingrecordDao extends JpaRepository<Borrowingrecord, BorrowingrecordId> {

}
