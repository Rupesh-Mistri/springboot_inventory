package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Temp_purchase_details_model;
import com.inventory.entity.repository.Temp_purchase_details_model_Repositoty;
import com.inventory.service.Temp_purchase_details_model_Service;

@Service
public class Temp_purchase_details_model_ServiceImpl implements  Temp_purchase_details_model_Service {

	private Temp_purchase_details_model_Repositoty temp_purchase_details_model_Repositoty;
	
	
	
	
	public Temp_purchase_details_model_ServiceImpl(	Temp_purchase_details_model_Repositoty temp_purchase_details_model_Repositoty) {
		super();
		this.temp_purchase_details_model_Repositoty = temp_purchase_details_model_Repositoty;
	}




	@Override
	public Temp_purchase_details_model saveTempData(Temp_purchase_details_model temp) {
		// TODO Auto-generated method stub
		return temp_purchase_details_model_Repositoty.save(temp);
	}




	@Override
	public List<Temp_purchase_details_model> getAllTempData() {
		// TODO Auto-generated method stub
		return temp_purchase_details_model_Repositoty.findAll();
	}




	@Override
	public void deleteTemp_data() {
		// TODO Auto-generated method stub
		temp_purchase_details_model_Repositoty.deleteAll();
	}





	
	
}
