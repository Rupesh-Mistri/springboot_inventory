package com.inventory.service;

import java.util.List;

import com.inventory.entity.item_model;

public interface item_mode_Service {
	List<item_model>  getAll_Item();
	
	item_model saveItem(item_model item);
	
	item_model getItemById(Long id);
	
	item_model UpdateItem(item_model item);
	
	void deleteItem(Long id);
}
