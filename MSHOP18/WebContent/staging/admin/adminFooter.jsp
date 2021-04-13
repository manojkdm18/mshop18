<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style type="text/css">
.footer{
height: 8rem;
width: 100%;
margin:auto;
}
.footer p{
padding-top: 40px;
}
</style>
<body>
<footer>
   <div class="footer bg-dark">
   <div class="text">
        <p class="text-white text-center"> &copy; manoj.kdm18 <%=Calendar.getInstance().getWeekYear() %></p>
   </div>
   </div>
   </footer>
</body>
</html>