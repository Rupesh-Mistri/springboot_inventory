package com.inventory.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_purchase")
public class Purchase_model {
  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  private long id;
  
  @Column(name="invoice_no")
  private String invoice_no;
  
//  @Column(name="supplier_id")
//  private long supplier_id; 
  @ManyToOne // Many Temp_purchase_details_model can have One item_model
  @JoinColumn(name = "supplier_id") // Name of foreign key column in the Temp_purchase_details table
  private Supplier_model supplier_id; // Define the Many-to-One relationship
  
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



public Supplier_model getSupplier_id() {
	return supplier_id;
}



public void setSupplier_id(Supplier_model supplier_id) {
	this.supplier_id = supplier_id;
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




public Purchase_model(String invoice_no, Supplier_model supplier_id, LocalDate invoice_date, LocalDateTime datetime, int status) {
	super();
	this.invoice_no = invoice_no;
	this.supplier_id = supplier_id;
	this.invoice_date = invoice_date;
	this.datetime = datetime;
	this.status = status;
}



public Purchase_model() {}
}
