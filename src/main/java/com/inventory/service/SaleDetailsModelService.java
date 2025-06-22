package com.inventory.service;

import java.util.List;

import com.inventory.entity.SaleDetailsModel;

public interface SaleDetailsModelService {
	SaleDetailsModel saveSaleDetails(SaleDetailsModel purd);
	
	List<SaleDetailsModel>  getAllSaleDetails();
	
	List<SaleDetailsModel> getSaleDetailsBySaleId(Long saleId);
}