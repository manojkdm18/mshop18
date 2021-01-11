package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

public class SuperDAO {
	

	public Serializable save(Object obj) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		Serializable pk = null;
		try {
			transaction = session.beginTransaction();
			pk = session.save(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return pk;
	}
	
	public  void delete(Object obj) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	public  void update(Object obj) {
		Transaction transaction = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public  List<Object> getAllRecords(Object obj) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<Object> listOfUser = null;
		try {
			transaction = session.beginTransaction();
			listOfUser = session.createQuery("from ").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}
    
	public  Object findByPK(Long id) {

		Transaction transaction = null;
		Object obj = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			obj = session.get(Object.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return obj;
	}
}
