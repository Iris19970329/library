package com.example.library.Service;

import org.springframework.stereotype.Service;

import com.example.library.Entity.Inventory;
@Service
public interface IInventoryService {

	Inventory borrowbook(Inventory inv);
}
