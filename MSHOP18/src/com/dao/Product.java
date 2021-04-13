/**
 * 
 */
package com.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * @author manojkdm18
 *
 */
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long prfnum;
	private String productSku;
	private String productName;
	private String productDesc;
	private int quantity;
	private double price;
	private double discount;
	private double finalPay;

	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private String isActive;
	private SubCategory subcategory;
	private MshopCnd colour;
	private MshopCnd brand;
	private MshopCnd entity;

	public Long getPrfnum() {
		return prfnum;
	}

	public void setPrfnum(Long prfnum) {
		this.prfnum = prfnum;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPay() {
		return finalPay;
	}

	public void setFinalPay(double finalPay) {
		this.finalPay = finalPay;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public SubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public MshopCnd getColour() {
		return colour;
	}

	public void setColour(MshopCnd colour) {
		this.colour = colour;
	}

	public MshopCnd getBrand() {
		return brand;
	}

	public void setBrand(MshopCnd brand) {
		this.brand = brand;
	}

	public MshopCnd getEntity() {
		return entity;
	}

	public void setEntity(MshopCnd entity) {
		this.entity = entity;
	}

	public Product() {
		super();
	}

	public Product(Long prfnum, String productSku, String productName, String productDesc, int quantity, double price,
			double discount, double finalPay, String img1, String img2, String img3, String img4, Date createDate,
			Date modifiedDate, int createdby, int modifiedby, String isActive, SubCategory subcategory, MshopCnd colour,
			MshopCnd brand, MshopCnd entity) {
		super();
		this.prfnum = prfnum;
		this.productSku = productSku;
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.finalPay = finalPay;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.isActive = isActive;
		this.subcategory = subcategory;
		this.colour = colour;
		this.brand = brand;
		this.entity = entity;
	}

}
