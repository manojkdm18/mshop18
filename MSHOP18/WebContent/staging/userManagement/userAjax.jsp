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
%> 
 <c:choose>
 <c:when test="${flag eq 'searchUser' }">
   <%
   	request.setAttribute("UserManagedBean", new UserManagementActionBean().searchResult());
   %>
   <jsp:include page="/staging/userManagement/userManagementSearchResult.jsp"></jsp:include>
 </c:when>
 </c:choose>
</body>

</html>