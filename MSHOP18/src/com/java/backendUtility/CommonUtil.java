package com.java.backendUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CommonUtil {

	public static boolean readWriteData(String path,Part file) throws IOException {
		boolean result = false;
		try(FileOutputStream outputstream = new FileOutputStream(path)){
		InputStream inputstream = file.getInputStream();
		byte[] data= new byte [inputstream.available()];
        inputstream.read(data);
        outputstream.write(data);
        result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	 @SuppressWarnings("unchecked")
	public static boolean fileUpload(String path) throws IOException {
		boolean result = false;
		try{
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		  ServletFileUpload fileUplaod = new ServletFileUpload(new DiskFileItemFactory());
		 
		List<FileItem> files = fileUplaod.parseRequest(req);
		  for(FileItem item : files) {
			  System.out.println("item.getName()"+item.getName());
			  item.write(new File(path+item.getName()));
		  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	 
	 public static String readConfiuguration(String key) {
		 String val = "";
			try {
				ResourceBundle resource = ResourceBundle.getBundle("config");
				Set<String> name = resource.keySet();
				InputStream is = Demo.class.getResourceAsStream("/config.properties");
				 Properties p = new Properties();
				p.load(is);
				val = p.getProperty(key);

			} catch (Exception e) {
		}
		return val;
	  }
}
