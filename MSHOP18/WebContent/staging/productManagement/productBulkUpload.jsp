<%@page import="com.java.mshop.actionbean.UserManagementActionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::Product Bulk Upload::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
<jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
</head>
<f:view>
<body>
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
<h6 class="text-muted">Product Bulk Upload</h6>
<hr class="top_hr"/>
</div>
<div class="col-6">
</div>
<div class="col-3">
  </div>
   </div>
   </div>
    <hr class="hr_line">
          </div>
    <div>        
 <div class="search_containers mx-4">
<div class="search_sections">
<div class="my-4">
<h:messages style="color: red"></h:messages>  
</div>
<div class="row">
<div class="col-6">
 <h:form enctype="multipart/form-data">
 <div><label class="my-2">Download format to upload Data :</label></div>
<h:commandButton  value="Download Format" styleClass="common_submit_btn btn-block my-4" action="#{ProductBulkUploadAction.downloadFormat }"></h:commandButton>
</h:form>
</div>
<div class="col-6">
 <h:form enctype="multipart/form-data" >
   <h:outputText value="Choose Csv File: "></h:outputText>
     <div><h:inputFile value="#{ProductBulkUploadBean.uploadedFile1}" styleClass="text-danger compulsory"/>
     </div>
<h:commandButton  value="Upload Format" action="#{ProductBulkUploadAction.uploadProductData}" styleClass="common_submit_btn btn-block my-3" onclick="return checkAllFiled();"></h:commandButton>
</h:form>
</div>
</div>
</div>
</div>
     </div>
</div>
</div>
 <script src="${pageContext.request.contextPath}/backend/commonJs/common.js"></script> 
</body>
</f:view>
</html>
