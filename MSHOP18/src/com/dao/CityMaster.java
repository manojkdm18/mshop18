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
public class CityMaster implements Serializable {

	private int cityrfnum;
	private String cityname;
	private String citycode;
	private Long pincode;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private boolean IsActive;
	private CountryMaster country;
	private StateMaster state;

	public int getCityrfnum() {
		return cityrfnum;
	}

	public void setCityrfnum(int cityrfnum) {
		this.cityrfnum = cityrfnum;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
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
		this.IsActive = isActive;
	}

	public CountryMaster getCountry() {
		return country;
	}

	public void setCountry(CountryMaster country) {
		this.country = country;
	}

	public StateMaster getState() {
		return state;
	}

	public void setState(StateMaster state) {
		this.state = state;
	}

	public CityMaster(int cityrfnum, String cityname, String citycode, Long pincode, Date createDate, Date modifiedDate,
			int createdby, int modifiedby, boolean isActive, CountryMaster country, StateMaster state) {
		super();
		this.cityrfnum = cityrfnum;
		this.cityname = cityname;
		this.citycode = citycode;
		this.pincode = pincode;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.IsActive = isActive;
		this.country = country;
		this.state = state;
	}

	public CityMaster() {
		super();
	}

}
