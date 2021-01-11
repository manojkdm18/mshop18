<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::My Cart::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/stylecss/catelogue.css">
</head>
<body>
  <div class="modal-dialog modal-xl modal-dialog modal-dialog-scrollable">
    <div class="modal-content">
<div class="modal-header">
        <h5 class="modal-title text-muted"> Shopping Cart (${CommonSessionBean.cartSize} Item)  </h5>
         <button type="button" class="close crossbtn" data-dismiss="modal" aria-label="Close">
           <span aria-hidden="true">&times;</span>
         </button>
      </div>
  <div class="modal-body">
<div class="myCart_section">
<c:choose>
<c:when test="${not empty CommonSessionBean.cartItemList}">

<table class="table text-muted borderless">
  <thead class="bg-muted">
    <tr>
      <th scope="col"><p> Item Details </p></th>
      <th scope="col"><p> Quantity </p></th>
      <th scope="col"> <p> Price</p></th>
      <th scope="col"><p>Sub Total<p></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="cartitem" items="${CommonSessionBean.cartItemList}">
    <tr>
     <td>
     <div class="row">
      <div class="col-3">
            <img class="img-fluid mx-4" width="50" height="60" src="${pageContext.request.contextPath}/media/productImg/${cartitem.productBean.img1}" alt="Card image cap" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'">
      </div>
      <div class="col-9">
     <a href="${pageContext.request.contextPath}/product?pr=${cartitem.productBean.productSku}"
	 class="text-muted"><p>${cartitem.productBean.productDesc}</p></a>
     <p class="small"> Product SKU : ${cartitem.productBean.productSku}</p>
       <i class="fa fa-trash red small deletePSKU" id="${cartitem.productBean.productSku}" onclick="return deleteItem(this);"><span class="h7">&nbsp;Remove</span></i>
     <input type="hidden" id="psku_${cartitem.productBean.productSku}" value="${cartitem.productBean.productSku}"/>
      </div>
      </div>
     </td>
      <td>
      <select name="qty" class="qty_${cartitem.productBean.productSku}" id="${cartitem.productBean.productSku}" onchange="return updateCart(this);">
      <c:forEach var="j" begin="1" end="${cartitem.quantity}">  
      <c:choose>
      <c:when test="${cartitem.productBean.quantity eq j}">
      <option value="${j}" selected="selected">${j}</option>
      </c:when>
      <c:otherwise>
       <option value="${j}">${j}</option>
      </c:otherwise>
      </c:choose>
        </c:forEach>  
      </select>
      </td>
      <td> <h6> ${cartitem.productBean.price} /-</h6></td>
      <td>
        <c:set var="subtotal" value="${cartitem.total}"></c:set>
        <c:set var="total" value="${subtotal + total}"></c:set>
      <h6>${subtotal}/-</h6>
      </td>
    </tr>
    </c:forEach>
    <tr>
    <td></td>
    <td></td>
    <td><h5>Total</h5></td>
    <td><h4 class="text-danger">${total} /-</h4></td>
    </tr>
     <tr>
    <td></td>
    <td></td>
    <td></td>
    <td>
    <c:choose>
    <c:when test="${ empty CommonSessionBean.userRfnum }">
         <a href="#" data-toggle="modal" data-target="#loginModal" data-dismiss="modal" aria-label="Close" id="sigin_links">Sign In</a>
             </c:when>
    <c:otherwise>
     <a href="${pageContext.request.contextPath}/checkout" class="btn btn-danger btn-block">ORDER NOW</a>
    </c:otherwise>
    </c:choose>
    </td>
    </tr>
    
  </tbody>
</table>

       </c:when>
     <c:otherwise>
     <h3 class="text-muted text-center">Shopping Cart Is Empty</h3>
     </c:otherwise>
     </c:choose>
</div>
</div>
</div>
</div>
</body>
</html>