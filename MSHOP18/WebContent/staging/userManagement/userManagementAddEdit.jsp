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
<c:if test="${ not empty UserManagementBean.message }">
<div class="text-small text-danger">&#8277;<c:out value="${UserManagementBean.message }"></c:out></div>
</c:if>
<form class="serachform my-4" name="userform">
<div class="row my-4">
<div class="col-6">
   <label class="text-muted">User ID</label>
   <div><input type="text" name="userRfnum" id="userRfnum" value="${UserManagementBean.userRfnum}" readonly="readonly"/></div>
   </div>
</div>
<div class="row my-4">
   <div class="col-6">
   <label class="text-muted">First Name </label><span class="text-danger">*</span>
   <div><input type="text" name="firstName" id="firstName" value="${UserManagementBean.firstName }" class="compulsory"/>
   <p></p>
   </div>
   
   </div>
    <div class="col-6">
   <label class="text-muted">Last Name</label><span class="text-danger">*</span>
   <div><input type="text" name="lastName" id="lastName" class="compulsory" value="${UserManagementBean.lastName}"/>
      <p></p>
   </div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
   <label class="text-muted"> Email ID </label><span class="text-danger">*</span>
   <div><input type="text" name="emailId" id="emailId" class="compulsory" value="${UserManagementBean.emailId }"/><p></p></div>
   </div>
   <div class="col-6">
   <label class="text-muted">Mobile NO </label><span class="text-danger">*</span>
   <div><input type="text" name="mobileNo" id="mobileNo"  class="compulsory" value="${UserManagementBean.mobileNo}"/>
   <p></p>
   </div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
   <label class="text-muted">Password </label><span class="text-danger">*</span>
   <div><input type="password" name="upassword" id="upassword" class="compulsory" value="${UserManagementBean.upassword}"/>
   <p></p>
   </div>
   </div>
   <div class="col-6">
      <label class="text-muted">Country </label><span class="text-danger">*</span>
	 <select id="countryrfnum" name="countryrfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${UserManagementBean.country_List}">
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
   <label class="text-muted"> City </label><span class="text-danger">*</span>
   <div><select id="cityrfnum" name="cityrfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${UserManagementBean.city_List}">
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
   <div class="col-6">
   <label class="text-muted">State </label><span class="text-danger">*</span>
   <div><select id="staterfnum" name="staterfnum" class="form-control w-50 compulsory">
	  <option value="">----Please Select----</option>
      <c:forEach var="item" items="${UserManagementBean.state_List}">
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