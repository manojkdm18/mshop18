package com.java.backendUtility;
import javax.servlet.http.HttpServletRequest;

public abstract class CommonAction implements Constants {
	   
    public void handle() {
    	HttpServletRequest req = MshopUtils.getRequest();
 	   String command = req.getParameter(COMMAND);
 	   String isvalid = req.getParameter(ISVALID);
 	   String id = req.getParameter("id");


    	if(ADD.equals(command)) {
    		if(MshopUtils.isNotEmpty(isvalid))
    		addEdit();
    		
    	}
    	if(EDIT.equals(command)) {
    			setvalues(id);
    	}
    }
	

   public abstract void addEdit() ;
   
	public abstract void search();
	
	 public abstract void setvalues(String id) ;
		


}
