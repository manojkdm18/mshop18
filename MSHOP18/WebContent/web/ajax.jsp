<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("flag" , request.getParameter("flag"));
    System.out.println("flag ====>"+request.getParameter("flag"));
     
     
%> 
 <c:choose>
 <c:when test="${flag eq 'loadheader' }">
 <%@page import="com.java.mshop.actionbean.CatelgoueDataActionBean"%>
   <%
     //new CatelgoueDataActionBean().getAllCatelogueData();
   %>
 </c:when>
 <c:when test="${flag eq 'addToCart' }">
 <%@page import="com.java.mshop.actionbean.ShoppingCartActionBean"%>
   <%
     String message = new ShoppingCartActionBean().addToCartAction();
     out.print(message);
   %>
   
 </c:when>
 <c:when test="${flag eq 'myShopingCart' }">
 <%@page import="com.java.mshop.actionbean.ShoppingCartActionBean"%>
 <jsp:include page="/web/myCart.jsp"></jsp:include>
  </c:when>
 
 <c:when test="${flag eq 'deleteItem' }">
 <%@page import="com.java.mshop.actionbean.ShoppingCartActionBean"%>
   <%
      new ShoppingCartActionBean().deleteItemFromCart();
   %>
    <jsp:include page="/web/myCart.jsp"></jsp:include>
   </c:when>
   <c:when test="${flag eq 'updateCart' }">
 <%@page import="com.java.mshop.actionbean.ShoppingCartActionBean"%>
   <%
     new ShoppingCartActionBean().updateShoppingCart();
   %>
   <jsp:include page="/web/myCart.jsp"></jsp:include>
   </c:when>
   
   <c:when test="${flag eq 'login' }">
 <%@page import="com.java.mshop.actionbean.BuyerAccountActionBean"%>
   <%
     String message = new BuyerAccountActionBean().feLoginUser();
     out.print(message);
   %>
   
 </c:when>
 
 <c:when test="${flag eq 'signup' }">
 <%@page import="com.java.mshop.actionbean.BuyerAccountActionBean"%>
   <%
     String message = new BuyerAccountActionBean().feRegisterUser();
     out.print(message);
   %>
   
 </c:when>
 
 </c:choose>
