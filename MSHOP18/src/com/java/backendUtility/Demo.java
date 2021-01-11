package com.java.backendUtility;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class Demo {
 
	  public static void readConfiuguration() {
		  try {
			  System.out.println("ajsbjbjbas");  
			  ResourceBundle resource = ResourceBundle.getBundle("config");
			  Set<String> name=resource.keySet();
			  InputStream is = Demo.class.getResourceAsStream("/config.properties");
			    Properties p=new Properties();  
			    p.load(is);  
			    System.out.println(p.getProperty("name"));  
			
		} catch (Exception e) {
		}
	  }
	  
	  public static void main(String[] args) {
		  readConfiuguration();
	}
}
