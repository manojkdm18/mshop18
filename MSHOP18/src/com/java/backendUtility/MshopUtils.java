package com.java.backendUtility;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;




public class MshopUtils {

	 public static ServletContext getservletContext() {
		 return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	 }
		
		 	 
	 public static Object getBean(String beanName){
		    Object bean = null;
		    FacesContext fc = FacesContext.getCurrentInstance();
		    if(fc!=null){
		         ELContext elContext = fc.getELContext();
		         bean = elContext.getELResolver().getValue(elContext, null, beanName);
		    }

		    return bean;
		}	

	 
	 public static HttpServletRequest getservletRequest() {
			FacesContext ctx = FacesContext.getCurrentInstance();
		 return (HttpServletRequest) (HttpServletRequest) ctx.getExternalContext().getRequest();
	 }
	 
	
	public static boolean isEmpty(Object obj) {
		 if(obj == null || obj == "") {
			 return true;
		 }else if(obj instanceof String && ((String) obj).isEmpty()) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 public static boolean isNotEmpty(Object obj) {
		 if(obj != null && obj != "") {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 public static HttpSession getSession() {
			return (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
		}
	 
	 

		public static HttpServletRequest getRequest() {
			return (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
		}
		
		public static HttpServletResponse getResponse() {
			return (HttpServletResponse) FacesContext.getCurrentInstance()
					.getExternalContext().getResponse();
		}

		public static String getUserName() {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			return session.getAttribute("username").toString();
		}

		public static String getUserId() {
			HttpSession session = getSession();
			if (session != null)
				return (String) session.getAttribute("userid");
			else
				return null;
		}
		
		public static String  invokeMethod(String m) {
			return "#{"+m+"}";
		}
		
	public static Object setProperty(String ClassName, HttpServletRequest req) throws ClassNotFoundException {
		Object clsInstance = null;
		Class cls = null;
		Class<?>[] paramTypes = {String.class, int.class};
		String  value ="";
		try {
			cls = Class.forName("com.java.mshop.beans." + ClassName);
			clsInstance = (Object) cls.newInstance();
			Map<String, String[]> map = req.getParameterMap();
			Method[] methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("set")) {
					for (Map.Entry<String, String[]> entry : map.entrySet()) {
						String methodName = "set" + entry.getKey();
						value = entry.getValue()[0];
						if (methodName.equalsIgnoreCase(m.getName())) {
							Class<?>[] type = m.getParameterTypes();
							if (type[0].getName().equals("java.lang.Long")) {
								Long newVal = Long.parseLong(value);
								m.invoke(clsInstance, newVal);
							} else if (type[0].getName().equals("int")) {
								int newVal = Integer.parseInt(value);
								m.invoke(clsInstance, newVal);
							} else {
								m.invoke(clsInstance, value);
							}
						}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clsInstance;
	}
		/*public static  addMessage(String msg) {
			return FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", msg));
		}*/
	
	
	
	public static void getProperty(String ClassName, HttpServletRequest req) throws ClassNotFoundException {
		Object clsInstance = null;
		Class cls = null;
		Class<?>[] paramTypes = {String.class, int.class};
		String  value ="";
		try {
			cls = Class.forName("com.java.mshop.beans." + ClassName);
			clsInstance = (Object) cls.newInstance();
			Map<String, String[]> map = req.getParameterMap();
			Method[] methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get")) {
					m.invoke(clsInstance);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static  void setnewProperty(Object obj, HttpServletRequest req) throws ClassNotFoundException {
		String  value ="";
		try {
			Map<String, String[]> map = req.getParameterMap();
			Class<? extends Object> cls = obj.getClass();
			Method[] methods = cls.getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("set")) {
					for (Map.Entry<String, String[]> entry : map.entrySet()) {
						String methodName = "set" + entry.getKey();
						value = entry.getValue()[0];
						if (methodName.equalsIgnoreCase(m.getName())) {
								m.invoke(obj, value);
							}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static  void setnewPropertyForUpload(Object obj, String[] array,String[] array1) throws ClassNotFoundException {
		String  value ="";
		try {
			Class<? extends Object> cls = obj.getClass();
			Method[] methods = cls.getDeclaredMethods();
						for (int j = 0; j < array.length; j++) {
							for (int i = 0; i < array1.length; i++) {
							String methodName = "set" + array1[i];
							setdata(methodName, array[i], methods, obj);
							}
						}
						

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void setnewPropertyForUpload(Map<String, String> map, Object obj) throws ClassNotFoundException {
		String value = "";
		try {
			Class<? extends Object> cls = obj.getClass();
			Method[] methods = cls.getDeclaredMethods();
			for (Entry<String, String> entry : map.entrySet()) {
				for (Method m : methods) {
					if (m.getName().startsWith("set")) {
						String methodName = "set" + entry.getKey();
						value = entry.getValue();
						if (methodName.equalsIgnoreCase(m.getName())) {
							m.invoke(obj, value);
						}
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setdata(String methodName,String array,Method[] methods,Object obj) {
		String value = "";
		try {
				for (Method m : methods) {
					if (m.getName().startsWith("set")) {
						if (methodName.equalsIgnoreCase(m.getName())) {
							value = array;
							m.invoke(obj, value);
							break;
						}
					}
				}
				
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	}

