package com.java.mshop.actionbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CityMaster;
import com.dao.CityMasterDAO;
import com.dao.CountryMaster;
import com.dao.CountryMasterDAO;
import com.dao.StateMaster;
import com.dao.StateMasterDAO;
import com.dao.User;
import com.dao.UserDAO;
import com.java.backendUtility.CommonAction;
import com.java.backendUtility.CommonDropDownUtils;
import com.java.backendUtility.Constants;
import com.java.backendUtility.MshopUtils;
import com.java.mshop.beans.UserManagementBean;
import com.java.mshop.displaybean.UserDisplayBean;

public class UserManagementActionBean extends CommonAction implements Constants {
	private static final Logger logger = Logger.getLogger(UserManagementActionBean.class.getName());
	
	public UserManagementBean getBean() {
		  return (UserManagementBean) MshopUtils.getBean("UserManagementBean");
	  }
	  

	public String userManagement_Init() {
		logger.info("----inside actionBean---");
		UserManagementBean backingBean = getBean();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req =(HttpServletRequest) ctx.getExternalContext().getRequest();
		Enumeration<String> name = req.getParameterNames();
		String command = req.getParameter(COMMAND);
		if(!EDIT.equalsIgnoreCase(command)) {
		backingBean.setCountry_List(CommonDropDownUtils.getCountryList(""));
		backingBean.setState_List(CommonDropDownUtils.getStateList(""));
		backingBean.setCity_List(CommonDropDownUtils.getCityList(""));
		logger.info("---getCountryList---"+backingBean.getCountry_List().get(0).getLable());
		}
		handle();
		return "";
	}

