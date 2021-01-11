package com.java.mshop.actionbean;

import java.util.logging.Logger;

import com.dao.CategoryDAO;
import com.dao.ProductDAO;
import com.dao.SubCategory;
import com.dao.SubCategoryDAO;
import com.dao.UserDAO;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.AdminHomePageBean;

public class AdminHomePageActionBean implements Constants{
	 private static final Logger logger = Logger.getLogger(AdminHomePageActionBean.class.getName());
	    
	    public AdminHomePageBean getBean() {
			  return (AdminHomePageBean) MshopUtils.getBean("AdminHomePageBean");
		  }
	    
	    
	    public  String adminHomePage_Init(){
			logger.info("inside init method");
			AdminHomePageBean bean = getBean();
			bean.setUsers(new UserDAO().totalUsers()+"");
			bean.setCategory(new CategoryDAO().totalCategory()+"");
			bean.setSubcategory(new SubCategoryDAO().totalSubCategory()+"");
			bean.setProducts(new ProductDAO().totalProducts()+"");
	    	return "";
	    }
	    
	    
}
