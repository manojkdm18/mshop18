<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:include page="/web/commonCssJsFiles.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/stylecss/catelogue.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/stylecss/modalcss.css">
</head>
<body>
<div class="mshop_header">
  <header class="info__header">
        <div class="subpart text-muted">
            <div class="row">
              <div class="col-2">
                <i class="fa fa-phone text-danger"></i>&nbsp;<span class="text-muted">+91 8554906835</span>
              </div>
              <div class="col-2">
                <i class="fa fa-envelope text-danger"></i>&nbsp;<span class="text-muted">kadammanoj213@gmail.com</span>
              </div>
              <div class="col-2">
                <i class="fa fa-instagram text-danger"></i>&nbsp;<span class="text-muted">@manoj.kdm18</span>
              </div>
              <div class="col-4">

              </div>
              <div class="col-2">
                  <a class="nav-link text-muted" href="#"><i class="fa fa-truck"></i>&nbsp;Track Orders</a>

              </div>
            </div>
        </div>
      </header>
      <div class="mainHeader">
        <nav>
        <div class="row">
          <div class="col-1"></div>
          <div class="col-3">
          <a class="navbar-brand text-dark" href="${pageContext.request.contextPath}/faces/">MSHOP18<span class="text-muted">.</span></a>
          </div>
          <div class="col-4">
            <form class="form-inline my-2 my-lg-0">
              <input class="global_search text-center" type="search" placeholder="Search Products and brand" aria-label="Search">
              <button class="global_searchbtn my-2 my-sm-0" type="submit">Search</button>
            </form>
          </div>
            <div class="col-4">
            <ul class="nav_Link">
              <li class="nav-item">
                <a class="nav-link text-dark" href="#">wishList&nbsp;<i class="fa fa-heart-o h4"></i></a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-dark" href="#" id="myShopingCart" data-toggle="modal" data-target="#myModal">cart&nbsp;<i class="fa fa-shopping-cart text-muted h4"></i><span class="cart_size_values mx-2">${CommonSessionBean.cartSize}</span></a>
              </li>
              <c:choose>
              <c:when test="${ not empty CommonSessionBean.userFirstName }">
                   <div class="dropdown my-2">
  <a class="nav-link text-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    	Hi,${ CommonSessionBean.userFirstName}
  </a>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">My Profile</a>
    <a class="dropdown-item" href="#">My Orders</a>
    <a class="dropdown-item text-danger" href="#">Logout</a>
  </div>
</div>
              </c:when>
              <c:otherwise>
             <li class="nav-item">
                <a class="nav-link text-dark" href="#" data-toggle="modal" data-target="#loginModal" id="login__nav">login&nbsp;<i class="fa fa-user-o h4"></i></a>
              </li>
                 </c:otherwise>
              </c:choose>
            </ul>
            </div>
            </div>
        </nav>
      </div>
        </div>
        
        <!-- modals -->
        <div id="myModal" class="modal fade" role="dialog">
    <!-- Modal content-->
      <div class="cart__data" id="cart__data">
      
      </div>
      </div>
    
      <!-- modal end -->
     
<input type="hidden" id="url" value="${pageContext.request.contextPath}/faces/web">
<div class="modal_sect">
<jsp:include page="/web/loginRegModal.jsp"></jsp:include>
</div>

      <!-- reg modal end -->
           <script src="${pageContext.request.contextPath}/frontend/jsfile/catelogue.js"></script>
           <script src="${pageContext.request.contextPath}/frontend/jsfile/displayProduct.js"></script>
           
</body>
</html>