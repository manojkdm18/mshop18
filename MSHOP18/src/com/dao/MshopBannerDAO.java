package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

public class MshopBannerDAO extends SuperDAO{
	
	public  MshopBanner FindByPK(Long id) {

		Transaction transaction = null;
		MshopBanner banner = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			banner = session.get(MshopBanner.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return banner;
	}
	
	@SuppressWarnings("unchecked")
	public  List<MshopBanner> getAllRecords(String cndcode) {
		Session session = HibernateUtility.getSession();
		List<MshopBanner> retvalList = null;
		try {
			Query query = session.createQuery("from MshopBanner msb where msb.type.cndcode =:cndcode and msb.isActive= 'Y' ");
			query.setString("cndcode", cndcode);
			retvalList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retvalList;
	}
	

}
