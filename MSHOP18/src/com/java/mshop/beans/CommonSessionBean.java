package com.java.mshop.beans;

import java.util.ArrayList;
import java.util.List;

public class CommonSessionBean {

	private String userRfnum ;
	private String userFirstName ;
	private String userLastName ;
	private String userType ;
	private String userEmail ;
	private String userLoginId ;
	private List<CartItemBean> cartItemList = new ArrayList();
	private String sessionId ;
	private String loginTime ;
	private String logoutTime ;
	private String message ;
	private String status ;
	private CatelogueDataBean catelogueData = new CatelogueDataBean() ;
	private String cartSize;
	
	public String getUserRfnum() {
		return userRfnum;
	}
	public void setUserRfnum(String userRfnum) {
		this.userRfnum = userRfnum;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public List<CartItemBean> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItemBean> cartItemList) {
		this.cartItemList = cartItemList;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CatelogueDataBean getCatelogueData() {
		return catelogueData;
	}
	public void setCatelogueData(CatelogueDataBean catelogueData) {
		this.catelogueData = catelogueData;
	}
	public String getCartSize() {
		return cartSize;
	}
	public void setCartSize(String cartSize) {
		this.cartSize = cartSize;
	}

	
}
