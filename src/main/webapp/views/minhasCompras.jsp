<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<jsp:useBean id="random" class="com.iftm.util.RandomBean" scope="application" />
<%@include file="template/header.jsp" %>

<div style="margin-top: 60px;margin-left: 40px">
<c:forEach items="${compras}" var="compra">
    <div class="item">
        <img src="https://randomuser.me/api/portraits/lego/${random.nextInt}.jpg" style="height: 40px;" />
        <div class="content">
            <a class="header"><c:out value="${compra}" /> </a>
            <div class="description"><a href="${contextPath}/BuscaController?action=confirmacao&idevento=${compra.evento_idevento}&qtd=${compra.qtd}" >quero meu convite</a></div>
        </div>
    </div>    
</c:forEach>
</div>


<%@include file="template/bottom.jsp" %>

<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script>
    window.history.pushState('Object', 'Title', "${contextPath}" + '/');
</script>
