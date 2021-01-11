<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ page import="java.time.*,java.text.SimpleDateFormat,java.util.Date" %>
    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/bootstrap.min.css">
</head>
<body>
<%
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
Date date = new Date();   
%>
<div class="header">
<nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand text-white" href="#"><b id="brand">MSHOP18</b></a>
  <div class="content text-white">
   <i class="fa fa-user-circle-o" style="font-size:60px;color:#fff;margin-left:20px;"></i>
  </div>
  <div class="mx-4">
  <c:if test="${user.firstName ne null }">
      <strong class="text-white">Login as:${user.firstName}</strong></c:if><br>
      <p class="text-white" style="font-size:15px;"><%=formatter.format(date)%></p>
      </div>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav ml-auto">
            <a class="nav-item nav-link text-white" href="${pageContext.request.contextPath}/faces/staging/admin/adminAjax.jsp?flag=logout"><b>SignOut</b> &nbsp;<i class="fa fa-sign-out text-white" aria-hidden="true" style="font-size:25px;"></i></a>
     </div>
  </div>
</nav>
</div>

 <jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
</body>
</html>