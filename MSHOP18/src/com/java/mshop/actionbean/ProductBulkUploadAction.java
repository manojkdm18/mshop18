package com.java.mshop.actionbean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.collections4.map.HashedMap;

import com.dao.MshopCnd;
import com.dao.MshopCndDAO;
import com.dao.Product;
import com.dao.ProductDAO;
import com.dao.SubCategory;
import com.dao.SubCategoryDAO;
import com.java.backendUtility.CommonUtil;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.ProductBulkUploadBean;
import com.java.mshop.beans.ProductUploadDataBean;
import com.sun.xml.internal.fastinfoset.sax.Properties;

public class ProductBulkUploadAction implements Constants{
private static final Logger logger = Logger.getLogger(ProductBulkUploadAction.class.getName());
public static final String header = "PRODUCT SKU,PRODUCT NAME,PRODUCT DESC,QUANTITY,PRICE,DISCOUNT,COLOR,BRAND,ENTITY,SUBCATEGORY,ISACTIVE,IMG1,IMG2,IMG3,IMG4";
public static final String[] commonField = {"productSku","productName","productDesc","quantity","price","discount","colour","brand","entity","subcategory","isActive","img1","img2","img3","img4"};
int savedRecords = 0;
int updateRecords = 0;
ProductDAO dao = new ProductDAO();
FileWriter filewriter = null;


	public ProductBulkUploadBean getBean() {
		  return (ProductBulkUploadBean) MshopUtils.getBean("ProductBulkUploadBean");
	  }
	
	public String productbulkUpload_Init() {
		return null;
	}
	public String downloadFormat(){
		logger.info("inside download formnat");
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest req =  MshopUtils.getservletRequest();
		HttpServletResponse response = MshopUtils.getResponse();
		   response.setContentType("text/csv");
		    response.setHeader("Content-Disposition", "attachment; filename=\"productBulkUpload.csv\"");
		    try
		    {
		        OutputStream outputStream = response.getOutputStream();
		        String outputResult = header;
		        outputStream.write(outputResult.getBytes());
		        outputStream.write(newLine.getBytes());
		        outputStream.flush();
		        outputStream.close();
		        if(fc != null) {
		        	fc.responseComplete();
		        }
		    }
		    catch(Exception e)
		    {
		    	logger.info(e.toString());
		    }
			return "";
	}
	
	public String uploadProductData() {
		logger.info("inside upload formnat");
		ProductBulkUploadBean bean = getBean();
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest req =  MshopUtils.getservletRequest();
		HttpServletResponse response = MshopUtils.getResponse();
		BufferedReader br = null;
		String line = "";
		String fileName = "";
		String path = "";
		String location = "";
		boolean result = false;
		Product product = null;
		Part file = bean.getUploadedFile1();

		try {
			if (file != null) {
				logger.info("file name :" + file.getSubmittedFileName());
				fileName = file.getSubmittedFileName();
				String format = fileName.substring(fileName.lastIndexOf(".") + 1);
				logger.info("file format :" + format);
				if(format.equalsIgnoreCase("CSV")) {
				location = CommonUtil.readConfiuguration(csvFileLocation);
				path = location + file.getSubmittedFileName();
			if (MshopUtils.isNotEmpty(path)) {
				result = CommonUtil.readWriteData(path, file);
			}
			if (result) {
				br = new BufferedReader(new FileReader(path));
				br.readLine();
				while ((line = br.readLine()) != null) {
					String[] data = line.split(cvsSplitBy);
					product = checkforExistsProduct(data[0]);
					addEditRecords(data, product);
				}
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Result => Saved Records :"+savedRecords+"&"+"Updated Records :"+updateRecords, ""));
			}
			}else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Please Upload CSV file only.", ""));
			}
			}
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return "";

    }
	
	public Product checkforExistsProduct(String skucode) {
		logger.info("check for product");
		Product product = null;
		if(MshopUtils.isNotEmpty(skucode)) {
			product = dao.findBySku(skucode);
			
		}
		return product;
	}
	
	public void addEditRecords(String[] data,Product product ) {
		logger.info("inside add edit product");
		try {
			if(MshopUtils.isNotEmpty(data)) {
					ProductUploadDataBean bean = new ProductUploadDataBean();
					Map map = fillMap(data, commonField); 
					MshopUtils.setnewPropertyForUpload(map, bean);
					logger.info("filled bean :"+bean.toString());
					if (product != null) {
						if (MshopUtils.isNotEmpty(bean.getProductSku())) {
							product.setProductSku(bean.getProductSku());
						}
						if (MshopUtils.isNotEmpty(bean.getProductName())) {
							product.setProductName(bean.getProductName());

						}
						if (MshopUtils.isNotEmpty(bean.getProductDesc())) {
							product.setProductDesc(bean.getProductDesc());

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
						if (MshopUtils.isNotEmpty(bean.getSubcategory())) {
							SubCategory cat = new SubCategoryDAO().FindByPK(Long.parseLong(bean.getSubcategory()));
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
						product.setModifiedDate(new Date());
						product.setModifiedby(0);
						dao.update(product);
						logger.info("record updated"+product.getPrfnum());
						updateRecords++;

					}else {

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
						if (MshopUtils.isNotEmpty(bean.getSubcategory())) {
							SubCategory cat =  new SubCategoryDAO()
									.FindByPK(Long.parseLong(bean.getSubcategory()));
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
						product.setCreateDate(new Date());
						product.setModifiedDate(new Date());
						product.setCreatedby(0);
						product.setModifiedby(0);
					 Serializable pk = dao.save(product);
					 if(pk != null) {
						 savedRecords++;
						 logger.info("record saved"+pk);
					 }
					
					
					}
				}
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
		
	public Map fillMap(String[] array,String[] array1) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < array1.length; i++) {
			list.add(array1[i]);
		}
		Map<String, String> map = new HashedMap<String, String>();
		for (int i = 0; i < array.length; i++) {
				map.put(list.get(0).toString(), array[i]);
				list.remove(0);
			}
		return map;
		
	}
	
	public String downloadSummaryFile(String[] array,String status) {
		logger.info("inside download summary file");
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest req =  MshopUtils.getservletRequest();
		HttpServletResponse response = MshopUtils.getResponse();
		   response.setContentType("text/csv");
		    response.setHeader("Content-Disposition", "attachment; filename=\"productBulkSummary.csv\"");
		    try
		    {
		        OutputStream outputStream = response.getOutputStream();
		        String outputResult = header;
		        outputStream.write(outputResult.getBytes());
		        outputStream.write("STATUS".getBytes());
		        outputStream.write(newLine.getBytes());
		        writeCsvData(array, outputStream, status);
		        outputStream.flush();
		        outputStream.close();
		        if(fc != null) {
		        	fc.responseComplete();
		        }
		    }
		    catch(Exception e)
		    {
		    	logger.info(e.toString());
		    }
			return "";
	}
	
	public void writeCsvData(String[] array, OutputStream outputStream,String status) {
	 try {
			for(String arr : array) {
				 outputStream.write(arr.getBytes());
			}
			 outputStream.write(status.getBytes());
			 outputStream.write(newLine.getBytes());
			
			 
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
