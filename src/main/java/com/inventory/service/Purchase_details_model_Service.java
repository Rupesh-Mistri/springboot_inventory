package com.inventory.service;

import java.time.LocalDate;
import java.util.List;

import com.inventory.entity.Purchase_details_model;

public interface Purchase_details_model_Service   {
	Purchase_details_model savePurchase_Details(Purchase_details_model purd);
	
	List<Purchase_details_model>  getAllPurchaseDetails();
	
	List<Purchase_details_model> getPurchaseDetailsByPurchaseId(Long purchaseId);

	List<Object[]> getReportStockData( );
	List<Object[]> getStockReportByPram(LocalDate date1,LocalDate date2 );
}
