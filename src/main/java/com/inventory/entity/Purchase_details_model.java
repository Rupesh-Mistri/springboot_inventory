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
@Table(name="tbl_purchase_details")
public class Purchase_details_model {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	

//	@Column(name="item_id")
//	private long item_id;
	
    @ManyToOne // Many Temp_purchase_details_model can have One item_model
    @JoinColumn(name = "item_id") // Name of foreign key column in the Temp_purchase_details table
    private item_model item; // Define the Many-to-One relationship

    @ManyToOne // Many Temp_purchase_details_model can have One item_model
    @JoinColumn(name = "purchase_id") // Name of foreign key column in the Temp_purchase_details table
    private Purchase_model purchase; // Define the Many-to-One relationship
	
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

	public item_model getItem_id() {
		return item;
	}

	public void setItem_id(item_model  item) {
		this.item = item;
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
	
	public int getRateX_Q() {
		 return this.quantity * this.item_rate;
	}
	
	public Purchase_model getPurchase_id() {
		return purchase;
	}

	public void setPurchase_id(Purchase_model  purchase) {
		this.purchase = purchase;
	}

//	 @Override
//	    public String toString() {
//	        return "TempData{" +
//	                "id=" + id +
//	                ", item='" + item.id + '\'' +
//	                ", item_rate='" + item_rate + '\'' +
//	                ", quantity='" + quantity + '\'' +
//	                '}';
//	    }

	@Override
	public String toString() {
	    String itemId = (item != null) ? String.valueOf(item.getId()) : "N/A";
	    String purchaseId = (purchase != null) ? String.valueOf(purchase.getId()) : "N/A";
	    return "TempData{" +
	            "id=" + id +
	            ", item_id='" + itemId + '\'' +
	            ", item_rate='" + item_rate + '\'' +
	            ", quantity='" + quantity + '\'' +
	            ", purchase='" + purchaseId + '\'' +
	            '}';
	}

public Purchase_details_model(item_model item, int item_rate, int quantity, LocalDateTime datetime, int status,Purchase_model purchase) {
	super();
	this.item = item;
	this.item_rate = item_rate;
	this.quantity = quantity;
	this.datetime = datetime;
	this.status = status;
	this.purchase=purchase;
}

public Purchase_details_model()	{}
	
}
