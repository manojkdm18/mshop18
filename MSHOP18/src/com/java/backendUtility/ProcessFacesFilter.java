package com.java.backendUtility;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.User;
import com.java.mshop.actionbean.UserManagementActionBean;

@WebFilter("/faces/staging/*")
@MultipartConfig
public class ProcessFacesFilter implements Filter {
	private static final Logger logger = Logger.getLogger(ProcessFacesFilter.class.getName());

	public ProcessFacesFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("inside filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		 HttpSession session = req.getSession();
		FacesContext ctxobj = FacesContext.getCurrentInstance();
		String init_action = "";
		String expression = "";
		if (ctxobj == null) {
			FacesContext ctx = FacesContexObject.getFacesContext(req, resp);
			logger.info("context object  created");
		}
		String uri = req.getRequestURI();
		String pageName = uri.substring(uri.lastIndexOf("/") + 1);
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/faces/staging/admin/adminLogin.jsp");
			rd.forward(req, resp);
			return ;
		}else if(user != null && !pageName.isEmpty()) {
			logger.info("currently login user is ===>>>>"+user.getFirstName());
			init_action = pageName.substring(0, pageName.indexOf("."));
			String s = init_action.substring(0, 1).toUpperCase() + init_action.substring(1);
			String className = s + "ActionBean";
			if (isExistBean(className)) {
				String methodName = init_action + "_Init()";
				String createmethod = className + "." + methodName;
				expression = "#{" + createmethod + "}";
				logger.info(expression);
				evalAsString(expression);
			}
		}
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public static String evalAsString(String p_expression) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication().evaluateExpressionGet(context, p_expression, String.class);
	}

	private boolean isExistBean(String bean) {
		Object obj = MshopUtils.getBean(bean);
		if (obj != null)
			return true;
		else
			return false;

	}
	
}
