package com.java.mshop.actionbean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.dao.MshopBanner;
import com.dao.MshopBannerDAO;
import com.dao.MshopCnd;
import com.dao.MshopCndDAO;
import com.java.backendUtility.CommonConstant;
import com.java.backendUtility.CommonDropDownUtils;
import com.java.backendUtility.CommonUtil;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.BannerManagementBean;

public class BannerManagementActionBean implements Constants{
	private static final Logger logger = Logger.getLogger(BannerManagementActionBean.class.getName());


	public BannerManagementBean getBean() {
		  return (BannerManagementBean) MshopUtils.getBean("BannerManagementBean");
	  }
	  

	public String bannerManagement_Init() throws IOException, ServletException {
		logger.info("----inside init method ---");
		BannerManagementBean backingBean = getBean();
		backingBean.setCndbanner_List(CommonDropDownUtils.getCndListByGrp("","BANNER"));
		return "";
	}
	
	public  String bannerOnboard() {
		logger.info("inside banner onboard ");
		BannerManagementBean bean = getBean();
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
			String url = req.getParameter("title");
			String sequence = req.getParameter("info");
			Part image = bean.getImageFile();
			String cndbanrfnum = req.getParameter("cndbanrfnum");
			String isactive = req.getParameter("isActive");
			String theme = image.getSubmittedFileName();
			String path = req.getServletContext().getRealPath("");
			logger.info("realPath :" + path);

			MshopBanner banner = new MshopBanner();
			if (MshopUtils.isNotEmpty(url)) {
				banner.setUrl(url);
			}
			if (MshopUtils.isNotEmpty(sequence)) {
				banner.setSequence(sequence);
			}
			if (MshopUtils.isNotEmpty(cndbanrfnum)) {
				MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(cndbanrfnum));
				if (cnd != null) {
					banner.setType(cnd);
				}
			}
			if (MshopUtils.isNotEmpty(isactive)) {
				banner.setIsActive(isactive);
			}
			if (MshopUtils.isNotEmpty(theme)) {
				banner.setTheme(theme);
			}

			banner.setCreateDate(new Date());
			banner.setModifiedDate(new Date());
			banner.setCreatedby(0);
			banner.setModifiedby(0);

			String uploadpath = path +CommonConstant.BANNER_IMG + theme;
			boolean result = CommonUtil.readWriteData(uploadpath, image);
			if (result) {
				Serializable pk = new MshopBannerDAO().save(banner);
				if (pk != null) {
					bean.setBrfnum(pk.toString());
					bean.setMessage(RSS);
					bean.setStatus(true);
				}
			}

		} catch (Exception e) {
			bean.setMessage(ERROR);
			bean.setStatus(false);
			logger.info("-----------" + e.getMessage() + "--------------");
		}
		return "";
	}
}