	@Override
	public void addEdit() {
		logger.info("inside add method");
		HttpServletRequest req = MshopUtils.getRequest();
		UserManagementBean bean = getBean();
		UserDAO dao = null;
		User user = null;
		try {
			  MshopUtils.setnewProperty(bean, req);
				logger.info(bean.toString());
				if (MshopUtils.isNotEmpty(bean.getUserRfnum())) {
					dao = new UserDAO();
					user = dao.FindByPK(Long.parseLong(bean.getUserRfnum()));
					if (MshopUtils.isNotEmpty(user)) {
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
						if (MshopUtils.isNotEmpty(bean.getCountryrfnum())) {
							CountryMaster country =  new CountryMasterDAO()
									.findByPk(Integer.parseInt(bean.getCountryrfnum()));
							user.setCountry(country);
						}
						if (MshopUtils.isNotEmpty(bean.getStaterfnum())) {
							StateMaster state =  new StateMasterDAO()
									.findByPk(Integer.parseInt(bean.getStaterfnum()));
							user.setState(state);
						}
						if (MshopUtils.isNotEmpty(bean.getCityrfnum())) {
							CityMaster city = new CityMasterDAO()
									.findByPk(Integer.parseInt(bean.getCityrfnum()));
							user.setCity(city);
						}

						if (MshopUtils.isNotEmpty(bean.getIsActive())) {
							if (Y.equals(bean.getIsActive())) {
								user.setIsActive(true);
							} else {
								user.setIsActive(false);
							}
						}
						user.setModifiedDate(new Date());
						user.setModifiedby(0);
						user.setUserType(W);
						dao.update(user);
						bean.setUserRfnum(user.getUserrfnum().toString());
						bean.setMessage(RUS);
						bean.setStatus(true);
					}
				} else {
					user = new User();
					dao = new UserDAO();
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

					if (MshopUtils.isNotEmpty(bean.getCountryrfnum())) {
						CountryMaster country = new CountryMasterDAO()
								.findByCountryRfnum(bean.getCountryrfnum());
						user.setCountry(country);
					}
					if (MshopUtils.isNotEmpty(bean.getStaterfnum())) {
						StateMaster state =  new StateMasterDAO()
								.findByPk(Integer.parseInt(bean.getStaterfnum()));
						user.setState(state);
					}
					if (MshopUtils.isNotEmpty(bean.getCityrfnum())) {
						CityMaster city = new CityMasterDAO()
								.findByPk(Integer.parseInt(bean.getCityrfnum()));
						user.setCity(city);
					}

					if (MshopUtils.isNotEmpty(bean.getIsActive())) {
						if (Y.equals(bean.getIsActive())) {
							user.setIsActive(true);
						} else {
							user.setIsActive(false);
						}
					}
					user.setCreateDate(new Date());
					user.setModifiedDate(new Date());
					user.setCreatedby(0);
					user.setModifiedby(0);
					user.setUserType(W);
				    Serializable pk = dao.save(user);
				  if(pk != null) {
					bean.setUserRfnum(pk.toString());
					bean.setMessage(RSS);
					bean.setStatus(true);
				}
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			bean.setMessage(ERROR);
			bean.setStatus(false);
			logger.info("-----------" + e.getMessage() + "--------------");
		}
		
		/*bean.setCountry_List(CommonDropDownUtils.getCountryList(user.getCountry().getCmrfnum()+""));
		bean.setState_List(CommonDropDownUtils.getStateList(user.getState().getSmrfnum()+""));
		bean.setCity_List(CommonDropDownUtils.getCityList(user.getCity().getCityrfnum()+""));*/
		
	}

	@Override
	public void search( ) {
	}
	
	public UserManagementBean searchResult() {
		int pageNumber = 1;
		int pageSize = 10;
		UserManagementBean bean = getBean();
		HttpServletRequest req = MshopUtils.getRequest();
		try {
			MshopUtils.setnewProperty(bean, req);
			List<UserDisplayBean> list = new ArrayList<UserDisplayBean>();
			List<User> userList = null;
			userList = new UserDAO().findByFilteration(bean.getSfirstName(), bean.getSemailId(), bean.getSmobile(),
					bean.getIsActive(), pageNumber, pageSize, true);
			if (MshopUtils.isNotEmpty(userList)) {
				for (User user : userList) {
					UserDisplayBean dispbean = new UserDisplayBean();
					dispbean.setRfnum(user.getUserrfnum() + "");
					dispbean.setName(user.getFirstName());
					dispbean.setEmail(user.getEmail());
					dispbean.setMobile(user.getMobile());
					if (user.getIsActive())
						dispbean.setIsactive(Y);
					else
						dispbean.setIsactive(N);
					list.add(dispbean);
				}
				bean.setDisplist(list);
				bean.setCount(userList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * userList = new UserDAO().findByFilteration(bean.getSfirstName(),
		 * bean.getSemailId(), bean.getSmobile(), bean.getIsActive(), pageNumber,
		 * pageSize, false); if (MshopUtils.isNotEmpty(userList)) {
		 * bean.setCount(userList.size()); }
		 */
		return bean;

	}

	@Override
	public void setvalues(String id) {
		UserManagementBean bean = getBean();
		if (!MshopUtils.isEmpty(id)) {
			User user = (User) new UserDAO().FindByPK(Long.parseLong(id));
			if (MshopUtils.isNotEmpty(user)) {
				
				if(MshopUtils.isNotEmpty(user.getUserrfnum())) {
				   bean.setUserRfnum(user.getUserrfnum().toString());	
				}
				
				if (MshopUtils.isNotEmpty(user.getFirstName())) {
					bean.setFirstName(user.getFirstName());

				}
				if (MshopUtils.isNotEmpty(user.getLastName())) {
					bean.setLastName(user.getLastName());

				}
				if (MshopUtils.isNotEmpty(user.getEmail())) {
					bean.setEmailId(user.getEmail());
				}
				if (MshopUtils.isNotEmpty(user.getMobile())) {
					bean.setMobileNo(user.getMobile());

				}
				if (MshopUtils.isNotEmpty(user.getPassword())) {
					bean.setUpassword(user.getPassword());
				}

				if (MshopUtils.isNotEmpty(user.getCountry().getCmrfnum())) {
					bean.setCountryrfnum(user.getCountry().getCmrfnum() + "");
				}
				if (MshopUtils.isNotEmpty(user.getState().getSmrfnum())) {
					bean.setCountryrfnum(user.getState().getSmrfnum() + "");
				}
				if (MshopUtils.isNotEmpty(user.getCity().getCityrfnum())) {
					bean.setCountryrfnum(user.getCity().getCityrfnum() + "");
				}

				if (MshopUtils.isNotEmpty(user.getIsActive())) {
					if (user.getIsActive()) {
						bean.setIsActive(Y);
					} else {
						bean.setIsActive(Y);
					}
				}
				
				bean.setCountry_List(CommonDropDownUtils.getCountryList(user.getCountry().getCmrfnum()+""));
				bean.setState_List(CommonDropDownUtils.getStateList(user.getState().getSmrfnum()+""));
				bean.setCity_List(CommonDropDownUtils.getCityList(user.getCity().getCityrfnum()+""));
			}

		}
	}

	
	public String loginBEUser() {
		logger.info("inside login()");
		UserManagementBean bean = getBean();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = MshopUtils.getservletRequest();
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String userpass = req.getParameter("userpass");
		String usertype = req.getParameter("usertype");
		logger.info("username:" + username);
		logger.info("userpass:" + userpass);
		String navigation = "";

		try {
			if (!MshopUtils.isNotEmpty(username) || !MshopUtils.isNotEmpty(userpass)) {
				navigation = "Please Enter Username and Password";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, navigation, ""));

			}

			if (MshopUtils.isNotEmpty(userpass) && MshopUtils.isNotEmpty(username)) {
				User user = new UserDAO().getUserByEmailPass(username, userpass, usertype);
				if (user != null) {
					logger.info("valid user for mshop18 " + user.getFirstName());
					logger.info(user.getFirstName()+",logged in at =>"+System.currentTimeMillis());
					session.setAttribute("user", user);	
					navigation = "adminHomePage.jsp?faces-redirect=true";
				} else {
					navigation = "X Incorrect Username and Password";
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, navigation, ""));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return navigation;

	}
	
	public void logoutUser() {
		logger.info("inside logout");
		try {
			HttpServletRequest req = MshopUtils.getservletRequest();
			HttpServletResponse resp = MshopUtils.getResponse();
			String flag = req.getParameter("flag");
			if ("logout".equalsIgnoreCase(flag)) {
				HttpSession session = MshopUtils.getSession();
				User user = (User) session.getAttribute("user");
				if (user != null) {
					logger.info("currently login user :" + user.getFirstName());
					session.removeAttribute("user");
					session.invalidate();
					RequestDispatcher rd = req.getRequestDispatcher("/staging/admin/adminLogin.jsp");
					rd.forward(req, resp);
					logger.info("logout successfully at ===>>>"+System.currentTimeMillis());
					return;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
