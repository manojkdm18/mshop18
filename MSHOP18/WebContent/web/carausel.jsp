<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- web carausel start -->
 <section class="hero_banner" style="margin-top:0px;">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
          <c:forEach var="item" items="${CommonSessionBean.catelogueData.heroBanner_List}">
           <c:choose>
           <c:when test="${item.sequence eq '1' }">
            <div class="carousel-item active">
            <a href="${item.url }">  <img class="d-block w-100 h-100" src="${pageContext.request.contextPath}/media/bannerImg/${item.theme}" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/nobanner.png'"/> </a>
                         </div>
            </c:when>
            <c:otherwise>
            <div class="carousel-item">
           <a href="${item.url }">   <img class="d-block w-100" src="${pageContext.request.contextPath}/media/bannerImg/${item.theme}" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/nobanner.png'"/></a>
            </div>
            </c:otherwise>
            </c:choose>
            </c:forEach>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

      </section>
      
<!-- web carausel end -->


        <!-- sub banner start -->
    <div class="card-group">
     <c:forEach var="subbaner" items="${CommonSessionBean.catelogueData.subBanner_List}">
  <div class="card bg-custom">
    <div class="card-body text-center">
          <a href="${subbaner.url }">  <img class="img-fluid" src="${pageContext.request.contextPath}/media/bannerImg/${subbaner.theme}" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/nobanner.png'"/> </a>
    </div>
  </div>
  </c:forEach>
 </div>
    
