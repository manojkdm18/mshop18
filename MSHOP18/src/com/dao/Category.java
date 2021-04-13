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
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long catrfnum;
	private String catName;
	private String cdesc;
	private String isActive;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	public Long getCatrfnum() {
		return catrfnum;
	}
	public void setCatrfnum(Long catrfnum) {
		this.catrfnum = catrfnum;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
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
	@Override
	public String toString() {
		return "Category [catrfnum=" + catrfnum + ", catName=" + catName + ", cdesc=" + cdesc + ", isActive=" + isActive
				+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", createdby=" + createdby
				+ ", modifiedby=" + modifiedby + "]";
	}
    
	
   
}
