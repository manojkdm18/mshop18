/**
 * 
 */
package com.dao;

import java.util.ArrayList;
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
public class ProductDAO extends SuperDAO {

	public  Product FindByPk(Long id) {

		Transaction transaction = null;
		Product product = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			product = session.get(Product.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Product> findByFilteration(String pname, String sku, String subcat, String isactive, int min,
			int max, boolean flag) {
		Session session = HibernateUtility.getFactory().openSession();
		Transaction transaction = null;
		List<Product> listOfProduct = null;
		StringBuffer sb = new StringBuffer();
		boolean check = false;
		try {
			if (flag) {
				sb.append(" From Product product ");
			} else {
				sb.append(" Select count(*) from Product product ");
			}

			if (MshopUtils.isNotEmpty(pname) || MshopUtils.isNotEmpty(sku) || MshopUtils.isNotEmpty(subcat)
					|| MshopUtils.isNotEmpty(isactive)) {
				sb.append("where");

			}
			if (MshopUtils.isNotEmpty(pname)) {
				if (check)
					sb.append(" and product.productName=:pname ");
				else {
					sb.append(" product.productName=:pname ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(sku)) {
				if (check)
					sb.append(" and product.productSku=:sku ");
				else {
					sb.append(" product.productSku=:sku ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(subcat)) {
				if (check)
					sb.append(" and product.subcategory.scrfnum=:subcat ");
				else {
					sb.append(" product.subcategory.scrfnum=:subcat ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(isactive)) {
				if (check)
					sb.append(" and product.isActive=:isactive ");
				else {
					sb.append(" product.isActive=:isactive ");
					check = true;
				}
			}

			transaction = session.beginTransaction();
			Query query = session.createQuery(sb.toString());
			if (MshopUtils.isNotEmpty(pname)) {
				query.setParameter("name", pname);
			}
			if (MshopUtils.isNotEmpty(sku)) {
				query.setParameter("sku", sku);

			}
			if (MshopUtils.isNotEmpty(subcat)) {
				query.setParameter("subcat", Long.parseLong(subcat));

			}
			if (MshopUtils.isNotEmpty(isactive)) {
				query.setParameter("isactive", isactive);

			}
			
			//query.setFirstResult(min);
			//query.setMaxResults(max);
			
			listOfProduct = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfProduct;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Product> getAllRecords() {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		List<Product> retvalList = null;
		try {
			transaction = session.beginTransaction();
			retvalList = session.createQuery("from Product product where product.isActive= 'Y'").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return retvalList;
	}
	
	public Long totalProducts() {
		Session session = HibernateUtility.getSession();
	   Long totals = 0L;
		List<Product> retval = null;
		try {
			Query query = session.createQuery("Select count(*) from Product product");
			retval = query.list();
			 totals = Long.parseLong(retval.get(0)+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Product> getAllProductByCnd(String cndcode) {
		Session session = HibernateUtility.getSession();
		List<Product> retvalList = null;
		try {
			Query query = session.createQuery("from Product pro where pro.entity.cndcode =:cndcode and pro.isActive= 'Y'");
			query.setMaxResults(5);
			query.setString("cndcode", cndcode);
			retvalList = query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retvalList;
	}
	
	@SuppressWarnings("unchecked")
	public  Product findBySku(String sku) {
		Session session = HibernateUtility.getSession();
		Product obj = null;
		List<Product> retvalList = new ArrayList<Product>();
		try {
			Query query = session.createQuery("from Product pro where pro.productSku =:sku and pro.isActive= 'Y'");
			query.setString("sku", sku);
			retvalList = query.list();
			if(retvalList.size()>0) {
				obj = retvalList.get(0);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Product> getAllProductByCategory(String scrfnum) {
		Session session = HibernateUtility.getSession();
		List<Product> retvalList = null;
		try {
			
			Query query = session.createQuery("from Product pro  where pro.subcategory.scrfnum =:scrfnum and pro.isActive= 'Y'");
			query.setString("scrfnum", scrfnum);
			retvalList = query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retvalList;
	}
	
}
