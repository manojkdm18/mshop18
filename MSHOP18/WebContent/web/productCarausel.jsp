<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- product carousel start -->
 <section class="trending_product">
        <div class="infoheading my-4">
            <div class="headers">
              <h4 class="text-muted text-center">TRENDING PRODUCTS</h4>
            </div>
            <div class="entity_products my-4">
              <section class="product_banner">
                <div id="carouselExampleControlss" class="carousel slide" data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item active">
          			 <div class="card-deck">
                        <c:forEach var="item" items="${CommonSessionBean.catelogueData.newArrProduct_List}">
                        
                      <div class="card">
                        <div class="heart ml-auto"><i class="fa fa-heart-o text-muted"></i></div>
                        <div class="text-center">
                        <a class="card-text nav-link text-muted" href="${pageContext.request.contextPath}/product?pr=${item.productSku}">
                          <img class="card-img-top"src="${pageContext.request.contextPath}/media/productImg/${item.img1}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'"></a>
                        </div>
                        <div class="card-body">
                          <span class="small"><c:out value="${item.productDesc}"></c:out></span>
                          <p class=""><del class="text-muted h6"> <c:out value="${item.price }"></c:out> </del>&nbsp;<span class="h5"><c:out value="${item.price }"></c:out></span>&nbsp;<span class="badge"><c:out value="${item.discount }"></c:out> off</span></p>
                        </div>
                      </div>
                     
     
                      </c:forEach>
                      </div>
                    </div>    
                      <div class="carousel-item">
                       <div class="card-deck">
                        <c:forEach var="items" items="${CommonSessionBean.catelogueData.topSellProduct_List}">
                      <div class="card">
                        <div class="heart ml-auto"><i class="fa fa-heart-o text-muted"></i></div>
                        <div class="text-center">
                        <a class="card-text nav-link text-muted" href="${pageContext.request.contextPath}/product?pr=${items.productSku}">
                          <img class="card-img-top"src="${pageContext.request.contextPath}/media/productImg/${items.img1}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'"></a>
                        </div>
                        <div class="card-body">
                          <span class="small"><c:out value="${items.productDesc}"></c:out></span>
                          <p class=""><del class="text-muted h6"> <c:out value="${items.price }"></c:out> </del>&nbsp;<span class="h5"><c:out value="${items.price }"></c:out></span>&nbsp;<span class="badge"><c:out value="${items.discount }"></c:out> off</span></p>
                        </div>
                      </div>
                      </c:forEach>
                      </div>
                    </div>    
                  </div>
                  <a class="carousel-control-prev" href="#carouselExampleControlss" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                  </a>
                  <a class="carousel-control-next" href="#carouselExampleControlss" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                  </a>
                </div>
        
              </section>
            </div>
        </div>
       </section>
<!-- product carousel end -->
       
</html>