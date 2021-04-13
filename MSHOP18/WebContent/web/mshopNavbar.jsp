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
  <header class="info__header bg-dark">
        <div class="subpart text-muted">
            <div class="row">
              <div class="col-2">
                <i class="fa fa-phone text-danger small"></i>&nbsp;<span class="text-white small">+91 8554906835</span>
              </div>
              <div class="col-2">
                <i class="fa fa-envelope text-danger small"></i>&nbsp;<span class="text-white small">kadammanoj213@gmail.com</span>
              </div>
              <div class="col-2">
                <i class="fa fa-instagram text-danger small"></i>&nbsp;<span class="text-white small">@manoj.kdm18</span>
              </div>
              <div class="col-4">

              </div>
              <div class="col-2">
                  <a class="nav-link text-white small" href="#"><i class="fa fa-truck"></i>&nbsp;Track Orders</a>

              </div>
            </div>
        </div>
      </header>
      <div class="mainHeader">
      <div class="mshop_navbar">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand text-white" href="${pageContext.request.contextPath}/faces/"><b>MSHOP18</b></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form class="form-inline my-2 my-lg-0  ml-auto">
                <input class="form-control global_search mr-sm-2 " type="search" placeholder="search" aria-label="Search">
                <button class="btn btn-sm text-dark my-2 my-sm-0 global_search_btn" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
              </form>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link text-white" href="#">WishList <span><i class="fa fa-heart-o text-white font-weight-bold" aria-hidden="true"></i>
              </span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-white" id="myShopingCart" data-toggle="modal" data-target="#myModal">
                   Cart <i class="fa fa-shopping-cart text-white font-weight-bold" aria-hidden="true"></i>
                   <span class="cart__size badge badge-pill badge-dark">${CommonSessionBean.cartSize}</span>
                    <span class="sr-only">unread messages</span>
                </a>
        
            </li>
            <!-- -->
            <c:choose>
              <c:when test="${ not empty CommonSessionBean.userFirstName }">
            <li class="nav-item dropdown active">
              <a class="nav-link  dropdown-toggle text-white font-weight-bold"  href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Hi,<c:out value="${CommonSessionBean.userFirstName }"></c:out>
              </a>
              <div class="dropdown-menu dropdown-menu-right bg-dark" aria-labelledby="navbarDropdown">
                <a class="dropdown-item text-white small" href="#">My Profile</a>
                <a class="dropdown-item text-white small" href="#">My WishList</a>
                <a class="dropdown-item text-white small" href="#">My Orders</a>
                <div class="dropdown-dividers"></div>
                <a class="dropdown-item bg-danger text-white font-weight-bold text-center" href="#">Logout</a>
              </div>
            </li>
            </c:when>
            <c:otherwise>
            <li class="nav-item dropdown active bg-dark user_icon">
                <a class="nav-link text-danger dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user-o text-white" aria-hidden="true"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right bg-dark" aria-labelledby="navbarDropdown">
                   <a class="dropdown-item text-white small" href="#" data-toggle="modal" data-target="#signupModal">New Customer? <b>SignUp</b></a>
                  <div class="dropdown-dividers"></div>
                  <a class="dropdown-item bg-danger text-white text-center font-weight-bold" data-toggle="modal" data-target="#loginModal" id="login__nav" href="#">Login</a>
                </div>
              </li> 
              </c:otherwise>
              </c:choose>
              <!-- <li class="nav-item">
                <a class="nav-link disabled" href="#">&nbsp;&nbsp;&nbsp;</a>
              </li> -->
          </ul>

        </div>
      </nav>
     
      
      </div>
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