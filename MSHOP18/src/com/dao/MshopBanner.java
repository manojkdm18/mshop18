package com.dao;

import java.io.Serializable;
import java.util.Date;

public class MshopBanner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long brfnum;
	private String url;
	private String sequence;
	private String theme;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private String isActive;
	private MshopCnd type;

	public Long getBrfnum() {
		return brfnum;
	}

	public void setBrfnum(Long brfnum) {
		this.brfnum = brfnum;
	}

	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
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

	public MshopCnd getType() {
		return type;
	}

	public void setType(MshopCnd type) {
		this.type = type;
	}

	
	public MshopBanner(Long brfnum, String url, String sequence, String theme, Date createDate, Date modifiedDate,
			int createdby, int modifiedby, String isActive, MshopCnd type) {
		super();
		this.brfnum = brfnum;
		this.url = url;
		this.sequence = sequence;
		this.theme = theme;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.isActive = isActive;
		this.type = type;
	}

	public MshopBanner() {
		super();
	}

}
