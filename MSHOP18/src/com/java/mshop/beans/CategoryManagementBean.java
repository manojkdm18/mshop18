package com.java.mshop.beans;

import java.util.ArrayList;
import java.util.List;

import com.java.mshop.displaybean.CategoryDisplayBean;
import com.java.mshop.displaybean.UserDisplayBean;

public class CategoryManagementBean {

	private String catrfnum;
	private String catname;
	private String catdesc;
	private String isActive;
	private String message;
	private boolean status;
	
	List<CategoryDisplayBean> displist = new ArrayList<CategoryDisplayBean>();
	
	private int count =0;
	private int totalNumberOfrecords =0;

	public String getCatrfnum() {
		return catrfnum;
	}

	public void setCatrfnum(String catrfnum) {
		this.catrfnum = catrfnum;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

	public List<CategoryDisplayBean> getDisplist() {
		return displist;
	}

	public void setDisplist(List<CategoryDisplayBean> displist) {
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

	@Override
	public String toString() {
		return "CategoryManagementBean [catrfnum=" + catrfnum + ", catname=" + catname + ", catdesc=" + catdesc
				+ ", isactive=" + isActive + "]";
	}

}
