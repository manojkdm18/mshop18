/**
 * 
 */
package com.java.mshop.actionbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.dao.Address;
import com.dao.AddressDAO;
import com.dao.CartItems;
import com.dao.CartItemsDAO;
import com.dao.Product;
import com.dao.ProductDAO;
import com.dao.User;
import com.dao.UserDAO;
import com.java.backendUtility.BuyerAccountUtility;
import com.java.backendUtility.Constants;
import com.java.backendUtility.GlobalMessageConstants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.BuyerAddressBean;
import com.java.mshop.beans.CartItemBean;
import com.java.mshop.beans.CommonSessionBean;
import com.java.mshop.beans.ProductDisplayBean;
import com.java.mshop.beans.UserManagementBean;

/**
 * @author manoj
 *
 */
public class BuyerAccountActionBean {

private static final Logger logger = Logger.getLogger(BuyerAccountActionBean.class.getName());
	
	  public BuyerAddressBean getAddBean() {
		  return (BuyerAddressBean) MshopUtils.getBean("BuyerAddressBean");
	  }
	
	  public UserManagementBean getBean() {
		  return (UserManagementBean) MshopUtils.getBean("UserManagementBean");
	  }
	
		public CartItemBean getItemBean() {
			return (CartItemBean) MshopUtils.getBean("CartItemBean");
		}

		public CommonSessionBean getSessionBean() {
			return (CommonSessionBean) MshopUtils.getBean("CommonSessionBean");
		}

		public ProductDisplayBean getProductBean() {
			return (ProductDisplayBean) MshopUtils.getBean("ProductDisplayBean");
		}

	public String feLoginUser() {
		logger.info("user login processs start");
		HttpServletRequest req = MshopUtils.getRequest();
		UserManagementBean bean = getBean();
		UserDAO dao = new UserDAO();
		User user = null;
		String mobileNo = null;
		String password = null;
		try {
			MshopUtils.setnewProperty(bean, req);
			logger.info(bean.toString());
			mobileNo = bean.getMobileNo();
			password = bean.getUpassword();
			logger.info("mobile number for validate =>"+mobileNo);
			logger.info("password  for validate =>"+password);
			if (MshopUtils.isNotEmpty(mobileNo) && MshopUtils.isNotEmpty(password)) {
				user = dao.getUserByMobileNoPass(mobileNo, password, Constants.W);
				if(user != null) {
					logger.info("valid user for mshop18 ==>>>"+user.getFirstName());
					logger.info("welcome "+user.getFirstName());
					bean.setMessage(GlobalMessageConstants.LOGIN_SUCCESS);
					setSessionData(user);
				}else {
					bean.setMessage(GlobalMessageConstants.INVALID_CREDENTIALS);
					logger.info(bean.getMessage());
				}
			}else {
				logger.info("getting null data");
			}

		} catch (Exception e) {
			bean.setMessage(Constants.ERROR);
			e.printStackTrace();
		}
		
		return bean.getMessage();
	}
	
