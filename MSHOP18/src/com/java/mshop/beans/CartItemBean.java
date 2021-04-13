package com.java.mshop.beans;

import java.io.Serializable;

import com.dao.Product;

public class CartItemBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDisplayBean productBean;
	private String subtotal;
	private String total;
	private String cartSize;
	private String message;
	private String quantity;

	public ProductDisplayBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductDisplayBean productBean) {
		this.productBean = productBean;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCartSize() {
		return cartSize;
	}

	public void setCartSize(String cartSize) {
		this.cartSize = cartSize;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantiy) {
		this.quantity = quantiy;
	}

	
}
