package com.java.mshop.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.java.mshop.displaybean.productManagementDispBean;

public class ProductManagementBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prfnum;
	private String productSku;
	private String productName;
	private String productDesc;
	private String quantity;
	private String price;
	private String discount;
	private String finalPay;
	private String colour;
	private String brand;
	private String entity;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String isActive;
	private String message;
	private boolean status;
	private int count = 0;
	private int totalNumberOfrecords = 0;
	private String subcatrfnum;
    
    private Part uploadedFile;
	
	private List<CommonOptionBean> subcat_List = new ArrayList<>();

	List<productManagementDispBean> displist = new ArrayList<productManagementDispBean>();
	
	private List<CommonOptionBean> product_List = new ArrayList<>();
    private String productRfnum;
    private List<CommonOptionBean> cndcolor_List = new ArrayList<>();
    private List<CommonOptionBean> cndbrand_List = new ArrayList<>();
    private List<CommonOptionBean> cndentity_List = new ArrayList<>();
    
    

	public String getPrfnum() {
		return prfnum;
	}

	public void setPrfnum(String prfnum) {
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

	public String getFinalPay() {
		return finalPay;
	}

	public void setFinalPay(String finalPay) {
		this.finalPay = finalPay;
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


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalNumberOfrecords() {
		return totalNumberOfrecords;
	}

	public void setTotalNumberOfrecords(int totalNumberOfrecords) {
		this.totalNumberOfrecords = totalNumberOfrecords;
	}

	public String getSubcatrfnum() {
		return subcatrfnum;
	}

	public void setSubcatrfnum(String subcatrfnum) {
		this.subcatrfnum = subcatrfnum;
	}

	public List<CommonOptionBean> getSubcat_List() {
		return subcat_List;
	}

	public void setSubcat_List(List<CommonOptionBean> subcat_List) {
		this.subcat_List = subcat_List;
	}

	public List<productManagementDispBean> getDisplist() {
		return displist;
	}

	public void setDisplist(List<productManagementDispBean> displist) {
		this.displist = displist;
	}

	
	public ProductManagementBean() {
		super();
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public List<CommonOptionBean> getProduct_List() {
		return product_List;
	}

	public void setProduct_List(List<CommonOptionBean> product_List) {
		this.product_List = product_List;
	}

	public String getProductRfnum() {
		return productRfnum;
	}

	public void setProductRfnum(String productRfnum) {
		this.productRfnum = productRfnum;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public List<CommonOptionBean> getCndcolor_List() {
		return cndcolor_List;
	}

	public void setCndcolor_List(List<CommonOptionBean> cndcolor_List) {
		this.cndcolor_List = cndcolor_List;
	}

	public List<CommonOptionBean> getCndbrand_List() {
		return cndbrand_List;
	}

	public void setCndbrand_List(List<CommonOptionBean> cndbrand_List) {
		this.cndbrand_List = cndbrand_List;
	}

	public List<CommonOptionBean> getCndentity_List() {
		return cndentity_List;
	}

	public void setCndentity_List(List<CommonOptionBean> cndentity_List) {
		this.cndentity_List = cndentity_List;
	}
	
	

}
