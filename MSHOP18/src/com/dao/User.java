package com.dao;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Long userrfnum;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private String userType;
	private Date createDate;
	private Date modifiedDate;
	private int createdby;
	private int modifiedby;
	private boolean IsActive;
	private CountryMaster country;
	private StateMaster state;
	private CityMaster city;

	public Long getUserrfnum() {
		return userrfnum;
	}

	public void setUserrfnum(Long userrfnum) {
		this.userrfnum = userrfnum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public CityMaster getCity() {
		return city;
	}

	public void setCity(CityMaster city) {
		this.city = city;
	}

	public User(Long userrfnum, String firstName, String lastName, String mobile, String email, String password,
			String userType, Date createDate, Date modifiedDate, int createdby, int modifiedby, boolean isActive,
			CountryMaster country, StateMaster state, CityMaster city) {
		super();
		this.userrfnum = userrfnum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.IsActive = isActive;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	public User() {
		super();
	}

}
