package com.java.backendUtility;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FacesContexObject extends HttpServlet {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	    }    
	    protected abstract void processRequest(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException;

	    /** Handles the HTTP <code>GET</code> method.
	    * @param request servlet request
	    * @param response servlet response
	    */
	    protected void doGet(HttpServletRequest request, HttpServletResponse
	        response) throws ServletException, IOException {
	        processRequest(request, response); 
	    }
	    protected void log(FacesContext facesContext, String message) {
	        facesContext.getExternalContext().log(message);
	    }
	    /** Handles the HTTP <code>POST</code> method.
	    * @param request servlet request
	    * @param response servlet response
	    */ 
	    protected void doPost(HttpServletRequest request, HttpServletResponse
	        response) throws ServletException, IOException {
	        processRequest(request, response);
	    }
	    public static FacesContext getFacesContext(HttpServletRequest request,
	        HttpServletResponse response) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        if (facesContext == null) {

	            FacesContextFactory contextFactory  =
	                (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
	            LifecycleFactory lifecycleFactory =
	                (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY); 
	            Lifecycle lifecycle =
	                lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

	            facesContext =
	                contextFactory.getFacesContext(request.getSession().getServletContext(),
	                    request, response, lifecycle);

	            // Set using our inner class


	            // set a new viewRoot, otherwise context.getViewRoot returns null
	            UIViewRoot view =
	            facesContext.getApplication().getViewHandler().createView(facesContext, "adminLogin1.jsp");
	            facesContext.setViewRoot(view);        
	        }
	        return facesContext;
	    }
	   
	}


