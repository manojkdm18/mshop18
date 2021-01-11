<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <section>
        <div class="cat__header text-center">
        <div class="row">
          <div class="col-3"></div>
        <div class="col-6">
          <div class="row">
          <c:forEach var="item" items="${CommonSessionBean.catelogueData.category_List}">
              <div class="col-2">
                <a href="${pageContext.request.contextPath}/category/cr-${item.catrfnum}/${item.catrfnum}" class="text-muted small nav-link"><c:out value="${item.catName }"></c:out> </a>
              </div>
               </c:forEach>
            </div>
        </div>
            <div class="col-3"></div>
        </div>
        </div>
      </section>