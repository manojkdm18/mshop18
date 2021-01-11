package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;
import com.java.backendUtility.MshopUtils;

public class SubCategoryDAO extends SuperDAO {

	public  SubCategory FindByPK(Long id) {

		Transaction transaction = null;
		SubCategory cat = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			cat = session.get(SubCategory.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cat;
	}
	
	public static List<SubCategory> findByFilteration(String catrfnum, String catName,String isActive, int min,
			int max, boolean flag) {
		Session session = HibernateUtility.getFactory().openSession();
		Transaction transaction = null;
		List<SubCategory> listOfcat = null;
		StringBuffer sb = new StringBuffer();
		boolean check = false;
		try {
			if (flag) {
				sb.append(" From SubCategory cat ");
			} else {
				sb.append(" Select count(*) from SubCategory cat ");
			}

			if (MshopUtils.isNotEmpty(catrfnum) || MshopUtils.isNotEmpty(catName) 
					|| MshopUtils.isNotEmpty(isActive)) {
				sb.append("where");

			}
			if (MshopUtils.isNotEmpty(catrfnum)) {
				if (check)
					sb.append(" and cat.scrfnum=:catrfnum ");
				else {
					sb.append(" cat.scrfnum=:catrfnum ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(catName)) {
				if (check)
					sb.append(" and cat.subcatName=:catName ");
				else {
					sb.append(" cat.subcatName=:catName ");
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
	public  List<SubCategory> getAllRecords() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<SubCategory> retvalList = null;
		try {
			transaction = session.beginTransaction();
			retvalList = session.createQuery("from SubCategory cat").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return retvalList;
	}
	public Long totalSubCategory() {
		Session session = HibernateUtility.getSession();
	   Long totals = 0L;
		List<SubCategory> retval = null;
		try {
			Query query = session.createQuery("Select count(*) from SubCategory subcat");
			retval = query.list();
			 totals = Long.parseLong(retval.get(0)+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
	}
}
