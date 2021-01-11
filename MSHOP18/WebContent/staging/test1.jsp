<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img class="img-fluid" width="50" height="50" src="/home/manojkdm18/manoj/MSHOP18/WebContent/media/bannerImg/t-shirt.jpg" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/media/img/errorImg.png'"/>
<form action="upload" method="post" enctype="multipart/form-data" >
<pre>
<label>Name:</label>
<input type="text" name="name" >
<input type="file" name="file" multiple />
<input type="submit" value="submit">
</pre>
</form>
</body>
</html>