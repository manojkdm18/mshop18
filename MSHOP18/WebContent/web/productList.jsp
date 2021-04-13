<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.pcontainer .card{
margin-left:13px !important;
margin-top:12px !important;
}
.pcontainer img{

}
</style>
</head>
<body>
<header>
<jsp:include page="/web/mshopNavbar.jsp"></jsp:include>
</header>
  <div class="mshop_cat">
        <jsp:include page="/web/categoryBar.jsp"></jsp:include>
 </div>
<div class="productList my-4">
<div class="row">
<div class="col-2 my-4">
<h6 class="text-muted text-center">Search by Filters</h6>
<div class="card">
<select >
<option >Mobiles</option>
<option>Tablets</option>
<option>SmartPhones</option>
<option>Mobiles</option>

</select>
</div>
</div>
<div class="col-10 w-100">
				<div class="pcontainer product_banner">
					<div class="row">
					<c:choose>
					
					<c:when test="${not empty CatelogueDataBean.allProductList}">
					<c:forEach var="item" items="${CatelogueDataBean.allProductList}">
								<div class="card" style="width: 230px;">
									<div class="heart ml-auto">
										<i class="fa fa-heart-o text-muted"></i>
									</div>
									<div class="text-center">
										<a href="${pageContext.request.contextPath}/product?pr=${item.productSku}"
								class="nav-link">
										<img class="img-fluid" width="100" height="60"
											src="${pageContext.request.contextPath}/media/productImg/${item.img1}"
											alt="Card image cap"
											onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">
									</a>
									</div>
									<div class="card-body">
										<h6 class="card-text text-muted">
											<c:out value="${item.productDesc}"></c:out>
										</h6>
										<p class="">
											<del class="text-muted h6">
												<c:out value="${item.price }"></c:out>
											</del>
											&nbsp;<span class="h5"><c:out value="${item.price }"></c:out></span>&nbsp;<span
												class="badge"><c:out value="${item.discount }"></c:out>
												off</span>
										</p>
									</div>
								</div>
						</c:forEach>
					
					</c:when>
					<c:otherwise>
					<h4 class="text-danger">no products founds.</h4>
					</c:otherwise>
					</c:choose>
						</div>
				</div>

			</div>
</div>
</div>
<div class="mshop_footer">
<jsp:include page="/web/mshopFooter.jsp"></jsp:include>
</div>
</body>
</html>