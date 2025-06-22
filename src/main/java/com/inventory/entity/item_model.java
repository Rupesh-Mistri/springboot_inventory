package com.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_item")
public class item_model {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column(name="item_name",nullable=false)
	private String item_name;
	
	@Column(name="item_rate")
	private int item_rate;
	
	@Column(name="datetime")
	private LocalDateTime  datetime ;
	
	@Column(name="status")
	private int status;

	public long getId() {
		return id;
	}
	
	public item_model() {}
	
	public item_model(String item_name, int item_rate, LocalDateTime datetime, int status) {
		super();
		this.item_name = item_name;
		this.item_rate = item_rate;
		this.datetime = datetime;
		this.status = status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_rate() {
		return item_rate;
	}

	public void setItem_rate(int item_rate) {
		this.item_rate = item_rate;
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
	
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", item_rate='" + item_rate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
	
}
