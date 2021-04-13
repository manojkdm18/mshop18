package com.java.backendUtility;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ElEvalExp extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse
		        response) throws ServletException, IOException {
		        processRequest(request, response); 
		    }
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		String exp = "#{UserManagedActionBean.userManaged_Init}";
		readAnnotations(exp,req,resp);
		
	}

	public static Annotation[] readAnnotations(String p_expression,HttpServletRequest req, HttpServletResponse resp)
	{
		try {
			if (p_expression.startsWith("#{") && p_expression.endsWith("}"))
			{
				int delimiterPos = p_expression.lastIndexOf('.');
				String beanExp = p_expression.substring(0, delimiterPos) + "}";
				String fieldName = p_expression.substring(delimiterPos + 1, p_expression.length() - 1);
				Object container = evalAsObject(beanExp);
				Class<? extends Object> c = container.getClass();
				Field declaredField = c.getDeclaredField(fieldName);
				
				Annotation[] s = declaredField.getAnnotations();

				
				Method[] methods = c.getDeclaredMethods();
				for (Method m : methods) {
					if (m.getName().contains("test")) {
							m.invoke(m);
					}

				/*while (c != null)
				{
					Field declaredField;
					try
					{
						declaredField = c.getDeclaredField(fieldName);
						if (null != declaredField)
						{
							return declaredField.getAnnotations();
						}
					}
					catch (NoSuchFieldException e)
					{
						// let's try with the super class
						c = c.getSuperclass();
					}
					catch (SecurityException e)
					{
						System.err.println("Unable to access a field");
						e.printStackTrace();
						return null;
					}
				}*/
			}
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	

	public static Object evalAsObject(String p_expression)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		ExpressionFactory expressionFactory = context.getApplication().getExpressionFactory();
		ELContext elContext = context.getELContext();
		ValueExpression vex = expressionFactory.createValueExpression(elContext, p_expression, Object.class);
		Object obj = (Object) vex.getValue(elContext);
		return obj;
	}



}
