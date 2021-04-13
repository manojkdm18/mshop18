<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
  	pageContext.setAttribute("command" , request.getParameter("command"));
  %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
</head>
<body>
<div class="search_container">
<div class="search_section">
<c:if test="${ command eq 'add'}">
<div class="text-muted h4">CREATE</div>
</c:if>
<c:if test="${command eq 'edit'}">
<div class="text-muted h4">EDIT</div>
</c:if>
<c:if test="${ not empty ProductManagementBean.message }">
<div class="text-small text-danger">&#8277;<c:out value="${ProductManagementBean.message }"></c:out></div>
</c:if>
<form class="serachform">
<div class="row my-4">
<div class="col-6">
   <label class="text-muted">Product ID</label>
   <div><input type="text" name="prfnum" id="prfnum" value="${ProductManagementBean.prfnum}" readonly="readonly"/></div>
   </div>
</div>
<div class="row my-4">
   <div class="col-6">
   <label class="text-muted">Product Name </label><span class="text-danger">*</span>
   <div><input type="text" name="productName" id="productName" value="${ProductManagementBean.productName }" class="compulsory"/>
   <p></p>
   </div>
   
   </div>
    <div class="col-6">
   <label class="text-muted">Product Description</label><span class="text-danger">*</span>
   <div><input type="text" name="productDesc" id="productDesc" class="compulsory" value="${ProductManagementBean.productDesc}"/>
      <p></p>
   </div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
   <label class="text-muted"> Product SKU </label><span class="text-danger">*</span>
   <div><input type="text" name="productSku" id="productSku" class="compulsory" value="${ProductManagementBean.productSku }"/><p></p></div>
   </div>
    <div class="col-6">
   <label class="text-muted">Brand Name </label><span class="text-danger">*</span>
	 <select id="brand" name="brand" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${ProductManagementBean.cndbrand_List}">
        <option value="${item.value}">${item.lable}</option>
      </c:forEach>
    </select>
     <p></p>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
      <label class="text-muted"> Color </label><span class="text-danger">*</span>
	 <select id="colour" name="colour" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${ProductManagementBean.cndcolor_List}">
        <option value="${item.value}">${item.lable}</option>
      </c:forEach>
    </select>
     <p></p>
   </div>
   
   
   <div class="col-6">
      <label class="text-muted">Sub Category </label><span class="text-danger">*</span>
	 <select id="subcatrfnum" name="subcatrfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${ProductManagementBean.subcat_List}">
          <c:choose>
      <c:when test="${item.selected eq true }">
        <option value="${item.value}" selected="selected">${item.lable}</option>
      </c:when>
      <c:otherwise>
        <option value="${item.value}">${item.lable}</option>
        </c:otherwise>
        </c:choose>
      </c:forEach>
    </select><p></p>
   </div>
   </div>
    <div class="row my-4">
   <div class="col-6">
   <label class="text-muted"> Quantity </label><span class="text-danger">*</span>
   <div><input type="number" name="quantity" id="quantity" class="compulsory" value="${ProductManagementBean.quantity }"/><p></p></div>
   </div>
   <div class="col-6">
   <label class="text-muted">Price </label><span class="text-danger">*</span>
   <div><input type="number" name="price" id="price"  class="compulsory" value="${ProductManagementBean.price}"/>
   <p></p>
   </div>
   </div>
   </div>
    <div class="row my-4">
   <div class="col-6">
   <label class="text-muted"> Discount </label><span class="text-danger">*</span>
   <div><input type="number" name="discount" id="discount" class="compulsory" value="${ProductManagementBean.discount }"/><p></p></div>
   </div>
   
     <div class="col-6">
      <label class="text-muted"> Entity </label><span class="text-danger">*</span>
	 <select id="entity" name="entity" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${ProductManagementBean.cndentity_List}">
        <option value="${item.value}">${item.lable}</option>
      </c:forEach>
    </select>
     <p></p>
   </div>
   
   </div>
   
      <div class="row my-4">
      <div class="col-6">
      <label class="text-muted">Is Active </label><span class="text-danger">*</span>
   <div class="form-check form-check-inline">
  <div><input class="form-check-input" type="radio" name="isActive" id="inlineRadio1" value="Y" checked></div>
  <label class="form-check-label text-muted" for="inlineRadio1" >YES</label>
</div>
<div class="form-check form-check-inline">
  <div><input class="form-check-input" type="radio" name="isActive" id="inlineRadio2" value="N"></div>
  <label class="form-check-label text-muted" for="inlineRadio2">NO</label>
</div>
   </div>
    </div>
   <div class="row my-4">
   <div class="col-8">
   </div>
   <div class="col-4">
   <input type="submit" value="SAVE" id="useradd_btn" class="common_submit_btn" onclick="return checkAllFiled();">
   <input type="reset" value="CLEAR" class="common_clear_btn"/>
   <input type="hidden" name="command" value="add">
   <input type="hidden" name="isvalid" value="isvalid">
   </div>
   </div>
</form>
</div>
</div>
</body>
</html>