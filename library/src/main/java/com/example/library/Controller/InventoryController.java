package com.example.library.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Inventory;
import com.example.library.Service.IInventoryService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class InventoryController {

	@Autowired
	IInventoryService inventoryservice;
	
	
}
