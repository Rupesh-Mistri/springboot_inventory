package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.SaleDetailsModel;
import com.inventory.entity.repository.SaleDetailsModelRepository;
import com.inventory.service.SaleDetailsModelService;
@Service
public class SaleDetailsModelImp implements  SaleDetailsModelService{

	private SaleDetailsModelRepository saledetailsmodelrepository;
	
	public SaleDetailsModelImp(SaleDetailsModelRepository saledetailsmodelrepository) {
		super();
		this.saledetailsmodelrepository = saledetailsmodelrepository;
	}

	@Override
	public SaleDetailsModel saveSaleDetails(SaleDetailsModel purd) {
		// TODO Auto-generated method stub
		return saledetailsmodelrepository.save(purd);
	}

	@Override
	public List<SaleDetailsModel> getAllSaleDetails() {
		// TODO Auto-generated method stub
		return saledetailsmodelrepository.findAll();
	}

	@Override
	public List<SaleDetailsModel> getSaleDetailsBySaleId(Long saleId) {
		// TODO Auto-generated method stub
		return saledetailsmodelrepository.findBySale_Id(saleId);
	}

}