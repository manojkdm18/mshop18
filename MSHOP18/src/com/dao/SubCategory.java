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
public class SubCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long scrfnum;
	private String subcatName;
	private String subcatdesc;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private String isActive;
	private Category category;

	public SubCategory() {
		super();
	}

	public Long getScrfnum() {
		return scrfnum;
	}

	public void setScrfnum(Long scrfnum) {
		this.scrfnum = scrfnum;
	}

	public String getSubcatName() {
		return subcatName;
	}

	public void setSubcatName(String subcatName) {
		this.subcatName = subcatName;
	}

	public String getSubcatdesc() {
		return subcatdesc;
	}

	public void setSubcatdesc(String subcatdesc) {
		this.subcatdesc = subcatdesc;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory(Long scrfnum, String subcatName, String subcatdesc, Date createDate, Date modifiedDate,
			int createdby, int modifiedby, String isActive, Category category) {
		super();
		this.scrfnum = scrfnum;
		this.subcatName = subcatName;
		this.subcatdesc = subcatdesc;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.isActive = isActive;
		this.category = category;
	}

   
}
