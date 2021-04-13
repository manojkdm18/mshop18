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
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long addrfnum;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String addressType;
	private String landmark;
	private Long pincode;
	private Date createDate;
	private Date modifiedDate;
	private Integer createdby;
	private Integer modifiedby;
	private String IsActive;
	private String IsDefault;
	private CountryMaster country;
	private StateMaster state;
	private CityMaster city;
	private User userrfnum;
	public Long getAddrfnum() {
		return addrfnum;
	}
	public void setAddrfnum(Long addrfnum) {
		this.addrfnum = addrfnum;
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
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
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
	public User getUserrfnum() {
		return userrfnum;
	}
	public void setUserrfnum(User userrfnum) {
		this.userrfnum = userrfnum;
	}
	public String getIsDefault() {
		return IsDefault;
	}
	public void setIsDefault(String isDefault) {
		IsDefault = isDefault;
	}
	
	
}
