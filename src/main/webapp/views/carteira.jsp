<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<jsp:useBean id="random" class="com.iftm.util.RandomBean" scope="application" />
<%@include file="template/header.jsp" %>

<div style="margin-top: 60px;margin-left: 40px">
    
    <h1>Carteira</h1>
    <u>Saldo: ${carteira.saldo}</u>
    
    <div style="margin-top: 60px;margin-left: 40px">
        Historico de trasancoes <s>em breve...</s>
    </div>
</div>

<%@include file="template/bottom.jsp" %>

<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script>
    window.history.pushState('Object', 'Title', "${contextPath}" + '/');
</script>
