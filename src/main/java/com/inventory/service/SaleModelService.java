package com.inventory.service;

import java.util.List;


import com.inventory.entity.SaleModel;

public interface SaleModelService {
	SaleModel saveSale(SaleModel purDe);
	
	SaleModel getSaleByID(Long id);
	
	List<SaleModel> getAllSale();
}