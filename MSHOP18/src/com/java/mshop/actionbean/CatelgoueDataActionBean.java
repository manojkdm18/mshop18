package com.java.mshop.actionbean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Category;
import com.dao.CategoryDAO;
import com.dao.MshopBanner;
import com.dao.MshopBannerDAO;
import com.dao.Product;
import com.dao.ProductDAO;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.CartItemBean;
import com.java.mshop.beans.CatelogueDataBean;
import com.java.mshop.beans.CommonSessionBean;
import com.java.mshop.beans.ProductDisplayBean;

public class CatelgoueDataActionBean implements Constants{
	private static final Logger logger = Logger.getLogger(CatelgoueDataActionBean.class.getName());
	

	public CatelogueDataBean getBean() {
		  return (CatelogueDataBean) MshopUtils.getBean("CatelogueDataBean");
	  }
	  
	public CartItemBean getItemBean() {
		  return (CartItemBean) MshopUtils.getBean("CartItemBean");
	  }
	  
	public CommonSessionBean getSessionBean() {
		  return (CommonSessionBean) MshopUtils.getBean("CommonSessionBean");
	  }
	public ProductDisplayBean getProductBean() {
		  return (ProductDisplayBean) MshopUtils.getBean("ProductDisplayBean");
	  }
	  
	
	
	public String getAllCatelogueData() {
		logger.info("inside getAllCatelogueData() method");
		logger.info("get all data method started : =>>>>"+System.currentTimeMillis());
		CommonSessionBean sessionBean = getSessionBean();
		CatelogueDataBean backingBean = getBean();
		backingBean.setHeroBanner_List(getBannerList("HERO-B"));
		backingBean.setSubBanner_List(getBannerList("SUB-B"));
		backingBean.setAdBanner_List(getBannerList("AD-B"));
		backingBean.setThinbanner_List(getBannerList("THIN-B"));
		backingBean.setNewArrProduct_List(getEntityProductList("NEW_ARR"));
		backingBean.setTopSellProduct_List(getEntityProductList("TOP-SELL"));
		backingBean.setCategory_List(getCategoryList());
		sessionBean.setCatelogueData(backingBean);
		logger.info("get all data method ended : =>>>>"+System.currentTimeMillis());
		return "";
	}
	
	
	public List<MshopBanner> getBannerList(String type) {
	 List<MshopBanner> list = new ArrayList<>();
		list = new MshopBannerDAO().getAllRecords(type);
		return list;
		
	}
	
	public List<Product> getEntityProductList(String type) {
		 List<Product> list = new ArrayList<>();
			list = new ProductDAO().getAllProductByCnd(type);
			return list;
			
		}
	
	public List<Category> getCategoryList() {
		 List<Category> list = new ArrayList<>();
			list = new CategoryDAO().getAllRecords();
			return list;
			
		}
	
	public List<Product> getProductListByCat(String cat) {
		 List<Product> list = new ArrayList<>();
			list = new ProductDAO().getAllProductByCategory(cat);
			return list;
			
		}
	
	
}
