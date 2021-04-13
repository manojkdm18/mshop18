package com.java.mshop.beans;

import java.io.Serializable;

public class ProductUploadDataBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productSku;
	private String productName;
	private String productDesc;
	private String quantity;
	private String price;
	private String discount;
	private String colour;
	private String brand;
	private String entity;
	private String subcategory;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String isActive;
	
	
	public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	@Override
	public String toString() {
		return "ProductUploadDataBean [productSku=" + productSku + ", productName=" + productName + ", productDesc="
				+ productDesc + ", quantity=" + quantity + ", price=" + price + ", discount=" + discount + ", colour="
				+ colour + ", brand=" + brand + ", entity=" + entity + ", subcategory=" + subcategory + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", isActive=" + isActive + "]";
	}
	
	

}
