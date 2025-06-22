package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.Supplier_model;
import com.inventory.entity.repository.Supplier_model_Repository;
import com.inventory.service.Supplier_model_Service;

@Service
public class Supplier_model_ServiceImpl implements Supplier_model_Service{
	
	private Supplier_model_Repository  supplier_model_Repository;


	public Supplier_model_ServiceImpl(Supplier_model_Repository supplier_model_Repository) {
		super();
		this.supplier_model_Repository = supplier_model_Repository;
	}

	@Override
	public List<Supplier_model> getAllSupplier() {
		// TODO Auto-generated method stub
		return supplier_model_Repository.findAll();
	}

	@Override
	public Supplier_model saveSupplier(Supplier_model sup) {
		// TODO Auto-generated method stub
		return supplier_model_Repository.save(sup);
	}

	@Override
	public Supplier_model getSupplierById(long id) {
		// TODO Auto-generated method stub
		return supplier_model_Repository.findById(id).get();
	}

	@Override
	public Supplier_model updateSupplier(Supplier_model sup) {
		// TODO Auto-generated method stub
		return supplier_model_Repository.save(sup);
	}

	@Override
	public void deleteSupplier(long id) {
		// TODO Auto-generated method stub
		supplier_model_Repository.deleteById(id);
	}
}
