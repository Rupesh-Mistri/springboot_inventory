package com.inventory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Supplier_model;
import com.inventory.entity.item_model;
import com.inventory.service.Supplier_model_Service;

import jakarta.servlet.http.HttpServletRequest;

//@Controller
@RestController
public class Supplier_master_controller {

	private Supplier_model_Service supplier_model_Service;
	
	public Supplier_master_controller(Supplier_model_Service supplier_model_Service) {
		super();
		this.supplier_model_Service = supplier_model_Service;
	}
	
	@GetMapping("/supplier_list")
	public List<Supplier_model> supplier_list(Model model)
	{	
		List<Supplier_model>  all_supplier= supplier_model_Service.getAllSupplier();
		
		for(Supplier_model i : all_supplier)
		{
			System.out.print(i);
		}
		
		model.addAttribute("supplier_list",supplier_model_Service.getAllSupplier());
		
		return all_supplier;
	}
	
	@GetMapping("/supplier_insert")
	public String supplier_insert(Model model)
	{
		return "supplier_insert";
	}
	
	@PostMapping("/supplier_insert")
	public String supplier_insertPost(@RequestBody Supplier_model request)
	{
		Supplier_model sup =new Supplier_model();
		String supplier_name =request.getSupplier_name();
		String address =request.getAddress();
		String mobile =request.getMobile();
		String email=request.getEmail();
		
		sup.setSupplier_name(supplier_name);
		sup.setAddress(address);
		sup.setEmail(email);
		sup.setMobile(mobile);
		supplier_model_Service.saveSupplier(sup);
		
		return "{\"status\":\"Successfully Created\"}";
	}
	
	@GetMapping("/supplier_edit/{id}")
	public Supplier_model supplier_edit(@PathVariable long id,Model model)
	{
		Supplier_model supp=supplier_model_Service.getSupplierById(id);
//		model.addAttribute("supplier",supplier_model_Service.getSupplierById(id));
		
		return supp;
	}
	
	@PutMapping("/supplier_edit/{id}")
	public String supplier_editPost(@PathVariable long id,@RequestBody Supplier_model request)
	{
		Supplier_model sup =supplier_model_Service.getSupplierById(id);
		
		String supplier_name =request.getSupplier_name();
		String address =request.getAddress();
		String mobile =request.getMobile();
		String email=request.getEmail();
		
		sup.setSupplier_name(supplier_name);
		sup.setAddress(address);
		sup.setEmail(email);
		sup.setMobile(mobile);
		supplier_model_Service.updateSupplier(sup);
		
		return "{\"status\":\"Successfully Updated\"}";
	}

	@GetMapping("/supplier_delete/{id}")
	public String supplier_delete(@PathVariable long id)
	{
		supplier_model_Service.deleteSupplier(id);
		return "redirect:/supplier_list";
	}
	


}
