<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::MSHOP18 ::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/stylecss/catelogue.css">
</head>
<body>
<header>
<jsp:include page="/web/mshopNavbar.jsp"></jsp:include>
</header>
  <div class="mshop_cat">
        <jsp:include page="/web/categoryBar.jsp"></jsp:include>
 </div>
<div class="mshop_carausel">
<jsp:include page="/web/carausel.jsp"></jsp:include>
</div>
<div class="mshop_productcarausel">
<jsp:include page="/web/productCarausel.jsp"></jsp:include>
</div>
<div class="mshop_adbanner">
<jsp:include page="/web/adBanner.jsp"></jsp:include>
</div>
<div class="mshop_productcarausel">
<jsp:include page="/web/productCarausel.jsp"></jsp:include>
</div>
<div class="mshop_adbanner">
<jsp:include page="/web/adBanner.jsp"></jsp:include>
</div>
<div class="mshop_footers">
<jsp:include page="/web/mshopFooter.jsp"></jsp:include>
</div>
</body>
</html>