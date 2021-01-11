<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    String path = request.getContextPath();
    pageContext.setAttribute("path" ,path+"/faces");
	pageContext.setAttribute("command" , request.getParameter("command"));
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
<h6 class="text-muted">BANNER MANAGEMENT</h6>
<hr class="top_hr"/>
</div>
<div class="col-6">
</div>
<div class="col-3">
         <a href="${path}/staging/bannerManagement/viewBannerManagement.jsp" class="search_btn">VIEW</a> 
         <a href="" class="search_btn">CANCEL</a>   
 </div>
   </div>
   </div>
    <hr class="hr_line">
          </div>
     <div>        
 <div class="search_container">
<div class="search_section">
<div class="text-muted h4">BANNER ONBOARDING</div>
<div class="my-4">
<c:if test="${ not empty BannerManagementBean.message }">
<div class="text-small text-danger">&#8277;<c:out value="${BannerManagementBean.message }"></c:out></div>
</c:if>
</div>
 <h:form enctype="multipart/form-data" styleClass="serachform">
   <div class="row my-4">
    <div class="col-6">
   <label class="text-muted">Banner  ID </label><span class="text-danger">*</span>
   <div><input type="text" name="brfnum" id="brfnum" value="${BannerManagementBean.brfnum }"  readonly="readonly"/></div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
      <label class="text-muted"> Type </label><span class="text-danger">*</span>
	 <select id="cndbanrfnum" name="cndbanrfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${BannerManagementBean.cndbanner_List}">
        <option value="${item.value}">${item.lable}</option>
      </c:forEach>
    </select>
     <p></p>
   </div>
   <div class="col-6">
   <label class="text-muted"> Url </label><span class="text-danger">*</span>
   <div><input type="text" name="title" id="title" class="compulsory" value="${BannerManagementBean.title }"/><p></p></div>
   </div>
   </div>
   <div class="row my-4">
    <div class="col-6">
   <label class="text-muted"> Sequence </label><span class="text-danger">*</span>
   <div><input type="text" name="info" id="info" class="compulsory" value="${BannerManagementBean.info }"/><p></p></div>
   </div>
   </div>
   <div class="row my-4">
    <div class="col-6">
   <h:outputText value="Theme : "></h:outputText>
     <div><h:inputFile value="#{BannerManagementBean.imageFile}" styleClass="text-danger compulsory"/>
     </div> 
 
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
   <div class="col-8">
   </div>
   <div class="col-4">
   <h:commandButton value="SUBMIT" id="search_btn" styleClass="common_submit_btn" onclick="return checkAllFiled();" action="#{BannerManagementActionBean.bannerOnboard }"/>
  </div>
   </div>
 </h:form>
</div>
</div>
     </div>
</div>
</div>
 <script src="${pageContext.request.contextPath}/backend/commonJs/common.js"></script>
 
</f:view>
</body>
</html>