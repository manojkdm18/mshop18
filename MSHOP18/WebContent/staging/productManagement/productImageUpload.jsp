<%@page import="com.java.mshop.actionbean.ProductManagementActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
</head>
<body>

<%
new ProductManagementActionBean().productList();
%>
<f:view>
<div>
        
<jsp:include page="/staging/admin/adminHeader.jsp"></jsp:include>
</div>
<div class="row">
<div class="col-2">
<jsp:include page="/staging/admin/sideBar.jsp"></jsp:include>
</div>
<div class="col-10">
<div class="common_btn">
<div class="btn_back">
<div class="row">
<div class="col-3">
<h6 class="text-muted">PRODUCT IMAGE UPLOAD</h6>
<hr class="top_hr"/>
</div>
<div class="col-6">
</div>
<div class="col-3">
         <a href="${pageContext.request.contextPath}/faces/staging/productManagement/productManagement.jsp?command=add" class="search_btn">CREATE</a> 
         <a href="#" class="search_btn">CANCEL</a>   
 </div>
   </div>
   </div>
    <hr class="hr_line">
          </div>
     <div>        
 <div class="search_container">
<div class="search_section">
<div class="text-muted h4">IMAGE UPLOAD</div>
<div class="my-4">
<h:messages style="color: red"></h:messages>  
</div>
 <h:form enctype="multipart/form-data">
   <div class="row my-4">
   <div class="col-6">
      <label class="text-muted">Choose Product </label><span class="text-danger">*</span>
	 <select id="imgprfnum" name="imgprfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${ProductManagementBean.product_List}">
        <option value="${item.value}">${item.lable}</option>
      </c:forEach>
    </select>
     <p></p>
   </div>
   
   </div>
   <div class="row my-4">
   <div class="col-6">
   <h:outputText value="Image 1: "></h:outputText>
     <div><h:inputFile value="#{ImageUploadBean.uploadedFile1}" styleClass="text-danger compulsory"/>
     </div>
   </div>
    <div class="col-6">
   <h:outputText value="Image 2: "></h:outputText>
     <div><h:inputFile value="#{ImageUploadBean.uploadedFile2}" styleClass="text-danger compulsory"/>
     </div>
   </div>
   </div>
   <div class="row my-4">
    <div class="col-6">
   <h:outputText value="Image 3: "></h:outputText>
     <div><h:inputFile value="#{ImageUploadBean.uploadedFile3}" styleClass="text-danger "/>
     </div>
   </div>
    <div class="col-6">
   <h:outputText value="Image 4: "></h:outputText>
     <div><h:inputFile value="#{ImageUploadBean.uploadedFile4}" styleClass="text-danger "/>
     </div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-8">
   </div>
   <div class="col-4">
   <h:commandButton value="SUBMIT" id="search_btn" styleClass="common_submit_btn" onclick="return checkAllFiled();" action="#{ProductManagementActionBean.FileUpload }"/>
   </div>
   </div>
 </h:form>
</div>
</div>
     </div>
</div>
</div>
 <script src="${pageContext.request.contextPath}/backend/commonJs/common.js"></script>
  <script src="${pageContext.request.contextPath}/backend/commonJs/productManagement.js"></script>
 
</f:view>
</body>
</html>