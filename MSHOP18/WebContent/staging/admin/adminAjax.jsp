<%@page import="com.java.mshop.actionbean.AdminHomePageActionBean"%>
<%@page import="com.java.mshop.actionbean.UserManagementActionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("flag" , request.getParameter("flag"));
     String path = request.getContextPath();
%> 
 <c:choose>
 <c:when test="${flag eq 'logout' }">
  <% new UserManagementActionBean().logoutUser();
  %>
 </c:when>
 
  <c:when test="${flag eq 'dashboardDetails' }">
  <% new AdminHomePageActionBean().adminHomePage_Init(); %>
  <jsp:include page="/staging/admin/dashboard.jsp"></jsp:include>
 </c:when>
 </c:choose>
</body>

</html>