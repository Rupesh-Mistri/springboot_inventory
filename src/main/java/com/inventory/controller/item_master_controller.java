package com.inventory.controller;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.entity.item_model;
import com.inventory.service.item_mode_Service;

import jakarta.servlet.http.HttpServletRequest;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class item_master_controller {

	private item_mode_Service item_mode_service;

	public item_master_controller(item_mode_Service item_mode_service) {
		super();
		this.item_mode_service = item_mode_service;
	}

	@GetMapping("/hello")
	public String sayHell() {
		return "Hell Rupesh";
	}

	@GetMapping("/")
	public String Index() {
		return "index";
	}

	// @GetMapping("/item_list")
	// public String item_list(Model model) {
	// System.out.println("Print all item records");

	// List<item_model> items = item_mode_service.getAll_Item();
	// for (item_model temp_item : items) {
	// System.out.println(temp_item);
	// }

	// model.addAttribute("item_list", item_mode_service.getAll_Item());
	// return "item_list";

	// }

	@GetMapping("/item_list")
	// @CrossOrigin(origins = "http://localhost:3000")
	public List<item_model> item_list(Model model) {
		System.out.println("Print all item records");

		List<item_model> items = item_mode_service.getAll_Item();
		for (item_model temp_item : items) {
			System.out.println(temp_item);
		}

		// model.addAttribute("item_list",item_mode_service.getAll_Item());
		return items;

	}

	@GetMapping("/item_insert")
	public String item_insert(Model model) {
		System.out.print("Item insert");
		model.addAttribute("item_name", ""); // Add an empty string or default value
		model.addAttribute("item_rate", "");
		return "item_insert";
	}

	// @GetMapping("/item_insert")
	// public String item_insert(Model model)
	// { System.out.print("Item insert");
	// model.addAttribute("item_name", ""); // Add an empty string or default value
	// model.addAttribute("item_rate", "");
	// return "item_insert";
	// }

	@PostMapping("/item_insertp")
	public String item_insertPost(@RequestBody item_model request) {
		System.out.print("Item insert post");

		String item_name = request.getItem_name();
		System.out.print("item_name1:" + item_name);
		int item_rate = request.getItem_rate();

		item_model itm = new item_model();
		itm.setItem_name(item_name);
		itm.setItem_rate(item_rate);
		itm.setStatus(1);
		LocalDateTime datetime = java.time.LocalDateTime.now();
		itm.setDatetime(datetime);

		item_mode_service.saveItem(itm);

		return "successfull";
	}

	// @PostMapping("/item_insertp")
	// public ResponseEntity<String> itemInsertPost(@RequestBody item_model
	// itemRequest) {
	// System.out.println("Item insert post");
	//
	// String itemName = itemRequest.getItemName();
	// int itemRate = itemRequest.getItemRate();
	//
	// item_model itm = new item_model();
	// itm.setItem_name(itemName);
	// itm.setItem_rate(itemRate);
	// itm.setStatus(1);
	// LocalDateTime datetime = java.time.LocalDateTime.now();
	// itm.setDatetime(datetime);
	//
	// item_mode_service.saveItem(itm);
	//
	// return ResponseEntity.ok("Item inserted successfully");
	// }

	// @PostMapping("/item_insertp")
	// @CrossOrigin(origins = "http://localhost:3000")
	// public item_model createItem(@RequestBody item_model item) {
	// System.out.println("Item insert");
	// String itemName = item.getItem_name();
	// System.out.println("Item name: " + itemName);
	// return item_mode_service.saveItem(item);
	// }

	@GetMapping("/item_edit/{id}")
	public item_model item_editGet(@PathVariable Long id, Model model) {
		item_model item = item_mode_service.getItemById(id);
		model.addAttribute("item_details", item_mode_service.getItemById(id));
		return item;
	}

	@PutMapping("/item_edit/{id}")
	public String item_editPost(@PathVariable Long id, @RequestBody item_model request) {
		System.out.print("Item updateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		System.out.print("id" + id);
		String item_name = request.getItem_name();
		System.out.print("item_name1:" + item_name);
		int item_rate = request.getItem_rate();

		item_model itm = item_mode_service.getItemById(id);
		itm.setItem_name(item_name);
		itm.setItem_rate(item_rate);
		itm.setStatus(1);
		LocalDateTime datetime = java.time.LocalDateTime.now();
		itm.setDatetime(datetime);

		item_mode_service.UpdateItem(itm);
		// /redirectAttributes.addFlashAttribute("successMessage", "Student saved
		// successfully");
		return "{\"status\":\"Successfully Updated\"}";
	}

	// @GetMapping("item_delete/{id}")
	// public String item_delete(@PathVariable Long id,RedirectAttributes
	// redirectAttributes)
	// {
	// item_model itm= item_mode_service.getItemById(id);
	// itm.setStatus(0);
	// item_mode_service.UpdateItem(itm);
	//// item_mode_service.deleteItem(id);
	// redirectAttributes.addFlashAttribute("successMessage", "Student deleted
	// successfully");
	// return "{\"status\":\"Successfully Deleted\"}";
	// }

	@DeleteMapping("item_delete/{id}")
	public String item_delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		// item_model itm= item_mode_service.getItemById(id);
		// itm.setStatus(0);
		// item_mode_service.UpdateItem(itm);
		item_mode_service.deleteItem(id);
		redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully");
		return "{\"status\":\"Successfully Deleted\"}";
	}
}
