package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.java.backendUtility.HibernateUtility;

public class MshopCndDAO extends SuperDAO {
	
	public  MshopCnd FindByPK(Long id) {

		Transaction transaction = null;
		MshopCnd cnd = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			cnd = session.get(MshopCnd.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cnd;
	}
	
	@SuppressWarnings("unchecked")
	public  List<MshopCnd> findByCndGroup(String cnd_grp) {
		Session session = HibernateUtility.getSession();
		List<MshopCnd> retvalList = null;
		try {
			Query query = session.createQuery("from MshopCnd cnd  where cnd.cndgroup=:cnd_grp and cnd.isActive = 'Y' ");
			query.setParameter("cnd_grp", cnd_grp);
			retvalList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retvalList;
	}
}
