package com.java.mshop.actionbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.dao.Category;
import com.dao.CategoryDAO;
import com.java.backendUtility.CommonAction;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.CategoryManagementBean;
import com.java.mshop.displaybean.CategoryDisplayBean;


public class CategoryManagementActionBean extends CommonAction implements Constants{
    private static final Logger logger = Logger.getLogger(CategoryManagementActionBean.class.getName());
    
    public CategoryManagementBean getBean() {
		  return (CategoryManagementBean) MshopUtils.getBean("CategoryManagementBean");
	  }
	  
 public  String categoryManagement_Init(){
		logger.info("inside init method");
    	handle();
    	return "";
    }
    
    
   
	@Override
	public void addEdit() {
    	HttpServletRequest req = MshopUtils.getRequest();
		logger.info("inside add method");
		CategoryManagementBean bean = getBean();
		CategoryDAO dao = new CategoryDAO();
		Category category = null;

		try {
			  MshopUtils.setnewProperty(bean, req);
			logger.info(bean.toString());
			if (MshopUtils.isNotEmpty(bean.getCatrfnum())) {
				dao = new CategoryDAO();
				category = dao.FindByPk(Long.parseLong(bean.getCatrfnum()));
				if (MshopUtils.isNotEmpty(category)) {
					
					if (MshopUtils.isNotEmpty(bean.getCatname())) {
						category.setCatName(bean.getCatname());
					}
					if (MshopUtils.isNotEmpty(bean.getCatdesc())) {
						category.setCdesc(bean.getCatdesc());

					}
					if (MshopUtils.isNotEmpty(bean.getIsActive())) {
						if (Y.equals(bean.getIsActive())) {
							category.setIsActive(Y);
						} else {
							category.setIsActive(N);
						}
					}
					category.setModifiedDate(new Date());
					category.setModifiedby(0);
					dao.update(category);
					bean.setMessage(RUS);
					bean.setStatus(true);
					bean.setCatrfnum(category.getCatrfnum()+"");
				}
			} else {
				category = new Category();
				dao = new CategoryDAO();

				if (MshopUtils.isNotEmpty(bean.getCatname())) {
					category.setCatName(bean.getCatname());
				}
				if (MshopUtils.isNotEmpty(bean.getCatdesc())) {
					category.setCdesc(bean.getCatdesc());

				}
				if (MshopUtils.isNotEmpty(bean.getIsActive())) {
					if (Constants.Y.equals(bean.getIsActive())) {
						category.setIsActive(Y);
					} else {
						category.setIsActive(N);
					}
				}
				category.setCreateDate(new Date());
				category.setCreatedby(0);
				category.setModifiedDate(new Date());
				category.setModifiedby(0);
				Serializable pk = dao.save(category);
				if (MshopUtils.isNotEmpty(pk)) {
					logger.info("[records saved suucessfully :]" + pk);
					bean.setCatrfnum(pk.toString());
					bean.setMessage(RSS);
					bean.setStatus(true);
				}

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			bean.setMessage(ERROR);
			bean.setStatus(false);
			logger.info("-----------" + e.getMessage() + "--------------");
		}
	}
	@Override
	public void search() {
		logger.info("inside search method");
		
	}
	
	@SuppressWarnings("static-access")
	public CategoryManagementBean searchResult()  {
		logger.info("inside search method");
		int pageNumber = 1;
		int pageSize = 10;
		HttpServletRequest req = MshopUtils.getservletRequest();
		CategoryManagementBean bean = getBean();
		try {
		MshopUtils.setnewProperty(bean, req);
		List<CategoryDisplayBean> list = new ArrayList<CategoryDisplayBean>();
		List<Category> catList = null;
		catList = new CategoryDAO().findByFilteration(bean.getCatrfnum(), bean.getCatname(), bean.getIsActive(),
				pageNumber, pageSize, true);
		if (MshopUtils.isNotEmpty(catList)) {
			for (Category cat : catList) {
				CategoryDisplayBean dispbean = new CategoryDisplayBean();
				dispbean.setCrfnum(cat.getCatrfnum() + "");
				dispbean.setCatname(cat.getCatName());
				dispbean.setIsactive(cat.getIsActive());
				list.add(dispbean);
			}
			bean.setDisplist(list);
			bean.setCount(catList.size());
			logger.info("catList.size  =>"+catList.size());

		}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return bean;

	}
	



	@Override
	public void setvalues(String id) {
		// TODO Auto-generated method stub

		CategoryManagementBean bean = getBean();
		if (!MshopUtils.isEmpty(id)) {
			Category cat = new CategoryDAO().FindByPk(Long.parseLong(id));
			if (MshopUtils.isNotEmpty(cat)) {
				if (MshopUtils.isNotEmpty(cat.getCatrfnum())) {
					bean.setCatrfnum(cat.getCatrfnum() + "");
				}

				if (MshopUtils.isNotEmpty(cat.getCatName())) {
					bean.setCatname(cat.getCatName());

				}

				if (MshopUtils.isNotEmpty(cat.getCdesc())) {
					bean.setCatdesc(cat.getCdesc());

				}

				if (MshopUtils.isNotEmpty(cat.getIsActive())) {
					bean.setIsActive(cat.getIsActive());
				}
			}

		}

	}

}
