<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
<c:url var="GravarEvento" value="${contextPath}/GravarEvento" > </c:url>

--%>

<%@include file="header.jsp" %>
  <br><br><br><br>
  <div class="container" style="margin-left: 30px">


   <div class="ui sizer vertical segment">
      <div class="ui huge header">  <c:out value="${ObjEvento.titulo}" /></div>

      <div class="ui two top attached buttons">
        <div class="ui grid">

         <div class="four wide column">  <div class="massive ui button primary">Comprar Ingresso</div></div>
       </div>
     <div class="ui divider"></div>
     <div class="ui images">
       <img src="https://unsplash.it/300/200/?random&n=1">
       <img src="https://unsplash.it/500/200/?random&n=2">
       <img src="https://unsplash.it/300/200/?random&n=3">
    </div>
      </div>
      <div class="ui attached segment">
        <p><c:out value="${ObjEvento}" /></p>
      </div>
    <div class="ui divider"></div>
   </div>

    <%--<c:out value="${ObjEvento}" /> --%>
  </div>
<%@include file="bottom.jsp" %>
