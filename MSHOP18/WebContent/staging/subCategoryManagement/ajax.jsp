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
 <c:when test="${flag eq 'subcatList' }">
 <%@page import="com.java.mshop.actionbean.SubCategoryManagementActionBean"%>
   <%
      request.setAttribute("CategoryManagementBean",new SubCategoryManagementActionBean().searchResult());
   %>
   <jsp:include page="/staging/subCategoryManagement/subCategoryManagementResult.jsp"></jsp:include>
 </c:when>
 </c:choose>
</body>

</html>