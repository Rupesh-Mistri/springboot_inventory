package com.inventory.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="tbl_sale")
public class SaleModel {
	@Id
	  @GeneratedValue(strategy =GenerationType.IDENTITY)
	  private long id;
	  
	  @Column(name="invoice_no")
	  private String invoice_no;
	  
	//  @Column(name="supplier_id")
	//  private long supplier_id; 
	  
//	  @ManyToOne
	  @Column(name="customer_name")
	  private String customer_name;
	  
	  @Column(name="invoice_date")
	  private LocalDate invoice_date;
	  
	  
	  @Column(name="datetime")
	  private LocalDateTime datetime;
	 
	  @Column(name="status")
	  private int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public LocalDate getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(LocalDate invoice_date) {
		this.invoice_date = invoice_date;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public SaleModel(String invoice_no, String customer_name, LocalDate invoice_date, LocalDateTime datetime,
			int status) {
		super();
		this.invoice_no = invoice_no;
		this.customer_name = customer_name;
		this.invoice_date = invoice_date;
		this.datetime = datetime;
		this.status = status;
	}
	  
	public   SaleModel() {}
}