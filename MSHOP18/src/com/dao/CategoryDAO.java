/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;
import com.java.backendUtility.MshopUtils;

/**
 * @author manojkdm18
 *
 */
public class CategoryDAO extends SuperDAO {

	public  Category FindByPk(Long id) {

		Transaction transaction = null;
		Category cat = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			cat = session.get(Category.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cat;
	}
	
	public static List<Category> findByFilteration(String catrfnum, String catName,String isActive, int min,
			int max, boolean flag) {
		Session session = HibernateUtility.getFactory().openSession();
		Transaction transaction = null;
		List<Category> listOfcat = null;
		StringBuffer sb = new StringBuffer();
		boolean check = false;
		try {
			if (flag) {
				sb.append(" From Category cat ");
			} else {
				sb.append(" Select count(*) from Category cat ");
			}

			if (MshopUtils.isNotEmpty(catrfnum) || MshopUtils.isNotEmpty(catName) 
					|| MshopUtils.isNotEmpty(isActive)) {
				sb.append("where");

			}
			if (MshopUtils.isNotEmpty(catrfnum)) {
				if (check)
					sb.append(" and cat.catrfnum=:catrfnum ");
				else {
					sb.append(" cat.catrfnum=:catrfnum ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(catName)) {
				if (check)
					sb.append(" and cat.catName=:catName ");
				else {
					sb.append(" cat.catName=:catName ");
					check = true;
				}
			}
			
			if (MshopUtils.isNotEmpty(isActive)) {
				if (check)
					sb.append(" and cat.isActive=:isActive ");
				else {
					sb.append(" cat.isActive=:isActive ");
					check = true;
				}
			}

			transaction = session.beginTransaction();
			Query query = session.createQuery(sb.toString());
			if (MshopUtils.isNotEmpty(catrfnum)) {
				query.setParameter("catrfnum", Long.parseLong(catrfnum));
			}
			if (MshopUtils.isNotEmpty(catName)) {
				query.setParameter("catName", catName);

			}
			
			if (MshopUtils.isNotEmpty(isActive)) {
				query.setParameter("isActive", isActive);

			}
			
			//query.setFirstResult(min);
			//query.setMaxResults(max);
			
			listOfcat = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfcat;
	}

	@SuppressWarnings("unchecked")
	public  List<Category> getAllRecords() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<Category> retvalList = null;
		try {
			transaction = session.beginTransaction();
			retvalList = session.createQuery("from Category cat").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return retvalList;
	}
	
	public Long totalCategory() {
		Session session = HibernateUtility.getSession();
	   Long totals = 0L;
		List<Category> retval = null;
		try {
			Query query = session.createQuery("Select count(*) from Category cat");
			retval = query.list();
			 totals = Long.parseLong(retval.get(0)+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
	}
}
