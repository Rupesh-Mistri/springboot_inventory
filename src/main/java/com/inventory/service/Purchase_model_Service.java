package com.inventory.service;

import java.util.List;

import com.inventory.entity.Purchase_model;

public interface Purchase_model_Service {
	Purchase_model savePurchaseD(Purchase_model purDe);
	
	Purchase_model getPurchaseByID(Long id);
	
	List<Purchase_model> getAllPurchase();
}
