package com.java.mshop.actionbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.dao.Category;
import com.dao.CategoryDAO;
import com.dao.SubCategory;
import com.dao.SubCategoryDAO;
import com.java.backendUtility.CommonAction;
import com.java.backendUtility.CommonDropDownUtils;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.SubCategoryManagementBean;
import com.java.mshop.displaybean.SubCategoryDispBean;

public class SubCategoryManagementActionBean  extends CommonAction implements Constants{
	
	  private static final Logger logger = Logger.getLogger(SubCategoryManagementActionBean.class.getName());
	    
	    public SubCategoryManagementBean getBean() {
			  return (SubCategoryManagementBean) MshopUtils.getBean("SubCategoryManagementBean");
		  }
		  
	 public  String subCategoryManagement_Init(){
			logger.info("inside init method");
			HttpServletRequest req = MshopUtils.getRequest();
			SubCategoryManagementBean backingBean = getBean();
			String command = req.getParameter(COMMAND);
			if(!EDIT.equalsIgnoreCase(command)) {
			backingBean.setCat_List(CommonDropDownUtils.getCategoryList(""));
			}
			handle();
			return "";
	    }

	@Override
	public void addEdit() {
    	HttpServletRequest req = MshopUtils.getRequest();
		logger.info("inside add method");
		SubCategoryManagementBean bean = getBean();
		SubCategoryDAO dao = null;
		SubCategory category = null;

		try {
			  MshopUtils.setnewProperty(bean, req);
			logger.info(bean.toString());
			if (MshopUtils.isNotEmpty(bean.getCatrfnum())) {
				dao = new SubCategoryDAO();
				category = dao.FindByPK(Long.parseLong(bean.getCatrfnum()));
				if (MshopUtils.isNotEmpty(category)) {
					
					if (MshopUtils.isNotEmpty(bean.getCatname())) {
						category.setSubcatName(bean.getCatname());
					}
					if (MshopUtils.isNotEmpty(bean.getCatdesc())) {
						category.setSubcatdesc(bean.getCatdesc());

					}
					
					if (MshopUtils.isNotEmpty(bean.getCatListrfnum())) {
						Category cat = new CategoryDAO().FindByPk(Long.parseLong(bean.getCatListrfnum()));
						category.setCategory(cat);
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
					bean.setCatrfnum(category.getScrfnum()+"");
				}
			} else {
				category = new SubCategory();
				dao = new SubCategoryDAO();

				if (MshopUtils.isNotEmpty(bean.getCatname())) {
					category.setSubcatName(bean.getCatname());
				}
				if (MshopUtils.isNotEmpty(bean.getCatdesc())) {
					category.setSubcatdesc(bean.getCatdesc());

				}

				if (MshopUtils.isNotEmpty(bean.getCatListrfnum())) {
					Category cat = new CategoryDAO().FindByPk(Long.parseLong(bean.getCatListrfnum()));
					category.setCategory(cat);
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
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("static-access")
	public SubCategoryManagementBean searchResult()  {
		logger.info("inside search method");
		int pageNumber = 1;
		int pageSize = 10;
		HttpServletRequest req = MshopUtils.getservletRequest();
		SubCategoryManagementBean bean = getBean();
		try {
		MshopUtils.setnewProperty(bean, req);
		List<SubCategoryDispBean> list = new ArrayList<SubCategoryDispBean>();
		List<SubCategory> catList = null;
		catList = new SubCategoryDAO().findByFilteration(bean.getCatrfnum(), bean.getCatname(), bean.getIsActive(),
				pageNumber, pageSize, true);
		if (MshopUtils.isNotEmpty(catList)) {
			for (SubCategory cat : catList) {
				SubCategoryDispBean dispbean = new SubCategoryDispBean();
				dispbean.setCrfnum(cat.getScrfnum() + "");
				dispbean.setCatname(cat.getSubcatName());
				dispbean.setIsactive(cat.getIsActive());
				dispbean.setCategory(cat.getCategory().getCatName());
				list.add(dispbean);
			}
			bean.setCount(catList.size());
			bean.setDisplist(list);
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

		SubCategoryManagementBean bean = getBean();
		if (!MshopUtils.isEmpty(id)) {
			SubCategory cat = new SubCategoryDAO().FindByPK(Long.parseLong(id));
			if (MshopUtils.isNotEmpty(cat)) {
				if (MshopUtils.isNotEmpty(cat.getScrfnum())) {
					bean.setCatrfnum(cat.getScrfnum() + "");
				}

				if (MshopUtils.isNotEmpty(cat.getSubcatName())) {
					bean.setCatname(cat.getSubcatName());

				}

				if (MshopUtils.isNotEmpty(cat.getSubcatdesc())) {
					bean.setCatdesc(cat.getSubcatdesc());

				}

				if (MshopUtils.isNotEmpty(cat.getIsActive())) {
					bean.setIsActive(cat.getIsActive());
				}
				

				if (MshopUtils.isNotEmpty(cat.getCategory().getCatrfnum())) {
					bean.setCatListrfnum(cat.getCategory().getCatrfnum()+"");
				}
				
				bean.setCat_List(CommonDropDownUtils.getCategoryList(cat.getCategory().getCatrfnum()+""));
			}

		}

	}

}
