package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

public class CountryMasterDAO extends SuperDAO{
	
	public  CountryMaster findByPk(int id) {

		Transaction transaction = null;
		CountryMaster obj = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			obj = session.get(CountryMaster.class, id);
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
	public  List<CountryMaster> getAllRecords() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<CountryMaster> retvalList = null;
		try {
			transaction = session.beginTransaction();
			retvalList = session.createQuery("from CountryMaster country").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return retvalList;
	}
	
	public  CountryMaster findByCountryRfnum(String cmrfnum) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		CountryMaster cm = null;
		List<CountryMaster> retvalList = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from CountryMaster country where country.cmrfnum =:cmrfnum ");
			query.setString("cmrfnum", cmrfnum);
			retvalList = query.list();
			if(retvalList.size()>0) {
				cm = retvalList.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cm;
	}
	
	
}
