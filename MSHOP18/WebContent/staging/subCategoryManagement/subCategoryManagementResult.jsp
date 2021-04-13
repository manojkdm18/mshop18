<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
  <c:when test="${not empty SubCategoryManagementBean.displist }">
  <div class="header_top"><b class="text-primary h4">Search Result</b>&nbsp; &nbsp; &nbsp;<span class="text-small text-muted"> show result :${SubCategoryManagementBean.count } / ${SubCategoryManagementBean.count }</span></div>
 <div class="my-4">
 <table class="table table-hover my-4">
  <thead>
    <tr>
      <th scope="col">SR NO.</th>
      <th scope="col">SUB CATEGORY</th>
      <th scope="col">CATEGORY</th>
      <th scope="col">ISACTVE</th>
      <th scope="col">EDIT</th>

    </tr>
  </thead>
  <tbody>
     <c:forEach var="item" items="${SubCategoryManagementBean.displist}">
      <c:set var="count" value="${count + 1 }"></c:set>
         <tr>
            <td>${count}</td>
            <td>${item.catname}</td>
             <td>${item.category}</td>
            <td class="text-primary">${item.isactive}</td>
            <td><a href="${path}/staging/subCategoryManagement/subCategoryManagement.jsp?command=edit&id=${item.crfnum}"><i class="fa fa-pencil"></i></a></td>
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