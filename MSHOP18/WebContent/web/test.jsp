<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en"> 

<head> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/stylecss/displayProduct.css">
<link rel="stylesheet"
          href= 
"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
    <script src= 
"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> 
    </script> 
    <script src= 
"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"> 
    </script> 
    <script src= 
"https://cdnjs.cloudflare.com/ajax/libs/jquery-zoom/1.7.21/jquery.zoom.js"> 
    </script>   
	<style> 
		body { 
			margin: 20px; 
		} 
		h1 { 
			color: green; 
		} 
		.container { 
			display: block; 
			padding: 0px; 
		} 
		
		.contain { 
			position:fixed; 
			left: 10%; 
			top: 15%; 
			width: 200px; 
			height: 200px; 
		} 
		
		img { 
			width: 400px; 
			height: 400px; 
		} 
	</style> 
</head> 

<body> 
<header>
<jsp:include page="/web/navbar.jsp"></jsp:include>
</header>
  <div class="mshop_cat">
        <jsp:include page="/web/categoryBar.jsp"></jsp:include>
 </div>
<div class="containers">
 <div class="heart"><i class="fa fa-heart-o text-muted h3"></i></div>
<div class="row">
<div class="col-6">
<div class="row">
<div class="col-4">
<div class="text-center mx-4 my-4">
<div class="row">
<img class="img-fluid" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img1}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">
</div>
<div class="row">
<img class="img-fluid" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img2}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">

</div>
<div class="row">
<img class="img-fluid" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img3}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">

</div>
<div class="row">
<img class="img-fluid" width="80" height="80" src="${pageContext.request.contextPath}/media/productImg/${ProductDisplayBean.img4}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">

</div>
</div>
</div>
<div class="col-8">
<div class="container-fluidss"> 
        <div class="parent"> 
            <img src= 
"https://media.geeksforgeeks.org/wp-content/uploads/20200112021554/maxresdefault7.jpg" class="imgages"> 
        </div> 
  
        <span class="contain"> 
            <!-- Into another container -->
        </span> 
    </div> 
</div>
</div>
</div>
<div class="col-6 my-4">
<div class="row">
<h1 class="text-muted">${ProductDisplayBean.productDesc}</h1>
</div>
<div class="row">
<div class="text-warning"><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star-half-o" aria-hidden="true"></i><i class="fa fa-star-half-o" aria-hidden="true"></i></div>
</div>
<div class="row">
<h4 class="text-muted">Product SKU : ${ProductDisplayBean.productSku}</h4>
</div>
<div class="row">
<p class="text-muted"><del class="h5"> MRP  Rs. ${ProductDisplayBean.price} (Inclusive of all taxes)</del></p>
</div>
<div class="row">
<p><h1 class="text-danger"> Rs. ${ProductDisplayBean.price}</h1> ${ProductDisplayBean.discount}% OFF 
</div>
<div class="row">
<h3 class="text-muted">Colour : ${ProductDisplayBean.colour}</h3>
</div>
<div class="row">
<h3 class="text-muted">Brand : ${ProductDisplayBean.brand}</h3>
</div>
<div class="row my-4 btn-section">
<input type="hidden" id="psku_${ProductDisplayBean.productSku}" value="${ProductDisplayBean.productSku}">
<input type="hidden" id="url" value="${pageContext.request.contextPath}/faces/web">

<button id="${ProductDisplayBean.productSku}" class="addToCartbtn btn orange-white btn_effect" onclick=" return addToCart(this);">Add To Cart</button>
<button id="buy" data-formid="150758110" class="btn orange btn_effect mx-4">Buy Now</button>
</div>
</div>
<div class="mx-4">
<h1 class="text-muted">Description:</h1>
<p class="h4">
Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular f</p>
<p class="h4">ront-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt</p>
<p class="h4"> components, and powerful JavaScript plugins. 
</p>
<div class="mx-4">
<h1 class="text-muted">Features:</h1>
<ol>
<li> RAM:2 GB </li>
<li> Screen Size (in cm):16.51 cm (6.5) </li>
<li> Front Camera:5 MP </li>
<li> Internal Memory:32GB </li>
<li> Rear Camera:13 MP </li>
</ol>
</div>
</div>
</div>
</div>
<div class="mshop_adbanner">
<jsp:include page="/web/mshopFooter.jsp"></jsp:include>
</div>


	
	
	<div class="container-fluid"> 
		<b>Move your Cursor Over the Image</b> 
		<div class="parent"> 
			<img src= 
"https://media.geeksforgeeks.org/wp-content/uploads/20200112021554/maxresdefault7.jpg" class="zoom"> 
		</div> 

		<span class="contain"> 
		<!-- Into another container -->
	</span> 
	</div> 

	<script> 
		$(document).ready(function() { 

			$('.parent').css('width', $('.zoom').width()); 

			$('.zoom') 
				.parent() 
				.zoom({ 
					magnify: 4, 
					target: $('.contain').get(0) 
				}); 
		}); 
	</script> 
</body> 

</html>			 
