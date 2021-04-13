<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
</head>
<body>
<div class="search_container">
<div class="search_section">
<div class="text-muted h4">SEARCH</div>
<form class="serachform my-4">
<div class="row my-4">
   <div class="col-6">
   <label class="text-muted">Product Name </label>
   <div><input type="text" name="productName" id="productName" />
   </div>
   </div>
    <div class="col-6">
   <label class="text-muted"> Product SKU </label>
   <div><input type="text" name="productSku" id="productSku"/></div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
      <label class="text-muted">Sub Category </label>
	 <select id="subcatrfnum" name="subcatrfnum" class="form-control w-50">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${ProductManagementBean.subcat_List}">
        <option value="${item.value}">${item.lable}</option>
      </c:forEach>
    </select>
   </div>
      <div class="col-6">
      <label class="text-muted">Is Active :</label>
   <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isActive" id="isActive" value="Y" checked>
  <label class="form-check-label" for="isActive" >YES</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isActive" id="isActive" value="N">
  <label class="form-check-label" for="isActive">NO</label>
</div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-8">
   </div>
   <div class="col-4">
   <input type="button" value="SUBMIT" id="search_btn" class="common_submit_btn">
   <input type="reset" value="CLEAR" class="common_clear_btn"/>
   </div>
   </div>
</form>
</div>
</div>
<div class="result" id="serach__Result">
</div>

</body>
</html>