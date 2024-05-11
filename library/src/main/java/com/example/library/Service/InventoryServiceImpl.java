package com.example.library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Dao.IInventoryDao;
import com.example.library.Entity.Inventory;

@Service
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	IInventoryDao inventorydao;
	
	@Override
	public  Inventory borrowbook(Inventory inv) {
		return inventorydao.save(inv);
	}
}
