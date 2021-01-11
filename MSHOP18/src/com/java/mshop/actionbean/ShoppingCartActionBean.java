/**
 * 
 */
package com.java.mshop.actionbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartItems;
import com.dao.CartItemsDAO;
import com.dao.Product;
import com.dao.ProductDAO;
import com.dao.User;
import com.dao.UserDAO;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.CartItemBean;
import com.java.mshop.beans.CommonSessionBean;
import com.java.mshop.beans.ProductDisplayBean;

/**
 * @author manoj
 *
 */
public class ShoppingCartActionBean implements Constants{
private static final Logger logger = Logger.getLogger(ShoppingCartActionBean.class.getName());

	  
	public CartItemBean getItemBean() {
		  return (CartItemBean) MshopUtils.getBean("CartItemBean");
	  }
	  
	public CommonSessionBean getSessionBean() {
		  return (CommonSessionBean) MshopUtils.getBean("CommonSessionBean");
	  }
	public ProductDisplayBean getProductBean() {
		  return (ProductDisplayBean) MshopUtils.getBean("ProductDisplayBean");
	  }
	  
	

	public String addToCartAction() {
		logger.info("inside addToCartAction() method");
		String message = "";
		Product product = null;
		
		try {
			CartItemBean backingBean = getItemBean();
			CommonSessionBean sessionBean = getSessionBean();
			ProductDisplayBean bean = getProductBean();
			HttpServletRequest req = MshopUtils.getservletRequest();
			String psku = req.getParameter("psku");
			List<CartItemBean> cartItemList = sessionBean.getCartItemList();
			if(MshopUtils.isNotEmpty(psku)) {
				product = new ProductDAO().findBySku(psku);
				if(!MshopUtils.isEmpty(product)) {
					if(!itemAlreadyExistInCart(product.getProductSku())) {
						
						if(MshopUtils.isNotEmpty(product.getPrfnum())) {
							bean.setPrfnum(product.getPrfnum()+"");
						}
						
						if (MshopUtils.isNotEmpty(product.getProductName())) {
							bean.setProductName(product.getProductName());

						}
						if (MshopUtils.isNotEmpty(product.getProductDesc())) {
							bean.setProductDesc(product.getProductDesc());

						}
						if (MshopUtils.isNotEmpty(product.getProductSku())) {
							bean.setProductSku(product.getProductSku());
						}

						if (MshopUtils.isNotEmpty(product.getPrice())) {
							bean.setPrice(product.getPrice() + "");
							backingBean.setTotal(product.getPrice()+"");
						}
						if (MshopUtils.isNotEmpty(product.getQuantity())) {
							backingBean.setQuantity(product.getQuantity()+"");
						}

						if (MshopUtils.isNotEmpty(product.getDiscount())) {
							bean.setDiscount(product.getDiscount() + "");
						}

						if (MshopUtils.isNotEmpty(product.getColour().getCndname())) {
							bean.setColour(product.getColour().getCndname());
						}

						if (MshopUtils.isNotEmpty(product.getBrand().getCndname())) {
							bean.setBrand(product.getBrand().getCndname());
						}
						if(MshopUtils.isNotEmpty(product.getImg1())) {
							bean.setImg1(product.getImg1());
						}
						if(MshopUtils.isNotEmpty(product.getImg2())) {
							bean.setImg1(product.getImg2());
						}
						if(MshopUtils.isNotEmpty(product.getImg3())) {
							bean.setImg1(product.getImg3());
						}
						
						if(MshopUtils.isNotEmpty(product.getImg4())) {
							bean.setImg1(product.getImg4());
						}
						
						backingBean.setProductBean(bean);
						cartItemList.add(backingBean);
						if(MshopUtils.isNotEmpty(sessionBean.getUserRfnum())) {
							saveCartItemsForUser(product.getProductSku());
						}
						message = ADDED;
					}else {
						message = NOTADDED;
					}
				}
			}
			sessionBean.setCartItemList(cartItemList);
			sessionBean.setCartSize(cartItemList.size()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
		
	}
	
	private void saveCartItemsForUser(String psku) {
		logger.info("inside saveCartItemsForUser() method");
		CommonSessionBean sessionBean = getSessionBean();
		List<CartItemBean> cartItems = sessionBean.getCartItemList();
		String userRfnum = sessionBean.getUserRfnum();
		try {
			if (userRfnum != null ) {
				User user = new UserDAO().FindByPK(Long.parseLong(userRfnum));
				if (user != null) {
					cartItems.forEach(items -> {
						if(psku.equalsIgnoreCase(items.getProductBean().getProductSku())) {
						CartItems cartObj = new CartItems();
						cartObj.setUserRfnum(user.getUserrfnum());
						cartObj.setProductRfnum(Long.parseLong(items.getProductBean().getPrfnum()));
						cartObj.setProductSku(items.getProductBean().getProductSku());
						cartObj.setQuantity(1);
						cartObj.setIsActive(Y);
						cartObj.setCreateDate(new Date());
						cartObj.setCreatedby(Integer.parseInt(userRfnum));
						cartObj.setModifiedDate(new Date());
						cartObj.setModifiedby(Integer.parseInt(userRfnum));
						new CartItemsDAO().save(cartObj);
						logger.info("cart data saved.");
						}
					});
					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteShoppingCartRecords(String productSku) {
		CommonSessionBean sessionBean = getSessionBean();
		String userRfnum = sessionBean.getUserRfnum();
		try {
			if (userRfnum != null) {
				if (MshopUtils.isNotEmpty(productSku)) {
					Product product = new ProductDAO().findBySku(productSku);
					CartItems items = new CartItemsDAO().findCartDataByPskuUrfnum(product.getProductSku(),
							Long.parseLong(userRfnum));
					if (items != null) {
						new CartItemsDAO().delete(items);
						logger.info("data removed from database ");
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String deleteItemFromCart() {
		logger.info("inside deleteItemFromCart() method");
		CommonSessionBean sessionBean = getSessionBean();
		HttpServletRequest req = MshopUtils.getservletRequest();
		String psku = req.getParameter("psku");
		String message = FAILD;
		List<CartItemBean> list = new ArrayList<>();
		try {
			if (MshopUtils.isNotEmpty(psku)) {
				if (!sessionBean.getCartItemList().isEmpty()) {
					list = sessionBean.getCartItemList();
					for (int i = 0; i < list.size(); i++) {
						String SKU = list.get(i).getProductBean().getProductSku();
						logger.info("item to be removed ==>" + SKU);
						if (psku.equals(SKU)) {
							list.remove(i);
							deleteShoppingCartRecords(psku);
							sessionBean.setCartSize(list.size()+"");
							message = SUCCESS;
							logger.info("Item removed from Cart");
						}
					}
				}
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String updateShoppingCart() {
		logger.info("inside updateShoppingCart() method");
		CommonSessionBean sessionBean = getSessionBean();
		HttpServletRequest req = MshopUtils.getservletRequest();
		String psku = req.getParameter("psku");
		String qty = req.getParameter("qty");
		String userRfnum = sessionBean.getUserRfnum();
		double price = 0;
		String message = FAILD;
		List<CartItemBean> list = new ArrayList<>();

		try {
			if (MshopUtils.isNotEmpty(psku)) {
				logger.info("Product :"+psku);
				if (!sessionBean.getCartItemList().isEmpty()) {
					list = sessionBean.getCartItemList();
					for (CartItemBean cartList : list) {
						if (psku.equals(cartList.getProductBean().getProductSku())) {
							if (MshopUtils.isNotEmpty(qty)) {
								logger.info("Price before Calculating :"+cartList.getProductBean().getPrice());
								price = Double.parseDouble(cartList.getProductBean().getPrice())
										* Integer.parseInt(qty);
								cartList.setTotal(price+"");
								cartList.getProductBean().setQuantity(qty);
								logger.info("Price After Calculating :"+cartList.getProductBean().getPrice());
								sessionBean.setCartSize(list.size()+"");
								message = SUCCESS;
								if(userRfnum != null) {
									CartItems cartObj = new CartItemsDAO().findCartDataByPskuUrfnum(cartList.getProductBean().getProductSku(),
											Long.parseLong(userRfnum));
									cartObj.setQuantity(Integer.parseInt(cartList.getProductBean().getQuantity()));
									new CartItemsDAO().update(cartObj);
								}
							}
						}
					}
					
				}
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;

	}
	
	public boolean itemAlreadyExistInCart(String psku) {
		CommonSessionBean sessionBean = getSessionBean();
		List<CartItemBean> cartItemList = sessionBean.getCartItemList();
		if(!cartItemList.isEmpty() && cartItemList.size() > 0)
		for(CartItemBean list : cartItemList) {
			if(psku.equals(list.getProductBean().getProductSku())) {
				return true;
			}
		}
		return false;
		
	}

}
