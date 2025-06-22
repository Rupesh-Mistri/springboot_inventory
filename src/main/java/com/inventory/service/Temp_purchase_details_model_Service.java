package com.inventory.service;



import java.util.List;

import com.inventory.entity.Temp_purchase_details_model;


public interface Temp_purchase_details_model_Service {
	
	Temp_purchase_details_model saveTempData(Temp_purchase_details_model  temp);
	
	List<Temp_purchase_details_model> getAllTempData();
	
	void deleteTemp_data();
}
