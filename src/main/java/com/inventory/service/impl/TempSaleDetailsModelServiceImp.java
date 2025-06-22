package com.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.entity.TempSaleDetailsModel;
import com.inventory.entity.repository.TempSaleDetailsModelRepository;
import com.inventory.service.TempSaleDetailsModelService;
@Service
public class TempSaleDetailsModelServiceImp implements TempSaleDetailsModelService{

	private TempSaleDetailsModelRepository tempsaledetailsmodelrepository;
	public TempSaleDetailsModelServiceImp(TempSaleDetailsModelRepository tempsaledetailsmodelrepository) {
		super();
		this.tempsaledetailsmodelrepository = tempsaledetailsmodelrepository;
	}

	@Override
	public TempSaleDetailsModel saveTempData(TempSaleDetailsModel temp) {
		// TODO Auto-generated method stub
		return tempsaledetailsmodelrepository.save(temp);
	}

	@Override
	public List<TempSaleDetailsModel> getAllTempData() {
		// TODO Auto-generated method stub
		return tempsaledetailsmodelrepository.findAll();
	}

	@Override
	public void deleteTemp_data() {
		// TODO Auto-generated method stub
		tempsaledetailsmodelrepository.deleteAll();
	}

}