package com.java.mshop.actionbean;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.dao.MshopCnd;
import com.dao.MshopCndDAO;
import com.dao.Product;
import com.dao.ProductDAO;
import com.dao.SubCategory;
import com.dao.SubCategoryDAO;
import com.java.backendUtility.CommonAction;
import com.java.backendUtility.CommonConstant;
import com.java.backendUtility.CommonDropDownUtils;
import com.java.backendUtility.CommonUtil;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.ImageUploadBean;
import com.java.mshop.beans.ProductManagementBean;
import com.java.mshop.displaybean.productManagementDispBean;

 

public class ProductManagementActionBean extends CommonAction implements Constants{
	
	private static final Logger logger = Logger.getLogger(ProductManagementActionBean.class.getName());
	
	public ProductManagementBean getBean() {
		  return (ProductManagementBean) MshopUtils.getBean("ProductManagementBean");
	  }
	  

	public String productManagement_Init() {
		logger.info("----inside productManagement_Init---");
		ProductManagementBean backingBean = getBean();
		backingBean.setSubcat_List(CommonDropDownUtils.getSubCategoryList(""));
		//backingBean.setProduct_List(CommonDropDownUtils.getProductList(""));
		backingBean.setCndcolor_List(CommonDropDownUtils.getCndListByGrp("","COLOR"));
		backingBean.setCndbrand_List(CommonDropDownUtils.getCndListByGrp("","BRAND"));
		backingBean.setCndentity_List(CommonDropDownUtils.getCndListByGrp("","ENTITY"));
		handle();
		return "";
	}


