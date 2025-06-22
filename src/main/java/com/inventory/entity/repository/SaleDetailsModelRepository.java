package com.inventory.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inventory.entity.SaleDetailsModel;

public interface SaleDetailsModelRepository extends JpaRepository<SaleDetailsModel,Long>{
	List<SaleDetailsModel> findBySale_Id(Long saleId);

}