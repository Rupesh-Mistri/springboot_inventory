package com.inventory.entity;

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
@Table(name="tbl_sale_details")
public class SaleDetailsModel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	

//	@Column(name="item_id")
//	private long item_id;
	
    @ManyToOne // Many Temp_purchase_details_model can have One item_model
    @JoinColumn(name = "item_id") // Name of foreign key column in the Temp_purchase_details table
    private item_model item; // Define the Many-to-One relationship

    @ManyToOne // Many Temp_purchase_details_model can have One item_model
    @JoinColumn(name = "sale_id") // Name of foreign key column in the Temp_purchase_details table
    private SaleModel sale; // Define the Many-to-One relationship
	
	@Column(name="item_rate")
	private int item_rate;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="datetime")
	private LocalDateTime datetime;
	
	@Column(name="status")
	private int status ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public item_model getItem() {
		return item;
	}

	public void setItem(item_model item) {
		this.item = item;
	}

	public SaleModel getSale() {
		return sale;
	}

	public void setSale(SaleModel sale) {
		this.sale = sale;
	}

	public int getItem_rate() {
		return item_rate;
	}

	public void setItem_rate(int item_rate) {
		this.item_rate = item_rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public SaleDetailsModel(item_model item, SaleModel sale, int item_rate, int quantity, LocalDateTime datetime,
			int status) {
		super();
		this.item = item;
		this.sale = sale;
		this.item_rate = item_rate;
		this.quantity = quantity;
		this.datetime = datetime;
		this.status = status;
	}

	public SaleDetailsModel() {
		
	}
}