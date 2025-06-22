package com.inventory.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.service.Purchase_details_model_Service;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ReportController {

	private Purchase_details_model_Service purchase_details_model_Service;
	
	public ReportController(Purchase_details_model_Service purchase_details_model_Service) {
		super();
		this.purchase_details_model_Service = purchase_details_model_Service;
	}

	@GetMapping("/report")
	public String report(Model model) {
//		model.addAttribute("report_data", "");
		return "report";
	}
	
	@PostMapping("/report")
	public List<Object[]> reportPost(Model model,@RequestBody Map<String, Object>  request) {
		String fromdate=(String) request.get("from_date");
		String todate=(String) request.get("to_date");
		System.out.println("fromdate"+fromdate);
		System.out.println("todate"+todate);
		
		model.addAttribute("fromdate", fromdate);
		model.addAttribute("todate", todate);
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		    LocalDate startDate = LocalDate.parse(fromdate, formatter);
		    LocalDate endDate = LocalDate.parse(todate, formatter);
		    System.out.println("Date1"+startDate);
		List<Object[]> ret = purchase_details_model_Service.getReportStockData();
//		List<Object[]> ret = purchase_details_model_Service.getStockReportByPram(startDate,endDate);
		for (Object[] re : ret) {
//		    Long itemId = (Long) re[0];
//		    String itemName = (String) re[1];
//		    Integer purQty = (Integer) re[2];
//		    Integer saleQty = (Integer) re[3];
//		    Integer avail = (Integer) re[4];

		    System.out.println("itemId: " + re[0]);
		}
		model.addAttribute("report_data", ret);
//		redirectAttributes.addFlashAttribute("successMessage", "Successfully Generated");
		return ret;
	}
}
