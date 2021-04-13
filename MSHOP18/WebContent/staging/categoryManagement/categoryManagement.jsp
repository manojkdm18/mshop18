<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::categoryManagement::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
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
<div class="col-2" >
<jsp:include page="/staging/admin/sideBar.jsp"></jsp:include>
</div>
<div class="col-10">
<div class="common_btn">
<div class="btn_back">
<div class="row">
<div class="col-3" >
<h6 class="text-muted">CATEGORY MANAGEMENT</h6>
<hr class="top_hr"/>

</div>
<div class="col-6">
</div>
<div class="col-3">
 
<c:if test="${ command ne 'add' and command ne 'edit'}">
         <a href="${path}/staging/categoryManagement/categoryManagement.jsp?command=add" class="search_btn">CREATE</a> 
         <a href="${path}/categoryManagement/categoryManagement.jsp" class="search_btn">CANCEL</a>   
       
   </c:if>
      <c:if test="${command  eq 'add' or command eq 'edit'}">
               <a href="${path}/staging/categoryManagement/categoryManagement.jsp" class="search_btn">SEARCH</a>
         <a href="${path}/staging/categoryManagement/categoryManagement.jsp" class="search_btn">CANCEL</a>   
   </c:if>
 </div>
   </div>
   </div>
    <hr class="hr_line">
          </div>
    <div>
   <c:choose>
   <c:when test="${command eq 'add' or command eq 'edit'}">
      
            <jsp:include page="/staging/categoryManagement/categoryManagementAddEdit.jsp"></jsp:include>
   </c:when>
   <c:otherwise>
            <jsp:include page="/staging/categoryManagement/categoryManagementSearch.jsp"></jsp:include> 
   </c:otherwise>
   </c:choose> 
   </div>
</div>
</div>
     <script src="${pageContext.request.contextPath}/backend/commonJs/common.js"></script>
      <script src="${pageContext.request.contextPath}/backend/commonJs/categoryManagement.js"></script>
     
 </body>
</html>