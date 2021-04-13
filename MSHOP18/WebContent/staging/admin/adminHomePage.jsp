<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::DASHBOARD::</title>
</head>
<f:view>
<body>
<div>
<jsp:include page="/staging/admin/adminHeader.jsp"></jsp:include>
</div>
<div class="row">
<div class="col-3">
<jsp:include page="/staging/admin/sideBar.jsp"></jsp:include>
</div>
<div class="col-9">
<div class="home_page_record">
<div class="records" id="dashboard_data">

</div>
</div>
</div>
</div>
<div class="" style="margin-top:80px;">
<jsp:include page="/staging/admin/adminFooter.jsp"></jsp:include>
</div>
<script src="${pageContext.request.contextPath}/backend/commonJs/dashboard.js"></script>
 </body>
 </f:view>
</html>