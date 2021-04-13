<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/stylecss/displayProduct.css">      
</head>
<body>
<header>
<jsp:include page="/web/mshopNavbar.jsp"></jsp:include>
</header>
  <div class="mshop_cat">
        <jsp:include page="/web/categoryBar.jsp"></jsp:include>
 </div>
  
<div class="product_details">
   <div class="Product_container">
    <div class="row">
      <div class="col-6">
        <div class="row my-2">
          <div class="img-hover-zoom">
          <img src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img1}" id="myimage" class="main_img mx-4" height="400" width="350" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'"/>
       </div>
        </div>
        <div class="row">

          <div class="img_carasuel_section">
            
            <div class="card-deck">
              <div class="cards">
                <div class="card-body text-center">
<img class="img-fluid mspimages" id="msimg_${ProductDisplayBean.img1}" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img1}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">

                </div>
              </div>
              <div class="cards">
                <div class="card-body text-center">
<img class="img-fluid mspimages" id="msimg_${ProductDisplayBean.img2}" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img2}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">
                </div>
              </div>
              <div class="cards">
                <div class="card-body text-center">
<img class="img-fluid mspimages" id="msimg_${ProductDisplayBean.img3}" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img3}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">
                </div>
              </div>
              <div class="cards">
                <div class="card-body text-center">
<img class="img-fluid mspimages" id="msimg_${ProductDisplayBean.img4}" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img4}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-6">
          <h3 class="text-muted"><i class="fa fa-heart-o wishlist"></i></h3>
        <div class="row my-2">
          <h4 class="text-muted">${ProductDisplayBean.productDesc}</h4>
        </div>
        <div class="row">
          <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item small"><a href="#">Home</a></li>
              <li class="breadcrumb-item small"><a href="#">Mobiles</a></li>
              <li class="breadcrumb-item active small" aria-current="page">Smart Phones</li>
            </ol>
          </nav>
           </div>
        <div class="row">
          <span class="text-muted text-sm-left">PRODUCT SKU : ${ProductDisplayBean.productSku}</span>
        </div>
        <div class="row my-2">
          <span><i class="fa fa-star text-warning"></i></span>        
          <span><i class="fa fa-star text-warning"></i></span>
          <span><i class="fa fa-star text-warning"></i></span>
          <span><i class="fa fa-star text-warning"></i></span>
          <span><i class="fa fa-star text-warning"></i></span>&nbsp;&nbsp;
          <span class="text-muted">1817 Reviews</span>
        </div>
        <div class="row my-2">
          <span class="text-muted h6"> MRP  
            <del>INR ${ProductDisplayBean.price}</del>  (Inclusive of all taxes)
         </span>
        </div>
        <div class="row my-2">
          <strong class="text-muted h3">INR ${ProductDisplayBean.price}</strong>
        </div>
        <div class="row my-2">
          <span class="text-muted small">Color : ${ProductDisplayBean.colour}</span>
        </div>
        <div class="row my-2">
          <span class="text-muted small">Brand : ${ProductDisplayBean.brand}</span>
        </div>
        <div class="row my-4">
        </div>
        <div class="row my-4">
        </div>
        <div class="row my-4">
        </div>
        
        <div class="row my-4">
        <input type="hidden" id="psku_${ProductDisplayBean.productSku}" value="${ProductDisplayBean.productSku}">
<input type="hidden" id="url" value="${pageContext.request.contextPath}/faces/web">
          <button class="btn btn-danger btn-block addtocart_btn my-4" id="${ProductDisplayBean.productSku}" onclick=" return addToCart(this);">+ ADD TO CART</button>
        </div>
      </div>
    </div>
   </div>
 </div>
 
 <div class="mshop_footers">
<jsp:include page="/web/mshopFooter.jsp"></jsp:include>
</div>
</body>
</html>