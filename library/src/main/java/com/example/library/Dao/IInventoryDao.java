package com.example.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Entity.Inventory;

public interface IInventoryDao extends JpaRepository<Inventory, Integer>{

}
