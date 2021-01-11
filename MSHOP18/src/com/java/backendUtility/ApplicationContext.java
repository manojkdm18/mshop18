package com.java.backendUtility;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.Session;

import com.java.mshop.actionbean.CategoryManagementActionBean;


@WebListener
public class ApplicationContext implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(ApplicationContext.class.getName());

    
    public ApplicationContext() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	try {
    		Session session = HibernateUtility.getSession();
    		if(session !=null) {
    			logger.info("session created:"+session.toString());

    		}
    		} catch(Exception e) {
    			logger.info(e.getMessage());
    		}
    }
	
}
