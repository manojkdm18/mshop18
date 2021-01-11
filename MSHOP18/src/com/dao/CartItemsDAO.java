/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

/**
 * @author manoj
 *
 */
public class CartItemsDAO extends SuperDAO{

	public  CartItems FindByPk(Long id) {

		Transaction transaction = null;
		CartItems cart = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			cart = session.get(CartItems.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cart;
	}
	
	@SuppressWarnings("unchecked")
	public  CartItems findCartDataByPskuUrfnum(String productSku,Long userRfnum) {
		Session session = HibernateUtility.getSession();
		CartItems items = null;
		List<CartItems> itemslist = null;
		try {
			Query query = session.createQuery("from CartItems cart where cart.productSku=:productSku and cart.userRfnum=:userRfnum and cart.isActive= 'Y' ");
			query.setString("productSku", productSku);
			query.setLong("userRfnum", userRfnum);
			itemslist = query.list();
			if(itemslist.size() > 0)
				items = itemslist.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;

	}
	
	@SuppressWarnings("unchecked")
	public  List<CartItems> findCartDataByUrfnum(Long userRfnum) {
		Session session = HibernateUtility.getSession();
    	List<CartItems> itemslist = null;
		try {
			Query query = session.createQuery("from CartItems cart where cart.userRfnum=:userRfnum and cart.isActive= 'Y' ");
			query.setLong("userRfnum", userRfnum);
			itemslist = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemslist;

	}
}


