<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
</head>
<body>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path" ,path+"/faces");
	pageContext.setAttribute("command" , request.getParameter("command"));
  %>

<f:view>
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
<h6 class="text-muted">VIEW BANNER MANAGEMENT</h6>
<hr class="top_hr"/>
</div>
<div class="col-6">
</div>
<div class="col-3">
         <a href="${path}/staging/bannerManagement/bannerManagement.jsp" class="search_btn">CREATE</a> 
         <a href="" class="search_btn">CANCEL</a>   
 </div>
   </div>
   </div>
    <hr class="hr_line">
          </div>
     <div>        
 <div class="search_container">
<div class="search_section">
<div class="text-muted h4">VIEW BANNER</div>
<div class="my-4">

</div>
 </div>
</div>
     </div>
</div>
</div>
 <script src="${pageContext.request.contextPath}/backend/commonJs/common.js"></script>
 
</f:view>
</body>
</html>