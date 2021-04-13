/**
 * 
 */
package com.java.backendUtility;

import java.util.logging.Logger;

import com.dao.UserDAO;

/**
 * @author manoj
 *
 */
public interface BuyerAccountUtility {

	public static final Logger logger = Logger.getLogger(BuyerAccountUtility.class.getName());
	
	static boolean isMobileNoExists(String mobNo) {
		return new UserDAO().getUserByMobileNo(mobNo);
	}

	static boolean isEmailIdExists(String email) {
		return new UserDAO().getUserByEmailId(email);
	}

}
