package com.java.mshop.beans;

import java.util.ArrayList;
import java.util.List;

import com.java.mshop.displaybean.UserDisplayBean;


public class UserManagementBean {
	private String userRfnum;
	/* search filed */
	private String sfirstName;
	private String slastName;
	private String smobile;
	private String semailId;
	/*create field */
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String upassword;
	private String userType;
	private String isActive;
	private String message;
	private boolean status;
	private String countryrfnum;
	private String staterfnum;
	private String cityrfnum;
	
	private int count =0;
	private int totalNumberOfrecords =0;

	
	private List<CommonOptionBean> country_List = new ArrayList<>();
	private List<CommonOptionBean> state_List = new ArrayList<>();
	private List<CommonOptionBean> city_List=new ArrayList<>();
	List<UserDisplayBean> displist = new ArrayList<UserDisplayBean>();

	public String getUserRfnum() {
		return userRfnum;
	}
	public void setUserRfnum(String userRfnum) {
		this.userRfnum = userRfnum;
	}
	public String getSfirstName() {
		return sfirstName;
	}
	public void setSfirstName(String sfirstName) {
		this.sfirstName = sfirstName;
	}
	public String getSlastName() {
		return slastName;
	}
	public void setSlastName(String slastName) {
		this.slastName = slastName;
	}
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	public String getSemailId() {
		return semailId;
	}
	public void setSemailId(String semailId) {
		this.semailId = semailId;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCountryrfnum() {
		return countryrfnum;
	}
	public void setCountryrfnum(String countryrfnum) {
		this.countryrfnum = countryrfnum;
	}
	public String getStaterfnum() {
		return staterfnum;
	}
	public void setStaterfnum(String staterfnum) {
		this.staterfnum = staterfnum;
	}
	public String getCityrfnum() {
		return cityrfnum;
	}
	public void setCityrfnum(String cityrfnum) {
		this.cityrfnum = cityrfnum;
	}
	public List<CommonOptionBean> getCountry_List() {
		return country_List;
	}
	public void setCountry_List(List<CommonOptionBean> country_List) {
		this.country_List = country_List;
	}
	public List<CommonOptionBean> getState_List() {
		return state_List;
	}
	public void setState_List(List<CommonOptionBean> state_List) {
		this.state_List = state_List;
	}
	public List<CommonOptionBean> getCity_List() {
		return city_List;
	}
	public void setCity_List(List<CommonOptionBean> city_List) {
		this.city_List = city_List;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<UserDisplayBean> getDisplist() {
		return displist;
	}
	public void setDisplist(List<UserDisplayBean> displist) {
		this.displist = displist;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalNumberOfrecords() {
		return totalNumberOfrecords;
	}
	public void setTotalNumberOfrecords(int totalNumberOfrecords) {
		this.totalNumberOfrecords = totalNumberOfrecords;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
