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
public class StateMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int smrfnum;
	private String smname;
	private String smcode;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private boolean IsActive;
	private CountryMaster country;

	public int getSmrfnum() {
		return smrfnum;
	}

	public void setSmrfnum(int smrfnum) {
		this.smrfnum = smrfnum;
	}

	public String getSmname() {
		return smname;
	}

	public void setSmname(String smname) {
		this.smname = smname;
	}

	public String getSmcode() {
		return smcode;
	}

	public void setSmcode(String smcode) {
		this.smcode = smcode;
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

	

	public boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

	public CountryMaster getCountry() {
		return country;
	}

	public void setCountry(CountryMaster country) {
		this.country = country;
	}

	public StateMaster(int smrfnum, String smname, String smcode, Date createDate, Date modifiedDate, int createdby,
			int modifiedby, boolean isActive, CountryMaster country) {
		super();
		this.smrfnum = smrfnum;
		this.smname = smname;
		this.smcode = smcode;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.IsActive = isActive;
		this.country = country;
	}

	public StateMaster() {
		super();
	}

}
