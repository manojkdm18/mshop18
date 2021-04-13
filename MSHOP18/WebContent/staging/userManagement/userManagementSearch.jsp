<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/formcss.css">
</head>
<body>
<div class="search_container">
<div class="search_section">
<div class="text-muted h4">SEARCH</div>
<form class="serachform my-4">
<div class="row my-4">
   <div class="col-6">
   <label class="text-muted">First Name :</label>
   <input type="text" name="sfirstName" id="firstName" value=""/>
   </div>
   <div class="col-6">
   <label class="text-muted">Email ID :</label>
   <input type="text" name="semailId" id="email" value=""/>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-6">
   <label class="text-muted">Mobile NO :</label>
   <input type="text" name="smobile" id="smobile" value=""/>
   </div>
      <div class="col-6">
      <label class="text-muted">Is Active :</label>
   <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isActive" id="isActive" value="Y" checked>
  <label class="form-check-label" for="isActive" >YES</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isActive" id="isActive" value="N">
  <label class="form-check-label" for="isActive">NO</label>
</div>
   </div>
   </div>
   <div class="row my-4">
   <div class="col-8">
   </div>
   <div class="col-4">
   <input type="button" value="SUBMIT" id="search_btn" class="common_submit_btn">
   <input type="reset" value="CLEAR" class="common_clear_btn"/>
   </div>
   </div>
</form>
</div>
</div>
<div class="result" id="serach__Result">
</div>

</body>
</html>