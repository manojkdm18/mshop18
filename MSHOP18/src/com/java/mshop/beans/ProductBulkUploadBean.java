package com.java.mshop.beans;

import javax.servlet.http.Part;

public class ProductBulkUploadBean {
	private Part uploadedFile1;
	private String message;
	

	public Part getUploadedFile1() {
		return uploadedFile1;
	}

	public void setUploadedFile1(Part uploadedFile1) {
		this.uploadedFile1 = uploadedFile1;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
