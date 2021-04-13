package com.java.mshop.beans;

import java.util.ArrayList;
import java.util.List;
import com.java.mshop.displaybean.SubCategoryDispBean;

public class SubCategoryManagementBean {

	private String catrfnum;
	private String catname;
	private String catdesc;
	private String isActive;
	private String message;
	private boolean status;
	private int count =0;
	private int totalNumberOfrecords =0;
	
	List<SubCategoryDispBean> displist = new ArrayList<SubCategoryDispBean>();
	private String catListrfnum;
	private List<CommonOptionBean> cat_List = new ArrayList<>();

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

	public List<SubCategoryDispBean> getDisplist() {
		return displist;
	}

	public void setDisplist(List<SubCategoryDispBean> displist) {
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

	public List<CommonOptionBean> getCat_List() {
		return cat_List;
	}

	public void setCat_List(List<CommonOptionBean> cat_List) {
		this.cat_List = cat_List;
	}

	public String getCatListrfnum() {
		return catListrfnum;
	}

	public void setCatListrfnum(String catListrfnum) {
		this.catListrfnum = catListrfnum;
	}
	
	
	
	
}
