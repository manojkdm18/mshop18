<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path" ,path+"/faces");
	
  %>
<div class="card my-4">
<div class="card-body">

  <c:choose>
  <c:when test="${not empty UserManagedBean.displist }">
  <div class="header_top"><b class="text-primary h4">Search Result</b>&nbsp; &nbsp; &nbsp;<span class="text-small text-muted"> show result :${UserManagedBean.count } / ${UserManagedBean.count }</span></div>
 <div class="my-4">
 <table class="table table-hover my-4">
  <thead>
    <tr>
      <th scope="col">SR NO.</th>
      <th scope="col">NAME</th>
      <th scope="col">EMAIL</th>
      <th scope="col">MOBILE</th>
      <th scope="col">ISACTVE</th>
      <th scope="col">EDIT</th>

    </tr>
  </thead>
  <tbody>
     <c:forEach var="item" items="${UserManagedBean.displist}">
      <c:set var="count" value="${count + 1 }"></c:set>
         <tr>
            <td>${count}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.mobile}</td>
            <td class="text-primary">${item.isactive}</td>
            <td><a href="${path}/staging/userManagement/userManagement.jsp?command=edit&id=${item.rfnum}"><i class="fa fa-pencil"></i></a></td>
            </tr> 
     </c:forEach>
  </tbody>
</table>
  </div>
  </c:when>
  <c:otherwise>
    <div class="text-danger h4">No Records Exist</div>
  </c:otherwise>
    </c:choose>
  
  </div>
  </div>
  
</body>
</html>