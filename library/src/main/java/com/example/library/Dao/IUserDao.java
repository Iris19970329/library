package com.example.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Entity.User;

public interface IUserDao extends JpaRepository<User, Integer> {

}
