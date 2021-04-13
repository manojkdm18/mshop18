/**
 * 
 */
package com.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * @author manoj
 *
 */
public class CartItems implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cartRfnum;
	private Long productRfnum;
	private String productSku;
	private Long userRfnum;
	private String isActive;
	private Integer quantity;
	private Date createDate;
	private Date modifiedDate;
	private Integer createdby;
	private Integer modifiedby;
	public Long getCartRfnum() {
		return cartRfnum;
	}
	public void setCartRfnum(Long cartRfnum) {
		this.cartRfnum = cartRfnum;
	}
	public Long getProductRfnum() {
		return productRfnum;
	}
	public void setProductRfnum(Long productRfnum) {
		this.productRfnum = productRfnum;
	}
	public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public Long getUserRfnum() {
		return userRfnum;
	}
	public void setUserRfnum(Long userRfnum) {
		this.userRfnum = userRfnum;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
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
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public Integer getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
