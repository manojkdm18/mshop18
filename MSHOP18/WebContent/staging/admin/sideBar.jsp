<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
</head>
<body>
<%
 String path = request.getContextPath();
pageContext.setAttribute("path" ,path+"/faces");
%>
<div>
</div>
<div class="sidebar">
<div class="main">
  <div class="sidenav">
  <div class="list-group">
    <a href="${path}/staging/admin/adminHomePage.jsp" class="list-group-item ">DASHBOARD</a>
  <a href="${path}/staging/userManagement/userManagement.jsp" class="list-group-item ">USER MANAGEMENT</a>
  <a href="${path}/staging/productManagement/productManagement.jsp" class="list-group-item ">PRODUCT MANAGEMENT </a>
    <a href="${path}/staging/productManagement/productImageUpload.jsp" class="list-group-item ">PRODUCT IMAGE UPLOAD </a>
  <a href="${path}/staging/productManagement/productBulkUpload.jsp" class="list-group-item ">PRODUCT BULK UPLOAD </a>
    <a href="${path}/staging/categoryManagement/categoryManagement.jsp" class="list-group-item ">CATEGORY MANAGEMENT </a>
  <a href="#clients" class="list-group-item ">CATEGORY BULK UPLOAD</a>
  <a href="${path}/staging/subCategoryManagement/subCategoryManagement.jsp" class="list-group-item ">SUBCATEGORY MANAGEMENT</a>
     <a href="${path}/staging/bannerManagement/bannerManagement.jsp" class="list-group-item ">BANNER MANAGEMENT</a>
   
    <a href="#contact" class="list-group-item ">ORDER MANAGEMENT</a>
    <a href="#contact" class="list-group-item ">SUB ORDER MANAGEMENT</a>
     <a href="#contact" class="list-group-item ">BRAND MANAGEMENT</a>
    <a href="#contact" class="list-group-item ">CITY MANAGEMENT</a>
    <a href="#contact" class="list-group-item ">STATE MANAGEMENT</a>
    <a href="#contact" class="list-group-item ">COUTNRY MANAGEMENT</a>
        <a href="#contact" class="list-group-item ">COUTNRY MASTER</a>
        <a href="#contact" class="list-group-item ">COUTNRY MASTER</a>
        <a href="#contact" class="list-group-item ">COUTNRY MASTER</a>
        <a href="#contact" class="list-group-item ">COUTNRY MASTER</a>
        <a href="#contact" class="list-group-item ">COUTNRY MASTER</a>
        </div>
    
  
</div>
  
</div>
</div>
</body>
</html>