package com.java.backendUtility;

import org.hibernate.Session;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Session session = HibernateUtility.getFactory().openSession();
       System.out.println(session);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
