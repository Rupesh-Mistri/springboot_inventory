package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Purchase_model;
import com.inventory.entity.repository.Purchase_model_Repository;
import com.inventory.service.Purchase_model_Service;

@Service
public class Purchase_model_ServiceImp implements Purchase_model_Service {

	private Purchase_model_Repository purchase_model_Repository;

	
	public Purchase_model_ServiceImp(Purchase_model_Repository purchase_model_Repository) {
		super();
		this.purchase_model_Repository = purchase_model_Repository;
	}


	@Override
	public Purchase_model savePurchaseD(Purchase_model purDe) {
		// TODO Auto-generated method stub
		return purchase_model_Repository.save(purDe);
	}


	@Override
	public Purchase_model getPurchaseByID(Long id) {
		// TODO Auto-generated method stub
		return purchase_model_Repository.findById(id).get();
	}


	@Override
	public List<Purchase_model> getAllPurchase() {
		// TODO Auto-generated method stub
		return purchase_model_Repository.findAll();
	}

}
