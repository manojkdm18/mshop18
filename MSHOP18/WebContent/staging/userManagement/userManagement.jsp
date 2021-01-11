<%@page import="com.java.mshop.actionbean.UserManagementActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::USER MANAGEMENT::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
</head>
<body>
  <%
    String path = request.getContextPath();
    pageContext.setAttribute("path" ,path+"/faces");
	pageContext.setAttribute("command" , request.getParameter("command"));
  %>
  <div>
        
<jsp:include page="/staging/admin/adminHeader.jsp"></jsp:include>
</div>
<div class="row">
<div class="col-2">
<jsp:include page="/staging/admin/sideBar.jsp"></jsp:include>
</div>
<div class="col-10">
<div class="common_btn">
<div class="btn_back">
<div class="row">
<div class="col-3">
<h6 class="text-muted">USER MANAGEMENT</h6>
<hr class="top_hr"/>
</div>
<div class="col-6">
</div>
<div class="col-3">
 
<c:if test="${ command ne 'add' and  command ne 'edit'}">
         <a href="${path}/staging/userManagement/userManagement.jsp?command=add" class="search_btn">CREATE</a> 
         <a href="${path}/staging/userManagement/userManagement.jsp" class="search_btn">CANCEL</a>   
       
   </c:if>
      <c:if test="${command  eq 'add' or command eq 'edit'}">
               <a href="${path}/staging/userManagement/userManagement.jsp" class="search_btn">SEARCH</a>
         <a href="${path}/staging/userManagement/userManagement.jsp" class="search_btn">CANCEL</a>   
   </c:if>
 </div>
   </div>
   </div>
    <hr class="hr_line">
          </div>
   <c:choose>
   <c:when test="${command eq 'add' or command eq 'edit'}">
            <jsp:include page="/staging/userManagement/userManagementAddEdit.jsp"></jsp:include>
   </c:when>
   <c:otherwise>
            <jsp:include page="/staging/userManagement/userManagementSearch.jsp"></jsp:include> 
   </c:otherwise>
   </c:choose> 
</div>
</div>
 <script src="${pageContext.request.contextPath}/backend/commonJs/common.js"></script>
  <script src="${pageContext.request.contextPath}/backend/commonJs/userManagement.js"></script>
 
</body>
</html>