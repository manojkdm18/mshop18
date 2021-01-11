/**
 * 
 */
package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.backendUtility.HibernateUtility;

/**
 * @author manoj
 *
 */
public class AddressDAO extends SuperDAO {
	
	public  Address FindByPk(Long id) {

		Transaction transaction = null;
		Address cat = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			cat = session.get(Address.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cat;
	}


}
