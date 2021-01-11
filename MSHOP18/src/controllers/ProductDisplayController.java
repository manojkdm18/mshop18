package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Product;
import com.dao.ProductDAO;
import com.java.backendUtility.FacesContexObject;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.CatelogueDataBean;
import com.java.mshop.beans.ProductDisplayBean;
@WebServlet("/product")
public class ProductDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProductDisplayController.class.getName());
	
	public ProductDisplayBean getBean() {
		  return (ProductDisplayBean) MshopUtils.getBean("ProductDisplayBean");
	  }
	  
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacesContext ctx = FacesContexObject.getFacesContext(req, resp);
		String uri = req.getRequestURI();
		String prsku = req.getParameter("pr");
		logger.info("product sku  :"+prsku);
		if(MshopUtils.isNotEmpty(prsku)) {
			getProductBySku(prsku);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/faces/web/displayProduct.jsp");
		rd.forward(req, resp);
		if (ctx != null) {
			ctx.getResponseComplete();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
     
	private void getProductBySku(String sku) {
		logger.info("inside getProductBySku() method");
		Product product = null;
		ProductDisplayBean bean = getBean();
		if (MshopUtils.isNotEmpty(sku)) {
			product = new ProductDAO().findBySku(sku);
			if (MshopUtils.isNotEmpty(product.getPrfnum())) {
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
				bean.setPrice(product.getPrice() + "");
			}
			if (MshopUtils.isNotEmpty(product.getQuantity())) {
				bean.setQuantity(product.getQuantity() + "");
			}

			if (MshopUtils.isNotEmpty(product.getDiscount())) {
				bean.setDiscount(product.getDiscount() + "");
			}

			if (MshopUtils.isNotEmpty(product.getSubcategory().getSubcatName())) {
				bean.setSubcategory(product.getSubcategory().getSubcatName());
			}
			if (MshopUtils.isNotEmpty(product.getColour().getCndname())) {
				bean.setColour(product.getColour().getCndname());
			}

			if (MshopUtils.isNotEmpty(product.getBrand().getCndname())) {
				bean.setBrand(product.getBrand().getCndname());
			}
			if (MshopUtils.isNotEmpty(product.getEntity().getCndname())) {
				bean.setEntity(product.getEntity().getCndname());
			}
			if(MshopUtils.isNotEmpty(product.getImg1())) {
				bean.setImg1(product.getImg1());
			}
			if(MshopUtils.isNotEmpty(product.getImg2())) {
				bean.setImg2(product.getImg2());
			}
			if(MshopUtils.isNotEmpty(product.getImg3())) {
				bean.setImg3(product.getImg3());
			}
			if(MshopUtils.isNotEmpty(product.getImg4())) {
				bean.setImg4(product.getImg4());
			}

		}
	}

}
