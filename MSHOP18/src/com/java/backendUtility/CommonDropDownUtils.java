package com.java.backendUtility;

import java.util.ArrayList;
import java.util.List;

import com.dao.Category;
import com.dao.CategoryDAO;
import com.dao.CityMaster;
import com.dao.CityMasterDAO;
import com.dao.CountryMaster;
import com.dao.CountryMasterDAO;
import com.dao.MshopCnd;
import com.dao.MshopCndDAO;
import com.dao.Product;
import com.dao.ProductDAO;
import com.dao.StateMaster;
import com.dao.StateMasterDAO;
import com.dao.SubCategory;
import com.dao.SubCategoryDAO;
import com.java.mshop.beans.CommonOptionBean;

public class CommonDropDownUtils {

	public static List<CommonOptionBean> getCountryList(String id) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<CountryMaster> list = new ArrayList<>();
		list = new CountryMasterDAO().getAllRecords();
		for(CountryMaster c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue(c.getCmrfnum()+"");
			bean.setLable(c.getCountryName());
			if(id.equals(c.getCmrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	public static List<CommonOptionBean> getStateList(String id) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<StateMaster> list = new ArrayList<>();
		list = new StateMasterDAO().getAllRecords();
		for(StateMaster c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue( c.getSmrfnum()+"");
			bean.setLable(c.getSmname());
			if(id.equals(c.getSmrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	public static List<CommonOptionBean> getCityList(String id) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<CityMaster> list = new ArrayList<>();
		list = new CityMasterDAO().getAllRecords();
		for(CityMaster c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue( c.getCityrfnum()+"");
			bean.setLable(c.getCityname());
			if(id.equals(c.getCityrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	
	public static List<CommonOptionBean> getCategoryList(String id) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<Category> list = new ArrayList<>();
		list = new CategoryDAO().getAllRecords();
		for(Category c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue(c.getCatrfnum()+"");
			bean.setLable(c.getCatName());
			if(id.equals(c.getCatrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	
	public static List<CommonOptionBean> getSubCategoryList(String id) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<SubCategory> list = new ArrayList<>();
		list = new SubCategoryDAO().getAllRecords();
		for(SubCategory c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue(c.getScrfnum()+"");
			bean.setLable(c.getSubcatName());
			if(id.equals(c.getScrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	
	public static List<CommonOptionBean> getProductList(String id) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<Product> list = new ArrayList<>();
		list = new ProductDAO().getAllRecords();
		for(Product c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue(c.getPrfnum()+"");
			bean.setLable(c.getProductName()+"("+c.getProductSku()+")");
			if(id.equals(c.getPrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	
	public static List<CommonOptionBean> getCndListByGrp(String id,String cnd_grp) {
		List<CommonOptionBean> retval = new ArrayList<>();
		List<MshopCnd> list = new ArrayList<>();
		list = new MshopCndDAO().findByCndGroup(cnd_grp);
		for(MshopCnd c : list) {
			CommonOptionBean bean = new CommonOptionBean(); 
			bean.setValue(c.getCndrfnum()+"");
			bean.setLable(c.getCndname());
			if(id.equals(c.getCndrfnum()+"")) {
				bean.setSelected(true);
			}
			retval.add(bean);
			
		}
		return retval;
	}
	
}
