<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::ADMIN LOGIN::</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/admincss.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/bootstrap.min.css">
</head>
<body>
<f:view>
 <div class="container my-4">
    <div class="card" style="width: 25rem;">
        <div class="card-header">
            <h2 class="text-center my-4">MSHOP18</h2>
        </div>
        <div class="card-body">
         <div>
               <h:form id="form1">
                 <div class="form-group">
                     <input type="text" name="username" value="" id="username" placeholder="username"/>
                 </div>
                 <div class="form-group">
                 <input type="password" name="userpass" value="" id="userpass" placeholder="userpass" />
                </div>
                <input type="hidden" name="usertype" id="usertype" value="A"/>
                <div class="form-group my-4">
                <h:commandButton value="LOGIN" id="login_btn" styleClass="login_btn  btn-block" action="#{UserManagementActionBean.loginBEUser }"/>
                </div>
             </h:form>
             <div class="error">
             <h:messages styleClass="text-center" style="color:red; font-size:15px;" globalOnly="true"/> 
             </div> 
             <div class="forgot_pass text-center">
             <a href="#">forget password?</a>
             </div>
             <div>
             <p class="text-center text-muted"> &copy; software @manoj.kdm18 2020</p>
             </div>
         </div>
        </div>
      </div>
      </div>
      <jsp:include page="/staging/commonCssJsLink.jsp"></jsp:include>
      
</f:view>
</body>
</html>