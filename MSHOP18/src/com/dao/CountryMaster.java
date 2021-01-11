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
public class CountryMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cmrfnum;
	private String countryName;
	private String countryCode;
	private Date createDate;
	private int createdby;
	private int modifiedby;
	private Date modifiedDate;
	private boolean IsActive;

	public int getCmrfnum() {
		return cmrfnum;
	}

	public void setCmrfnum(int cmrfnum) {
		this.cmrfnum = cmrfnum;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCcode) {
		this.countryCode = countryCcode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		this.IsActive = isActive;
	}

	public CountryMaster(int cmrfnum, String countryName, String countryCcode, Date createDate, int createdby,
			int modifiedby, Date modifiedDate, boolean isActive) {
		super();
		this.cmrfnum = cmrfnum;
		this.countryName = countryName;
		this.countryCode = countryCcode;
		this.createDate = createDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.modifiedDate = modifiedDate;
		this.IsActive = isActive;
	}

	public CountryMaster() {
		super();
	}

}
