<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card my-4">
<div class="card-body">
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path" ,path+"/faces");
	
  %>
  <c:choose>
  <c:when test="${not empty ProductManagementBean.displist }">
  <div class="header_top"><b class="text-primary h4">Search Result</b>&nbsp; &nbsp; &nbsp;<span class="text-small text-muted"> show result :${ProductManagementBean.count } / ${ProductManagementBean.count }</span></div>
 <div class="my-4">
 <table class="table table-hover my-4">
  <thead>
    <tr>
      <th scope="col">SR NO.</th>
      <th scope="col">PRODUCT NAME</th>
      <th scope="col">PRODUCT SKU</th>
      <th scope="col">IMAGE1</th>
      <th scope="col">PRICE</th>
      <th scope="col">DISCOUNT</th>
      <th scope="col">QUNATITY</th>
       <th scope="col">ISACTIVE</th>
        <th scope="col">EDIT</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach var="item" items="${ProductManagementBean.displist}">
      <c:set var="count" value="${count + 1 }"></c:set>
         <tr>
            <td>${count}</td>
            <td>${item.productName}</td>
            <td>${item.productSKU}</td>
             <td><img class="img-fluid" width="50" height="50" src="${pageContext.request.contextPath}/media/productImg/${item.productImg}" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'"/></td>
            <td>${item.price}</td>
             <td>${item.discount}</td>
            <td>${item.quantity}</td>
            <td class="text-primary">${item.isactive}</td>
            <td><a href="${path}/staging/productManagement/productManagement.jsp?command=edit&id=${item.rfnum}"><i class="fa fa-pencil"></i></a></td>
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