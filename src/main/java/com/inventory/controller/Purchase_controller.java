package com.inventory.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
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
import com.inventory.entity.Supplier_model;
import com.inventory.entity.Temp_purchase_details_model;
import com.inventory.entity.item_model;
import com.inventory.service.Purchase_details_model_Service;
import com.inventory.service.Purchase_model_Service;
import com.inventory.service.Supplier_model_Service;
import com.inventory.service.Temp_purchase_details_model_Service;
import com.inventory.service.item_mode_Service;

import jakarta.servlet.http.HttpServletRequest;

//@Controller
@RestController
public class Purchase_controller {
	
	private item_mode_Service  item_mode_service;
	
	private  Temp_purchase_details_model_Service temp_purchase_details_model_Service;
	
	private Purchase_model_Service purchase_model_Service;

	private Purchase_details_model_Service purchase_details_model_Service;
	
	private Supplier_model_Service supplier_model_Service;

	public Purchase_controller(item_mode_Service item_mode_service,
			Temp_purchase_details_model_Service temp_purchase_details_model_Service,
			Purchase_model_Service purchase_model_Service,Purchase_details_model_Service purchase_details_model_Service,
			Supplier_model_Service supplier_model_Service) {
		super();
		this.item_mode_service = item_mode_service;
		this.temp_purchase_details_model_Service = temp_purchase_details_model_Service;
		this.purchase_model_Service=purchase_model_Service;
		this.purchase_details_model_Service=purchase_details_model_Service;
		this.supplier_model_Service=supplier_model_Service;
	}

	@GetMapping("/purchase_list")
	public List<Purchase_model> purchase_list(Model model)
	{	List<Purchase_model> purm=purchase_model_Service.getAllPurchase();
		
		model.addAttribute("puchase_list",purchase_model_Service.getAllPurchase());
		return purm;
	}
	
