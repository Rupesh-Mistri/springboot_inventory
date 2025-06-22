package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.item_model;
import com.inventory.entity.repository.item_model_Repository;
import com.inventory.service.item_mode_Service;

@Service
public class item_model_ServiceImp implements item_mode_Service  {

	private item_model_Repository  item_model_repository;

	public item_model_ServiceImp(item_model_Repository item_model_repository) {
		super();
		this.item_model_repository = item_model_repository;
	}

	@Override
	public List<item_model> getAll_Item() {
		// TODO Auto-generated method stub
		return item_model_repository.findAll();
	}

	@Override
	public item_model saveItem(item_model item) {
		// TODO Auto-generated method stub
		return item_model_repository.save(item);
	}

	@Override
	public item_model getItemById(Long id) {
		// TODO Auto-generated method stub
		return item_model_repository.findById(id).get();
	}

	@Override
	public item_model UpdateItem(item_model item) {
		// TODO Auto-generated method stub
		return item_model_repository.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		// TODO Auto-generated method stub
		 item_model_repository.deleteById(id);
	}
	
}
