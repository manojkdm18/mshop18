/**
 * 
 */
package com.dao;

import java.util.Date;

/**
 * @author manojkdm18
 *
 */
public class Order {
  
	private int orderId;
	private String orderStatus;
	private Date createDate;
	private Date modifiedDate;
	private boolean isActive;
	
	private User user;
	
}
