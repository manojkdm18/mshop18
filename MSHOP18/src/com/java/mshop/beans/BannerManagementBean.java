package com.java.mshop.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.java.mshop.displaybean.SubCategoryDispBean;

public class BannerManagementBean {
	private String brfnum;
	private String title;
	private String info;
	private String theme;
	private String isActive;
	private String message;
	private boolean status;
	private int count =0;
	private int totalNumberOfrecords =0;
	private Part ImageFile;
	
	List<SubCategoryDispBean> displist = new ArrayList<SubCategoryDispBean>();
	private String cndbanrfnum;
	private List<CommonOptionBean> cndbanner_List = new ArrayList<>();
	
	
	public String getBrfnum() {
		return brfnum;
	}
	public void setBrfnum(String brfnum) {
		this.brfnum = brfnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
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
	public List<SubCategoryDispBean> getDisplist() {
		return displist;
	}
	public void setDisplist(List<SubCategoryDispBean> displist) {
		this.displist = displist;
	}
	public String getCndbanrfnum() {
		return cndbanrfnum;
	}
	public void setCndbanrfnum(String cndbanrfnum) {
		this.cndbanrfnum = cndbanrfnum;
	}
	public List<CommonOptionBean> getCndbanner_List() {
		return cndbanner_List;
	}
	public void setCndbanner_List(List<CommonOptionBean> cndbanner_List) {
		this.cndbanner_List = cndbanner_List;
	}
	public Part getImageFile() {
		return ImageFile;
	}
	public void setImageFile(Part imageFile) {
		ImageFile = imageFile;
	}
	
	
	
}
