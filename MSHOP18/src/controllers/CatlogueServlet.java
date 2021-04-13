package controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.backendUtility.FacesContexObject;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.actionbean.CatelgoueDataActionBean;


@WebServlet("/faces/")
public class CatlogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CatlogueServlet.class.getName());
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacesContext ctx = FacesContexObject.getFacesContext(req, resp);
		getAllData();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
     
	public void getAllData() {
		logger.info("getting all data method started at =>"+System.currentTimeMillis());
		try {
			HttpServletRequest req = MshopUtils.getservletRequest();
			HttpServletResponse resp = MshopUtils.getResponse();
	             new CatelgoueDataActionBean().getAllCatelogueData();
	              resp.sendRedirect(req.getContextPath()+"/faces/web/catelogue.jsp");
				return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

