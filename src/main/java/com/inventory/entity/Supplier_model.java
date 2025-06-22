package com.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_supplier")
public class Supplier_model {

@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private long id;

@Column
private String supplier_name ;

@Column 
private String address;

@Column 
private String email;

@Column 
private String mobile;


public Supplier_model(){
	
}


public Supplier_model(long id, String supplier_name, String address, String email, String mobile) {
	super();
	this.supplier_name = supplier_name;
	this.address = address;
	this.email = email;
	this.mobile = mobile;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getSupplier_name() {
	return supplier_name;
}

public void setSupplier_name(String supplier_name) {
	this.supplier_name = supplier_name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

@Override
public String toString() {
    return "Item{" +
            "id=" + id +
            ", supplier_name='" + supplier_name + '\'' +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            ", mobile='" + mobile + '\'' +
            '}';
}


}
