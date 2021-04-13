package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

public class StateMasterDAO extends SuperDAO{
		
	public  StateMaster findByPk(int id) {

		Transaction transaction = null;
		StateMaster obj = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			obj = session.get(StateMaster.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public  List<StateMaster> getAllRecords() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<StateMaster> retvalList = null;
		try {
			transaction = session.beginTransaction();
			retvalList = session.createQuery("from StateMaster state ").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return retvalList;
	}
}
