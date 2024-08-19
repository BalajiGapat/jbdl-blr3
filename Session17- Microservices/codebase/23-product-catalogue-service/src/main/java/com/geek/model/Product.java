package com.geek.model;
public class Product {
private int id;
private String prodName;
private float price;
private int portNo;
public Product() {
	// TODO Auto-generated constructor stub
}

public Product(int id, String prodName, float price) {
	super();
	this.id = id;
	this.prodName = prodName;
	this.price = price;
}

public Product(int id, String prodName, float price, int portNo) {
	super();
	this.id = id;
	this.prodName = prodName;
	this.price = price;
	this.portNo = portNo;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getPortNo() {
	return portNo;
}
public void setPortNo(int portNo) {
	this.portNo = portNo;
}

}
