package com.inventory.service;

import java.util.List;



import com.inventory.entity.Supplier_model;


public interface Supplier_model_Service {
	
	List<Supplier_model> getAllSupplier();
	
	Supplier_model saveSupplier(Supplier_model sup);
	
	Supplier_model getSupplierById(long id);
	
	Supplier_model updateSupplier(Supplier_model sup); 
	
	void deleteSupplier(long id);
}
