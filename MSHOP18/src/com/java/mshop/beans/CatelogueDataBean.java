
package com.java.mshop.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dao.Category;
import com.dao.MshopBanner;
import com.dao.Product;
import com.dao.SubCategory;

public class CatelogueDataBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<MshopBanner> heroBanner_List = new ArrayList<>();
	private List<MshopBanner> adBanner_List = new ArrayList<>();
	private List<MshopBanner> thinbanner_List = new ArrayList<>();
	private List<Product> newArrProduct_List = new ArrayList<>();
	private List<Product> topSellProduct_List = new ArrayList<>();
	private List<Category> category_List = new ArrayList<>();
	private List<SubCategory> subCategory_List = new ArrayList<>();
	private List<Product> allProductList = new ArrayList<>();
	private Product product ;
	private List<MshopBanner> subBanner_List = new ArrayList<>();

	public List<MshopBanner> getHeroBanner_List() {
		return heroBanner_List;
	}

	public void setHeroBanner_List(List<MshopBanner> heroBanner_List) {
		this.heroBanner_List = heroBanner_List;
	}

	public List<MshopBanner> getAdBanner_List() {
		return adBanner_List;
	}

	public void setAdBanner_List(List<MshopBanner> adBanner_List) {
		this.adBanner_List = adBanner_List;
	}

	public List<MshopBanner> getThinbanner_List() {
		return thinbanner_List;
	}

	public void setThinbanner_List(List<MshopBanner> thinbanner_List) {
		this.thinbanner_List = thinbanner_List;
	}

	public List<Product> getNewArrProduct_List() {
		return newArrProduct_List;
	}

	public void setNewArrProduct_List(List<Product> newArrProduct_List) {
		this.newArrProduct_List = newArrProduct_List;
	}

	public List<Product> getTopSellProduct_List() {
		return topSellProduct_List;
	}

	public void setTopSellProduct_List(List<Product> topSellProduct_List) {
		this.topSellProduct_List = topSellProduct_List;
	}

	public List<Category> getCategory_List() {
		return category_List;
	}

	public void setCategory_List(List<Category> category_List) {
		this.category_List = category_List;
	}

	public List<SubCategory> getSubCategory_List() {
		return subCategory_List;
	}

	public void setSubCategory_List(List<SubCategory> subCategory_List) {
		this.subCategory_List = subCategory_List;
	}

	public List<Product> getAllProductList() {
		return allProductList;
	}

	public void setAllProductList(List<Product> allProductList) {
		this.allProductList = allProductList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<MshopBanner> getSubBanner_List() {
		return subBanner_List;
	}

	public void setSubBanner_List(List<MshopBanner> subBanner_List) {
		this.subBanner_List = subBanner_List;
	}
 
	
}
