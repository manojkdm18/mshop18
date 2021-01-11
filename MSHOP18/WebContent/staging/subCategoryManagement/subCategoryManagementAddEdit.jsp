<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
</head>
<%
  	pageContext.setAttribute("command" , request.getParameter("command"));
  %>
<body>
<div class="search_container">
<div class="search_section">
<c:if test="${ command eq 'add'}">
<div class="text-muted h4">CREATE</div>
</c:if>
<c:if test="${command eq 'edit'}">
<div class="text-muted h4">EDIT</div>
</c:if>
<c:if test="${ not empty SubCategoryManagementBean.message }">
<div class="text-small text-danger">&#8277;<c:out value="${SubCategoryManagementBean.message }"></c:out></div>
</c:if>
<form class="serachform my-4">
<div class="row my-4">
   <div class="col-6">
   <label class="text-muted">Sub Category  ID </label><span class="text-danger">*</span>
   <div><input type="text" name="catrfnum" id="catrfnum" value="${SubCategoryManagementBean.catrfnum }" readonly="readonly"/></div>
   </div>
   <div class="col-6">
   <label class="text-muted">Sub Category Name </label><span class="text-danger">*</span>
   <div><input type="text" name="catname" id="catname" class="compulsory" value="${SubCategoryManagementBean.catname }"/><p></p></div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
   <label class="text-muted">Description </label><span class="text-danger">*</span>
   <div><textarea name="catdesc" id="catdesc" class="compulsory" >${SubCategoryManagementBean.catdesc }</textarea><p></p></div>
   </div>
      <div class="col-6">
      <label class="text-muted">Is Active </label><span class="text-danger">*</span>
   <div class="form-check form-check-inline">
  <div><input class="form-check-input" type="radio" name="isActive" id="isActive" value="Y" checked></div>
  <label class="form-check-label" for="inlineRadio1" >YES</label>
</div>
<div class="form-check form-check-inline">
 <div> <input class="form-check-input" type="radio" name="isActive" id="isActiveN" value="N"></div>
  <label class="form-check-label" for="inlineRadio2">NO</label>
</div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
   <label class="text-muted"> Category </label><span class="text-danger">*</span>
   <div><select id="catListrfnum" name="catListrfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${SubCategoryManagementBean.cat_List}">
       <c:choose>
      <c:when test="${item.selected eq true }">
        <option value="${item.value}" selected="selected">${item.lable}</option>
      </c:when>
      <c:otherwise>
        <option value="${item.value}">${item.lable}</option>
        </c:otherwise>
        </c:choose>
      </c:forEach>
    </select>
    <p></p>
    </div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-8">
   </div>
   <div class="col-4">
   <input type="submit" value="SAVE" id="categoryaddbtn" class="common_submit_btn" onclick="return checkAllFiled();">
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