package com.inventory.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.Purchase_details_model;
import com.inventory.entity.Purchase_model;
import com.inventory.entity.SaleDetailsModel;
import com.inventory.entity.SaleModel;
import com.inventory.entity.TempSaleDetailsModel;
import com.inventory.entity.Temp_purchase_details_model;
import com.inventory.entity.item_model;
import com.inventory.service.SaleDetailsModelService;
import com.inventory.service.SaleModelService;
import com.inventory.service.TempSaleDetailsModelService;
import com.inventory.service.item_mode_Service;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SaleController {

	private item_mode_Service  item_mode_service;
	private TempSaleDetailsModelService  tempsaledetailsmodelservice;
	private SaleModelService salemodelservice;
	private SaleDetailsModelService saledetailsmodelservice;
	public SaleController(item_mode_Service item_mode_service,TempSaleDetailsModelService tempsaledetailsmodelservice,
			SaleModelService salemodelservice,SaleDetailsModelService saledetailsmodelservice) {
		super();
		this.item_mode_service = item_mode_service;
		this.tempsaledetailsmodelservice=tempsaledetailsmodelservice;
		this.salemodelservice=salemodelservice;
		this.saledetailsmodelservice=saledetailsmodelservice;
	}

	@GetMapping("/sale_list")
	public List<SaleModel> saleList(Model model) {
		List<SaleModel> salel=salemodelservice.getAllSale();
//		model.addAttribute("sale_list",salemodelservice.getAllSale());
		return salel;
	}
	
	@GetMapping("/sale_insert")
	public List<TempSaleDetailsModel>  saleInsert(Model model)
	{
		model.addAttribute("item_list",item_mode_service.getAll_Item());
		 List<TempSaleDetailsModel>  temp_data = tempsaledetailsmodelservice.getAllTempData();
	      
//	      System.out.print("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//	      for(TempSaleDetailsModel i : temp_data)
//	      {
//	      	System.out.println(i);
//	      	System.out.println("Total: " + i.getRateX_Q());
//	      }
		model.addAttribute("temp_item_list",tempsaledetailsmodelservice.getAllTempData());
		
		return temp_data;
	}
	
	@PostMapping("/sale_insert")
	public String saleInsertPost(Model model,@RequestBody Map<String, Object> request) {
	     String addbtn=(String)request.get("ADD");
	      String savebtn=(String)request.get("SAVE");
        TempSaleDetailsModel  temp =new TempSaleDetailsModel();
        
        if ("ADD".equals(addbtn))
        {	System.out.print(" Sale ADD button clicked");
//            long item_id= Integer.parseInt(request.getParameter("item_name"));
//            int item_rate= Integer.parseInt(request.getParameter("item_rate"));
//            int item_quantity= Integer.parseInt(request.getParameter("quantity"));
        	
		  	  String itmn = (String) request.get("item_name");
		  	  System.out.print("code1");
		  	  int itmr = Integer.parseInt(request.get("item_rate").toString());
		  	  System.out.print("code2");
		  	  String itmq = (String) request.get("quantity");
		  	  System.out.print("code3");
		        System.out.println("ITEM NAME"+itmn);
		        System.out.println("ITEM RATE"+itmr);
		        System.out.println("ITEM QTY"+itmq);    
        
		          System.out.print("code4");
		          Long item_id = Long.parseLong(request.get("item_name").toString());
		          System.out.print("code5");
		          Integer item_rate = (Integer) request.get("item_rate");
		          System.out.print("code6");
		          Integer item_quantity = Integer.parseInt((String) request.get("quantity"));
		          System.out.print("code7");
		          item_model item = item_mode_service.getItemById(item_id); 
		          System.out.print("code8");
		          System.out.println("Database item"+item.getId());
		          
	        temp.setItem(item);
	        temp.setItem_rate(item_rate);
	        temp.setQuantity(item_quantity);
	        temp.setStatus(1);
	        LocalDateTime datetime = java.time.LocalDateTime.now();
	        temp.setDatetime(datetime);
	        model.addAttribute("tempPurchase", temp);
	        model.addAttribute("itemRate",item_rate);
	        tempsaledetailsmodelservice.saveTempData(temp);
//
	        model.addAttribute("temp_item_list",tempsaledetailsmodelservice.getAllTempData());
	        
        }
        
        else//if( savebtn!=null)
        { 	System.out.print("SAVE button clicked");
    	SaleModel sale= new SaleModel();
    	
//    	String invoice_no=request.getParameter("invoice_no");	
//    	String invoice_date=request.getParameter("invoice_date");
//    	String customer_name= request.getParameter("customer_name");
    	
    	String invoice_no=(String) request.get("invoice_no");	
      	String invoice_date=(String) request.get("invoice_date");
      	String customer_name=(String) request.get("customer_name");
    	
    	System.out.print(invoice_date);
    	sale.setInvoice_no(invoice_no);
    	sale.setInvoice_date(LocalDate.parse(invoice_date));
    	sale.setCustomer_name(customer_name);
    	sale.setStatus(1);
    	sale.setDatetime(java.time.LocalDateTime.now());
    	salemodelservice.saveSale(sale);
    	SaleModel saleModel = salemodelservice.saveSale(sale);
    	System.out.println("Saved Purchase ID: " + saleModel.getId());
    	long s__id=saleModel.getId();
        List<TempSaleDetailsModel>  temp_data = tempsaledetailsmodelservice.getAllTempData();
        
            System.out.print("TTTTTTTTssssTTTTTTTTTTTTTTTTTTTTTT");
            for(TempSaleDetailsModel i : temp_data)
            {    
//            	System.out.println(i);
//            	System.out.println("Total: " + i.getRateX_Q());
            	SaleDetailsModel saled= new  SaleDetailsModel();
            	saled.setItem(i.getItem());
            	saled.setItem_rate(i.getItem_rate());
            	saled.setQuantity(i.getQuantity());
            	saled.setStatus(1);
    	        
    	        SaleModel sm = salemodelservice.getSaleByID(s__id);
    	        saled.setSale(sm);
    	        saled.setDatetime(i.getDatetime());
    	        
    	        saledetailsmodelservice.saveSaleDetails(saled);
            }	
            tempsaledetailsmodelservice.deleteTemp_data();
        	
        }
        		
		return "redirect:sale_insert";
	}
	
	@GetMapping("/sale_view/{id}")
	public String saleView(@PathVariable Long id,Model model) {
		model.addAttribute("sale_basic",salemodelservice.getSaleByID(id));
		model.addAttribute("sale_details",saledetailsmodelservice.getSaleDetailsBySaleId(id));
		return "saleView";
	}
}