package com.example.library.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Entity.User;

public interface IUserDao extends JpaRepository<User, Integer> {

	List<User> findByPhoneNumber(String phoneNumber);

}
