<%@page import="com.java.backendUtility.Demo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 ResourceBundle resource = ResourceBundle.getBundle("config");
String name=resource.getString("name");
pageContext.setAttribute("resource",resource);

%>
<h1><%=name %></h1>

<h1><c:out value="${resource['name']}"></c:out> </h1>
</body>
</html>