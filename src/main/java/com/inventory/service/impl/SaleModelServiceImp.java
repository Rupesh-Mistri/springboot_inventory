package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.SaleModel;
import com.inventory.entity.repository.SaleModelRepository;
import com.inventory.service.SaleModelService;
@Service
public class SaleModelServiceImp implements SaleModelService{

	private SaleModelRepository  salemodelrepository;
	
	
	
	public SaleModelServiceImp(SaleModelRepository salemodelrepository) {
		super();
		this.salemodelrepository = salemodelrepository;
	}

	@Override
	public SaleModel saveSale(SaleModel purDe) {
		// TODO Auto-generated method stub
		return salemodelrepository.save(purDe);
	}

	@Override
	public SaleModel getSaleByID(Long id) {
		// TODO Auto-generated method stub
		return salemodelrepository.findById(id).get();
	}

	@Override
	public List<SaleModel> getAllSale() {
		// TODO Auto-generated method stub
		return salemodelrepository.findAll();
	}

}