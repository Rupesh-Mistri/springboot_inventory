package com.inventory.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Purchase_details_model;
import com.inventory.entity.repository.Purchase_details_model_Repository;
import com.inventory.service.Purchase_details_model_Service;

@Service
public class Purchase_details_model_ServiceImp implements Purchase_details_model_Service {
	
	Purchase_details_model_Repository purchase_details_model_Repository;
	
	

	public Purchase_details_model_ServiceImp(Purchase_details_model_Repository purchase_details_model_Repository) {
		super();
		this.purchase_details_model_Repository = purchase_details_model_Repository;
	}

	@Override
	public Purchase_details_model savePurchase_Details(Purchase_details_model pur_details) {
		// TODO Auto-generated method stub
		return purchase_details_model_Repository.save(pur_details);
	}

	@Override
	public List<Purchase_details_model> getAllPurchaseDetails() {
		// TODO Auto-generated method stub
		return purchase_details_model_Repository.findAll();
	}

	@Override
    public List<Purchase_details_model> getPurchaseDetailsByPurchaseId(Long purchaseId) {
        return purchase_details_model_Repository.findByPurchase_Id(purchaseId);
    }

	@Override
	public List<Object[]> getReportStockData() {
		// TODO Auto-generated method stub
		return purchase_details_model_Repository.getStockData();
	}

	@Override
	public List<Object[]> getStockReportByPram(LocalDate date1, LocalDate date2) {
		// TODO Auto-generated method stub
		return purchase_details_model_Repository.getStockPramData( date1, date2);
	}

	
	
}