	@GetMapping("/purchase_insert")
    public List<Temp_purchase_details_model>  purchase_insert(Model model) {
//        Temp_purchase_details_model temp = new Temp_purchase_details_model(0, 0, 0, null, 0);
//        long l = 1;
//        temp.setItem_id(l);
//        temp.setItem_rate(3);
//        temp.setQuantity(5);
//        temp.setStatus(1);
//        LocalDateTime datetime = java.time.LocalDateTime.now();
//        temp.setDatetime(datetime);
        
        model.addAttribute("item_list",item_mode_service.getAll_Item());
        
        
//        model.addAttribute("tempPurchase", temp);
//        temp_purchase_details_model_Service.saveTempData(temp);
        
        
      List<Temp_purchase_details_model>  temp_data = temp_purchase_details_model_Service.getAllTempData();
      
      System.out.print("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
      for(Temp_purchase_details_model i : temp_data)
      {
      	System.out.println(i);
      	System.out.println("Total: " + i.getRateX_Q());
      }
      
      List<Supplier_model>  stemp_data = supplier_model_Service.getAllSupplier();
      
      System.out.print("ssssssssupl");
      for(Supplier_model i : stemp_data)
      {
      	System.out.println(i);
      	System.out.println("Supplier Id: " + i.getId());
      }
      
      
      model.addAttribute("temp_item_list",temp_purchase_details_model_Service.getAllTempData());
      model.addAttribute("supplier_list",supplier_model_Service.getAllSupplier()); 
      List<Temp_purchase_details_model> temp_item_list	=		temp_purchase_details_model_Service.getAllTempData();
//        return "purchase_insert";
       return temp_item_list;
    }
	
	@PostMapping("/purchase_insert")
//  public String purchase_insertPost(Model model,HttpServletRequest request) {
	public List<Temp_purchase_details_model> purchase_insertPost(Model model,@RequestBody Map<String, Object> request) {
      String addbtn=(String)request.get("ADD");
      String savebtn=(String)request.get("SAVE");
      Temp_purchase_details_model temp = new Temp_purchase_details_model();
      
      System.out.println("ADD BTN"+addbtn);
      System.out.println("SAVE BTN"+savebtn);
      if ("ADD".equals(addbtn))//if (addbtn !=null || addbtn !="")
      {	System.out.print("ADD button clicked");
//          long item_id= Integer.parseInt(request.get("item_name");
//          int item_rate= Integer.parseInt(request.getParameter("item_rate"));
//          int item_quantity= Integer.parseInt(request.getParameter("quantity"));
      	
//      	item_model itemr= request.getItem_id();
//      	long item_id= itemr.getId();
//          int item_rate= request.getItem_rate();
//          int item_quantity= request.getQuantity();
    	  
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
      	
	        temp.setItem_id(item);
	        temp.setItem_rate(item_rate);
	        temp.setQuantity(item_quantity);
	        temp.setStatus(1);
	        LocalDateTime datetime = java.time.LocalDateTime.now();
	        temp.setDatetime(datetime);
	        model.addAttribute("tempPurchase", temp);
	        model.addAttribute("itemRate",item_rate);
	        Temp_purchase_details_model temdata= temp_purchase_details_model_Service.saveTempData(temp);
	        System.out.print("code9");
	        System.out.print("tempitm"+temdata.getId());
	        /////////////////////////
//	        Purchase_details_model purd= new  Purchase_details_model();
//	        purd.setItem_id(item);
//	        purd.setItem_rate(item_rate);
//	        purd.setQuantity(item_quantity);
//	        purd.setStatus(1);
//	        purd.setDatetime(datetime);
//	        purchase_details_model_Service.savePurchase_Details(purd);
	        
//	        model.addAttribute("temp_item_list",temp_purchase_details_model_Service.getAllTempData());
	        
      }
      
      else//if( savebtn!=null || savebtn!="")
      { 	System.out.print("SAVE button clicked");
      	Purchase_model pur= new Purchase_model();
      	
//      	String invoice_no=request.getParameter("invoice_no");	
//      	String invoice_date=request.getParameter("invoice_date");
//      	int supplier_id= Integer.parseInt(request.getParameter("supplier_id"));
         	String invoice_no=(String) request.get("invoice_no");	
      	String invoice_date=(String) request.get("invoice_date");
      	int supplier_id= Integer.parseInt((String) request.get("supplier_name"));
      	
      	Supplier_model supl =supplier_model_Service.getSupplierById(supplier_id);
      	
      	System.out.print(invoice_date);
      	pur.setInvoice_no(invoice_no);
      	pur.setInvoice_date(LocalDate.parse(invoice_date));
      	pur.setSupplier_id(supl);
      	pur.setStatus(1);
      	pur.setDatetime(java.time.LocalDateTime.now());
      	purchase_model_Service.savePurchaseD(pur);
      	Purchase_model purchase_model = purchase_model_Service.savePurchaseD(pur);
      	System.out.println("Saved Purchase ID: " + purchase_model.getId());
      	long p__id=purchase_model.getId();
          List<Temp_purchase_details_model>  temp_data = temp_purchase_details_model_Service.getAllTempData();
          
          System.out.print("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
          for(Temp_purchase_details_model i : temp_data)
          {    
//          	System.out.println(i);
//          	System.out.println("Total: " + i.getRateX_Q());
          	Purchase_details_model purd= new  Purchase_details_model();
  	        purd.setItem_id(i.getItem_id());
  	        purd.setItem_rate(i.getItem_rate());
  	        purd.setQuantity(i.getQuantity());
  	        purd.setStatus(1);
  	        
  	        Purchase_model pm = purchase_model_Service.getPurchaseByID(p__id);
  	        purd.setPurchase_id(pm);
  	        purd.setDatetime(i.getDatetime());
  	        
  	        purchase_details_model_Service.savePurchase_Details(purd);
          }	
          temp_purchase_details_model_Service.deleteTemp_data();
      	
      }
      
      
//      List<Temp_purchase_details_model>  temp_data = temp_purchase_details_model_Service.getAllTempData();
//      
//      System.out.print("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//      for(Temp_purchase_details_model i : temp_data)
//      {
//      	System.out.println(i);
//      }
//      
      List<Temp_purchase_details_model> temp_item_list	=		temp_purchase_details_model_Service.getAllTempData();
//      model.addAttribute("temp_item_list",temp_purchase_details_model_Service.getAllTempData());
//      return "redirect:purchase_insert";
      	return temp_item_list;
  }
	
	@GetMapping("/purchase_view/{id}")
	public Map<String, Object> purchaseView(@PathVariable Long id,Model model) {
		
//		model.addAttribute("puchase_basic",purchase_model_Service.getPurchaseByID(id));
//		model.addAttribute("puchase_details",purchase_details_model_Service.getPurchaseDetailsByPurchaseId(id));
		
		Purchase_model puchase_basic=purchase_model_Service.getPurchaseByID(id);	
//      List<Purchase_details_model>  pur_details = purchase_details_model_Service.getPurchaseDetailsByPurchaseId(id);
      
        Map<String, Object> response = new HashMap<>();
        
        List<Purchase_model> purchaseBasicList = Collections.singletonList(puchase_basic);
        response.put("purchase_basic", purchaseBasicList);
//        response.put("purchase_basic", purchase_model_Service.getPurchaseByID(id));
        response.put("purchase_details", purchase_details_model_Service.getPurchaseDetailsByPurchaseId(id));

        return response;

	}
}