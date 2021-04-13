package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

public class CityMasterDAO extends SuperDAO{
	
	public  CityMaster findByPk(int id) {

		Transaction transaction = null;
		CityMaster obj = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			obj = session.get(CityMaster.class, id);
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
	public  List<CityMaster> getAllRecords() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<CityMaster> retvalList = null;
		try {
			transaction = session.beginTransaction();
			retvalList = session.createQuery("from CityMaster city ").list();
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
