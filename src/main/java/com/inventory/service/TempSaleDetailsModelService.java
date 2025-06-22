package com.inventory.service;

import java.util.List;

import com.inventory.entity.TempSaleDetailsModel;


public interface TempSaleDetailsModelService {
	TempSaleDetailsModel saveTempData(TempSaleDetailsModel  temp);
	
	List<TempSaleDetailsModel> getAllTempData();
	
	void deleteTemp_data();
}