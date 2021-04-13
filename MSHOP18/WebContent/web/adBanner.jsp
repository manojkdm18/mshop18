<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<section>
	<div class="add_banner">
	<div class="card-columns">
	<c:forEach var="item" items="${CommonSessionBean.catelogueData.adBanner_List}">
	<div class="cards" style="width:400px">
    <div class="card-body">
    <a href="${item.url }"><img class="card-img-top" src="${pageContext.request.contextPath}/media/bannerImg/${item.theme}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/adnoimage.png'"></a>	
    </div>
  </div>
  </c:forEach>
	</div>
	</div>

</section>