	@Override
	public void addEdit() {
		logger.info("inside add method");
		HttpServletRequest req = MshopUtils.getRequest();
		ProductManagementBean bean = getBean();
		ProductDAO dao = null;
		Product product = null;
		try {
			  MshopUtils.setnewProperty(bean, req);
				logger.info(bean.toString());
				
				if (MshopUtils.isNotEmpty(bean.getPrfnum())) {
					dao = new ProductDAO();
					product = dao.FindByPk(Long.parseLong(bean.getPrfnum()));
					if (MshopUtils.isNotEmpty(product)) {
						if (MshopUtils.isNotEmpty(bean.getProductName())) {
							product.setProductName(bean.getProductName());
							
						}
						if (MshopUtils.isNotEmpty(bean.getProductDesc())) {
							product.setProductDesc(bean.getProductDesc());

						}
						if (MshopUtils.isNotEmpty(bean.getProductSku())) {
							product.setProductSku(bean.getProductSku());
						}
						if (MshopUtils.isNotEmpty(bean.getPrice())) {
							product.setPrice(Double.parseDouble(bean.getPrice()));
						}
						
						if (MshopUtils.isNotEmpty(bean.getQuantity())) {
							product.setQuantity(Integer.parseInt(bean.getQuantity()));
						}
						if (MshopUtils.isNotEmpty(bean.getDiscount())) {
							product.setDiscount(Double.parseDouble(bean.getDiscount()));
						}
						
						if (MshopUtils.isNotEmpty(bean.getColour())) {
							MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(bean.getColour()));
							if (cnd != null) {
								product.setColour(cnd);
							}

						}
						if (MshopUtils.isNotEmpty(bean.getBrand())) {
							MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(bean.getBrand()));
							if (cnd != null) {
								product.setBrand(cnd);
							}
						}
						if (MshopUtils.isNotEmpty(bean.getEntity())) {
							MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(bean.getEntity()));
							if (cnd != null) {
								product.setEntity(cnd);
							}
						}
						if (MshopUtils.isNotEmpty(bean.getSubcatrfnum())) {
							SubCategory cat =  new SubCategoryDAO()
									.FindByPK(Long.parseLong(bean.getSubcatrfnum()));
							product.setSubcategory(cat);
						}
						
						
						
						if (MshopUtils.isNotEmpty(bean.getImg1())) {
							product.setImg1(bean.getImg1());

						}
						if (MshopUtils.isNotEmpty(bean.getImg2())) {
							product.setImg2(bean.getImg2());

						}
						if (MshopUtils.isNotEmpty(bean.getImg3())) {
							product.setImg3(bean.getImg1());

						}
						if (MshopUtils.isNotEmpty(bean.getImg4())) {
							product.setImg4(bean.getImg4());

						}
												
						if (MshopUtils.isNotEmpty(bean.getIsActive())) {
							if (Y.equals(bean.getIsActive())) {
								product.setIsActive(Y);
							} else {
								product.setIsActive(N);
							}
						}
						product.setFinalPay(calculatePrice(bean.getPrice(),bean.getDiscount()));
						
						product.setModifiedDate(new Date());
						product.setModifiedby(0);
						dao.update(product);
						bean.setPrfnum(product.getPrfnum().toString());
						bean.setMessage(RUS);
						bean.setStatus(true);
					}
				} else {
					product = new Product();
					dao = new ProductDAO();
					if (MshopUtils.isNotEmpty(bean.getProductName())) {
						product.setProductName(bean.getProductName());
						
					}
					if (MshopUtils.isNotEmpty(bean.getProductDesc())) {
						product.setProductDesc(bean.getProductDesc());

					}
					if (MshopUtils.isNotEmpty(bean.getProductSku())) {
						product.setProductSku(bean.getProductSku());
					}
					if (MshopUtils.isNotEmpty(bean.getPrice())) {
						product.setPrice(Double.parseDouble(bean.getPrice()));
					}
				
					if (MshopUtils.isNotEmpty(bean.getQuantity())) {
						product.setQuantity(Integer.parseInt(bean.getQuantity()));
					}
					if (MshopUtils.isNotEmpty(bean.getDiscount())) {
						product.setDiscount(Double.parseDouble(bean.getDiscount()));
					}
					if (MshopUtils.isNotEmpty(bean.getColour())) {
						MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(bean.getColour()));
						if (cnd != null) {
							product.setColour(cnd);
						}

					}
					if (MshopUtils.isNotEmpty(bean.getBrand())) {
						MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(bean.getBrand()));
						if (cnd != null) {
							product.setBrand(cnd);
						}
					}
					if (MshopUtils.isNotEmpty(bean.getEntity())) {
						MshopCnd cnd = new MshopCndDAO().FindByPK(Long.parseLong(bean.getEntity()));
						if (cnd != null) {
							product.setEntity(cnd);
						}
					}
					if (MshopUtils.isNotEmpty(bean.getSubcatrfnum())) {
						SubCategory cat =  new SubCategoryDAO()
								.FindByPK(Long.parseLong(bean.getSubcatrfnum()));
						product.setSubcategory(cat);
					}
					
					if (MshopUtils.isNotEmpty(bean.getImg1())) {
						product.setImg1(bean.getImg1());

					}
					if (MshopUtils.isNotEmpty(bean.getImg2())) {
						product.setImg2(bean.getImg2());

					}
					if (MshopUtils.isNotEmpty(bean.getImg3())) {
						product.setImg3(bean.getImg1());

					}
					if (MshopUtils.isNotEmpty(bean.getImg4())) {
						product.setImg4(bean.getImg4());

					}
					
					product.setFinalPay(calculatePrice(bean.getPrice(),bean.getDiscount()));

					if (MshopUtils.isNotEmpty(bean.getIsActive())) {
						if (Y.equals(bean.getIsActive())) {
							product.setIsActive(Y);
						} else {
							product.setIsActive(N);
						}
					}					
					product.setCreateDate(new Date());
					product.setModifiedDate(new Date());
					product.setCreatedby(0);
					product.setModifiedby(0);
					
				  Serializable pk = dao.save(product);
				  if(pk != null) {
					bean.setPrfnum(pk.toString());
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
	
	
	public ProductManagementBean searchResult() {
		int pageNumber = 1;
		int pageSize = 10;
		ProductManagementBean bean = getBean();
		HttpServletRequest req = MshopUtils.getRequest();
		try {
			MshopUtils.setnewProperty(bean, req);
			List<productManagementDispBean> list = new ArrayList<productManagementDispBean>();
			List<Product> productList = null;
			productList = new ProductDAO().findByFilteration(bean.getProductName(), bean.getProductSku(), bean.getSubcatrfnum(),
					bean.getIsActive(), pageNumber, pageSize, true);
			if (MshopUtils.isNotEmpty(productList)) {
				for (Product product : productList) {
					productManagementDispBean dispbean = new productManagementDispBean();
					 dispbean.setRfnum(product.getPrfnum()+"");
				     dispbean.setProductName(product.getProductName());
				     dispbean.setProductSKU(product.getProductSku());
				     dispbean.setPrice(product.getPrice()+"");
				     dispbean.setDiscount(product.getDiscount()+"");
				     dispbean.setQuantity(product.getQuantity()+"");
				     if(MshopUtils.isNotEmpty(product.getImg1())) {
				    	 dispbean.setProductImg(product.getImg1());
				     }
					if (Y.equals(product.getIsActive()))
						dispbean.setIsactive(Y);
					else
						dispbean.setIsactive(N);
					list.add(dispbean);
				}
				bean.setDisplist(list);
				bean.setCount(productList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}


	@Override
	public void setvalues(String id) {
		ProductManagementBean bean = getBean();
		if (!MshopUtils.isEmpty(id)) {
			Product product =  new ProductDAO().FindByPk(Long.parseLong(id));
			if (MshopUtils.isNotEmpty(product)) {
				
				if(MshopUtils.isNotEmpty(product.getPrfnum())) {
				   bean.setPrfnum(product.getPrfnum().toString());	
				}
				
				if (MshopUtils.isNotEmpty(product.getProductName())) {
					bean.setProductName(product.getProductName());

				}
				if (MshopUtils.isNotEmpty(product.getProductDesc())) {
					bean.setProductDesc(product.getProductDesc());

				}
				if (MshopUtils.isNotEmpty(product.getProductSku())) {
					bean.setProductSku(product.getProductSku());
				}
				
				if (MshopUtils.isNotEmpty(product.getPrice())) {
					bean.setPrice(product.getPrice()+"");
				}
				if (MshopUtils.isNotEmpty(product.getQuantity())) {
					bean.setQuantity(product.getQuantity()+"");
				}

				if (MshopUtils.isNotEmpty(product.getDiscount())) {
					bean.setDiscount(product.getDiscount()+"");
				}


				if (MshopUtils.isNotEmpty(product.getSubcategory().getScrfnum())) {
					bean.setSubcatrfnum(product.getSubcategory().getScrfnum().toString());
				}
				if (MshopUtils.isNotEmpty(product.getColour().getCndrfnum())) {
					bean.setColour(product.getColour().getCndrfnum().toString());
				}
				
				if (MshopUtils.isNotEmpty(product.getBrand().getCndrfnum())) {
					bean.setBrand(product.getBrand().getCndrfnum().toString());
				}
				if (MshopUtils.isNotEmpty(product.getEntity().getCndrfnum())) {
					bean.setEntity(product.getEntity().getCndrfnum().toString());
				}
				
				
				bean.setSubcat_List(CommonDropDownUtils.getSubCategoryList(product.getSubcategory().getScrfnum()+""));
				bean.setCndcolor_List(CommonDropDownUtils.getCndListByGrp(product.getColour().getCndrfnum()+"","COLOR"));
				bean.setCndbrand_List(CommonDropDownUtils.getCndListByGrp(product.getBrand().getCndrfnum()+"","BRAND"));
				bean.setCndentity_List(CommonDropDownUtils.getCndListByGrp(product.getEntity().getCndrfnum()+"","ENTITY"));
				
				if (MshopUtils.isNotEmpty(product.getIsActive())) {
					if (Y.equals(product.getIsActive())) {
						bean.setIsActive(Y);
					} else {
						bean.setIsActive(Y);
					}
				}
				
			}

		}
		
	}
	
	private Double calculatePrice(String price, String disc) {
		double finalPayamt = Double.parseDouble(price) - Double.parseDouble(disc);
		return finalPayamt;

	}
	
	public String productList() {
		logger.info("----inside productList---");
		ProductManagementBean backingBean = getBean();
		backingBean.setProduct_List(CommonDropDownUtils.getProductList(""));
		return "";
	}
	
	public void FileUpload() {
		boolean result = false;
		Product product = null;
		try {
			ImageUploadBean imgbean = (ImageUploadBean) MshopUtils.getBean("ImageUploadBean");
			HttpServletRequest req = MshopUtils.getRequest();
			String prfnum = req.getParameter("imgprfnum");
			if (MshopUtils.isNotEmpty(prfnum)) {
				product = new ProductDAO().FindByPk(Long.parseLong(prfnum));
				if (MshopUtils.isNotEmpty(product)) {
					String path = req.getServletContext().getRealPath("");
					logger.info("realPath :" + path);
					Part image1 = imgbean.getUploadedFile1();
					Part image2 = imgbean.getUploadedFile2();
					Part image3 = imgbean.getUploadedFile3();
					Part image4 = imgbean.getUploadedFile4();
					List<Part> list = new ArrayList<>();
					if(MshopUtils.isNotEmpty(image1))
					list.add(image1);
					if(MshopUtils.isNotEmpty(image2))
					list.add(image2);
					if(MshopUtils.isNotEmpty(image3))
					list.add(image3);
					if(MshopUtils.isNotEmpty(image4))
					list.add(image4);

					for (int i = 0; i < list.size(); i++) {
						String file_name = list.get(i).getSubmittedFileName();
						logger.info("file_name :" + file_name);
						int j = i+1;
						String img = "img"+j;
						String uploadpath = path+CommonConstant.PRODUCT_IMG  + file_name;
						result = CommonUtil.readWriteData(uploadpath, list.get(i));
						if (result) {
							setProperty(product, file_name, img);
						}
					}

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Images Uploaded successFully..", ""));

				}
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "error occurred..", ""));
			e.printStackTrace();
		}
	}
	
	
	public static Object setProperty(Object obj, String value,String prop) throws ClassNotFoundException {
		logger.info("setting property of images");

		try {
			Class<? extends Object> cls = obj.getClass();
			Method[] methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("set")) {
					if(m.getName().equalsIgnoreCase("set"+prop))
					m.invoke(obj, value);
				}

			}
			new ProductDAO().update(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;

	}
}
