package com.dao;

import java.io.Serializable;
import java.util.Date;

public class MshopCnd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cndrfnum;
	private String cndname;
	private String cndcode;
	private String cndgroup;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private String isActive;
	
	
	public MshopCnd() {
		super();
	}
	public MshopCnd(Long cndrfnum, String cndname, String cndcode, String cndgroup, Date createDate, Date modifiedDate,
			int createdby, int modifiedby, String isActive) {
		super();
		this.cndrfnum = cndrfnum;
		this.cndname = cndname;
		this.cndcode = cndcode;
		this.cndgroup = cndgroup;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.isActive = isActive;
	}
	public Long getCndrfnum() {
		return cndrfnum;
	}
	public void setCndrfnum(Long cndrfnum) {
		this.cndrfnum = cndrfnum;
	}
	public String getCndname() {
		return cndname;
	}
	public void setCndname(String cndname) {
		this.cndname = cndname;
	}
	public String getCndcode() {
		return cndcode;
	}
	public void setCndcode(String cndcode) {
		this.cndcode = cndcode;
	}
	public String getCndgroup() {
		return cndgroup;
	}
	public void setCndgroup(String cndgroup) {
		this.cndgroup = cndgroup;
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
	
	
	
}
