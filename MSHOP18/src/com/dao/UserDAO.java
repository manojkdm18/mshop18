package com.dao;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.User;
import com.java.backendUtility.HibernateUtility;
import com.java.backendUtility.MshopUtils;

public class UserDAO extends SuperDAO {

	public  User FindByPK(Long id) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtility.getSession()) {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	public  User getUserByMail(String email) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			user = session.get(User.class, email);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return user;

	}
	
	@SuppressWarnings("unchecked")
	public  boolean getUserByMobileNo(String mobNo) {
		Session session = HibernateUtility.getSession();
		List<User> listOfuser = null;
		try {
			Query query = session.createQuery("from User user where user.mobile=:mobNo and user.IsActive= 'Y' ");
			query.setParameter("mobNo", mobNo);
			listOfuser = query.list();
			if(listOfuser.size() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	@SuppressWarnings("unchecked")
	public  boolean getUserByEmailId(String emailId) {
		Session session = HibernateUtility.getSession();
		List<User> listOfuser = null;
		try {
			Query query = session.createQuery("from User user where user.email=:emailId and user.IsActive= 'Y' ");
			query.setParameter("emailId", emailId);
			listOfuser = query.list();
			if(listOfuser.size() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}


	public  User getUserByEmailPass(String firstName, String password,String userType) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User user where user.firstName =:firstName and user.password =:password and user.userType=:userType ");
			query.setParameter("firstName", firstName);
			query.setParameter("password", password);
			query.setParameter("userType", userType);
			query.setCacheable(false);

			 user = (User) query.uniqueResult();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return user;

	}
	
	public  User getUserByMobileNoPass(String mobileNo, String password,String userType) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User user where user.mobile =:mobileNo and user.password =:password and user.userType=:userType ");
			query.setParameter("mobileNo", mobileNo);
			query.setParameter("password", password);
			query.setParameter("userType", userType);
			query.setCacheable(false);

			 user = (User) query.uniqueResult();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return user;

	}

	
	@SuppressWarnings("unchecked")
	public  List<User> findByFilteration(String name, String email, String mobile, String isactive, int min,
			int max, boolean flag) {
		Session session = HibernateUtility.getFactory().openSession();
		Transaction transaction = null;
		List<User> listOfuser = null;
		StringBuffer sb = new StringBuffer();
		boolean check = false;
		try {
			if (flag) {
				sb.append(" From User user ");
			} else {
				sb.append(" Select count(*) from User user ");
			}

			if (MshopUtils.isNotEmpty(name) || MshopUtils.isNotEmpty(email) || MshopUtils.isNotEmpty(mobile)
					|| MshopUtils.isNotEmpty(isactive)) {
				sb.append("where");

			}
			if (MshopUtils.isNotEmpty(name)) {
				if (check)
					sb.append(" and user.firstName=:name ");
				else {
					sb.append(" user.firstName=:name ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(email)) {
				if (check)
					sb.append(" and user.email=:email ");
				else {
					sb.append(" user.email=:email ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(mobile)) {
				if (check)
					sb.append(" and user.mobile=:mobile ");
				else {
					sb.append(" user.mobile=:mobile ");
					check = true;
				}
			}
			if (MshopUtils.isNotEmpty(isactive)) {
				if (check)
					sb.append(" and user.IsActive=:isactive ");
				else {
					sb.append(" user.IsActive=:isactive ");
					check = true;
				}
			}

			transaction = session.beginTransaction();
			Query query = session.createQuery(sb.toString());
			if (MshopUtils.isNotEmpty(name)) {
				query.setParameter("name", name);
			}
			if (MshopUtils.isNotEmpty(email)) {
				query.setParameter("email", email);

			}
			if (MshopUtils.isNotEmpty(mobile)) {
				query.setParameter("mobile", mobile);

			}
			if (MshopUtils.isNotEmpty(isactive)) {
				query.setParameter("isactive", true);

			}
			
			//query.setFirstResult(min);
			//query.setMaxResults(max);
			
			listOfuser = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfuser;
	}



	@SuppressWarnings("unchecked")
	public Long totalUsers() {
		Session session = HibernateUtility.getSession();
	   Long totals = 0L;
		List<User> listOfuser = null;
		try {
			Query query = session.createQuery("Select count(*) from User user");
			listOfuser = query.list();
			 totals = Long.parseLong(listOfuser.get(0)+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
	}
}

