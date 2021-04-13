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
@WebServlet("/category/*")
public class ProductListingController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProductListingController.class.getName());
	public CatelogueDataBean getBean() {
		  return (CatelogueDataBean) MshopUtils.getBean("CatelogueDataBean");
	  }
	  
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacesContext ctx = FacesContexObject.getFacesContext(req, resp);
		String uri = req.getRequestURI();
		String category = uri.substring(uri.lastIndexOf("/") + 1);
		logger.info("category :"+category);
		if(MshopUtils.isNotEmpty(category)) {
			getProductByCategory(category);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/faces/web/productList.jsp");
		rd.forward(req, resp);
		if (ctx != null) {
			ctx.getResponseComplete();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
     
	private void getProductByCategory(String category) {
		logger.info("inside getProductByCategory() method");
		CatelogueDataBean backingBean = getBean();
		backingBean.setAllProductList(getProductListByCat(category));
	}

	public List<Product> getProductListByCat(String cat) {
		 List<Product> list = new ArrayList<>();
			list = new ProductDAO().getAllProductByCategory(cat);
			return list;
			
		}

}