	public String feRegisterUser() {
		logger.info("user register processs start");
		HttpServletRequest req = MshopUtils.getRequest();
		UserManagementBean bean = getBean();
		UserDAO dao = new UserDAO();
		User user = null;
		boolean isMobNoExists = false;
		boolean isEmailIdExists = false;

		try {
			MshopUtils.setnewProperty(bean, req);
			logger.info(bean.toString());

			if (MshopUtils.isNotEmpty(bean.getEmailId())) {
				isEmailIdExists = BuyerAccountUtility.isEmailIdExists(bean.getEmailId());
				if(isEmailIdExists) 
					bean.setMessage(GlobalMessageConstants.EMAIL_ID_ALREADY_EXISTS);
				
			}else if (MshopUtils.isNotEmpty(bean.getMobileNo())) {
				isMobNoExists = BuyerAccountUtility.isMobileNoExists(bean.getMobileNo());
				if(isMobNoExists) 
					bean.setMessage(GlobalMessageConstants.MOBILE_NO_ALREADY_EXISTS);
			} else {
				user = new User();
				
				if (MshopUtils.isNotEmpty(bean.getFirstName())) {
					user.setFirstName(bean.getFirstName());

				}
				if (MshopUtils.isNotEmpty(bean.getLastName())) {
					user.setLastName(bean.getLastName());

				}
				if (MshopUtils.isNotEmpty(bean.getEmailId())) {
					user.setEmail(bean.getEmailId());
				}
				if (MshopUtils.isNotEmpty(bean.getMobileNo())) {
					user.setMobile(bean.getMobileNo());

				}
				if (MshopUtils.isNotEmpty(bean.getUpassword())) {
					user.setPassword(bean.getUpassword());
				}

				user.setIsActive(true);
				user.setCreateDate(new Date());
				user.setModifiedDate(new Date());
				user.setCreatedby(0);
				user.setModifiedby(0);
				user.setUserType(Constants.W);
				Serializable pk = dao.save(user);
				if (pk != null) {
					bean.setUserRfnum(pk.toString());
					bean.setMessage(GlobalMessageConstants.REGS);
					bean.setStatus(true);
					logger.info("user register successfully ==>" + bean.getUserRfnum());

				} else {
					bean.setMessage(GlobalMessageConstants.REGF);
					bean.setStatus(false);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean.getMessage();
		
	}
	
	
	public void setSessionData(User user ) {
		logger.info("set session data of user ==>"+user.getFirstName());
		CommonSessionBean sessionBean = getSessionBean();
		try {
			sessionBean.setCartItemList(new ArrayList<CartItemBean>());
			sessionBean.setUserFirstName(user.getFirstName());
			sessionBean.setUserRfnum(user.getUserrfnum()+"");
			sessionBean.setUserLastName(user.getLastName());
			sessionBean.setUserEmail(user.getEmail());
			sessionBean.setUserLoginId(user.getMobile());
			sessionBean.setUserType(user.getUserType());
			sessionBean.setSessionId(sessionBean.getSessionId());
			sessionBean.setCartItemList(setUserShoppingCartData(sessionBean.getUserRfnum()));
			sessionBean.setCartSize(sessionBean.getCartItemList().size()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<CartItemBean> setUserShoppingCartData(String userRfnum) {
		logger.info("going to set shopping cart data of user ==>"+userRfnum);
		//CartItemBean backingBean = getItemBean();
		CommonSessionBean sessionBean = getSessionBean();
		List<CartItemBean> cartItemList = sessionBean.getCartItemList();
		Product product = null;
		try {
			if(MshopUtils.isNotEmpty(userRfnum)) {
				List<CartItems> cartList = new CartItemsDAO().findCartDataByUrfnum(Long.parseLong(userRfnum));
				if(!cartList.isEmpty()) {
					for(CartItems cart : cartList) {
						if(cart.getProductSku() != null) {
							product = new ProductDAO().findBySku(cart.getProductSku());
							if(product != null) {
								CartItemBean backingBean = new CartItemBean();
								ProductDisplayBean bean = new ProductDisplayBean();
								
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
								if (MshopUtils.isNotEmpty(cart.getQuantity())) {
									backingBean.setQuantity(cart.getQuantity()+"");
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

							}
						}
						
					}
				}else {
					logger.info("shopping cart data is empty.");

				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemList;
	}
	
	public String saveBuyerAddress() {
		logger.info("user address submit processs start");
		HttpServletRequest req = MshopUtils.getRequest();
		BuyerAddressBean bean = getAddBean();
		AddressDAO dao = new AddressDAO();
		Address address = null;
		boolean check = false;
	
		try {
			MshopUtils.setnewProperty(bean, req);
			logger.info(bean.toString());

			if (!MshopUtils.isEmpty(bean.getAddrfnum())) {
				address = dao.FindByPk(Long.parseLong(bean.getAddrfnum()));
				if (MshopUtils.isNotEmpty(address)) {
					check = true;
				} else {
					address = new Address();
				}
			} else {
				address = new Address();
			}

			if (MshopUtils.isNotEmpty(bean.getFirstName())) {
				address.setFirstName(bean.getFirstName());
			}
			if (MshopUtils.isNotEmpty(bean.getLastName())) {
				address.setLastName(bean.getLastName());

			}
			if (MshopUtils.isNotEmpty(bean.getEmail())) {
				address.setEmail(bean.getEmail());
			}
			if (MshopUtils.isNotEmpty(bean.getMobile())) {
				address.setMobile(bean.getMobile());

			}
			if (MshopUtils.isNotEmpty(bean.getLandmark())) {
				address.setLandmark(bean.getLandmark());

			}
			if (MshopUtils.isNotEmpty(bean.getAddressType())) {
				address.setAddressType(bean.getAddressType());

			}
			if (MshopUtils.isNotEmpty(bean.getMobile())) {
				address.setMobile(bean.getMobile());

			}
			if (MshopUtils.isNotEmpty(bean.getPincode())) {
				address.setPincode(Long.parseLong(bean.getPincode()));
			}
			if (MshopUtils.isNotEmpty(bean.getIsActive())) {
				if("Y".equalsIgnoreCase(bean.getIsActive()))
				address.setIsActive("Y");
				else
				address.setIsActive("N");	
			}

			if (check) {
				address.setModifiedDate(new Date());
				address.setModifiedby(0);
				dao.update(address);
				bean.setAddrfnum(address.getAddrfnum().toString());
				bean.setMessage(GlobalMessageConstants.SUCCESS);
				bean.setStatus(true);
				logger.info("data updated for ==>" + bean.getAddrfnum());

			} else {
				address.setCreateDate(new Date());
				address.setModifiedDate(new Date());
				address.setCreatedby(0);
				address.setModifiedby(0);
				Serializable pk = dao.save(address);
				if (pk != null) {
					bean.setAddrfnum(pk.toString());
					bean.setMessage(GlobalMessageConstants.SUCCESS);
					bean.setStatus(true);
					logger.info("data saved for ==>" + bean.getAddrfnum());

				} else {
					bean.setMessage(GlobalMessageConstants.FAILD);
					bean.setStatus(false);
				}

			}

		} catch (Exception e) {
			bean.setMessage(GlobalMessageConstants.FAILD);
			e.printStackTrace();
		}
		
		return bean.getMessage();
		
	}
	

   public void setAddressInSession(String rfnum) {
		BuyerAddressBean bean = getAddBean();
		AddressDAO dao = new AddressDAO();
		Address address = null;
		try {
			if (!MshopUtils.isEmpty(rfnum)) {
				address = dao.FindByPk(Long.parseLong(bean.getAddrfnum()));
				if (MshopUtils.isNotEmpty(address)) {
					bean.setFirstName(address.getFirstName());
					bean.setLastName(address.getLastName());
					bean.setEmail(address.getEmail());
					bean.setMobile(address.getMobile());
					bean.setLandmark(address.getLandmark());
					bean.setIsDefault(address.getIsDefault());
					bean.setPincode(address.getPincode()+"");
					bean.setCity(address.getCity().getCityrfnum()+"");
					bean.setState(address.getState().getSmrfnum()+"");
					bean.setCountry(address.getCountry().getCmrfnum()+"");
					bean.setUserrfnum(address.getUserrfnum()+"");
				}else {
					logger.info("no address found");
				}
			}
			
		} catch (Exception e) {
			logger.info(""+e.getMessage()+"--"+e.getStackTrace()[0].getClassName()+"--"+e.getStackTrace()[0].getLineNumber());
		}
   }
}