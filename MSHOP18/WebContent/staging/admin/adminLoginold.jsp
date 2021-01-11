<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::ADMIN LOGIN::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/bootstrap.min.css">
</head>
<%-- <body style="background-image: url('${pageContext.request.contextPath}/media/img/laptop1.jpg'); background-repeat:no-repeat; background-size:100%;" >
 --%>    
 <body>
 <div class="container my-4">
    <div class="card" style="width: 25rem;">
        <div class="card-header">
            <h2 class="text-center my-4">MSHOP18</h2>
        </div>
        <div class="card-body">
         <div>
               <form id="form1" method="post">
                 <div class="form-group">
                     <input type="text" name="username" value="" id="username" placeholder="username"/>
                 </div>
                 <div class="form-group">
                 <input type="password" name="userpass" value="" id="userpass" placeholder="userpass"/>
                </div>
                <input type="hidden" name="usertype" id="usertype" value="W"/>
                <div class="form-group my-4">
                <input type="button" value="LOGIN" id="login_btn" class="login_btn  btn-block"/>
                </div>
             </form>
             <div class="error">
             <p id="error__for__login" class="text-danger text-center text-small"></p>
             </div> 
             <div class="forgot_pass text-center">
             <a href="#">forget password?</a>
             </div>
             <div>
             <p class="text-center text-muted"> &copy software @manoj.kdm18 2020</p>
             </div>
         </div>
        </div>
      </div>
      </div>
      <jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/backend/commonJs/userManagement.js"></script>
      
</body>
</html>