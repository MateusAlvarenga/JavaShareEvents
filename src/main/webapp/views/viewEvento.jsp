
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="random" class="com.iftm.util.RandomBean" scope="application" />
<%--
<c:url var="GravarEvento" value="${contextPath}/GravarEvento" > </c:url>

--%>
<script>
    window.history.pushState('Object', 'Title', "${contextPath}" + '/BuscaController?action=busca');
</script>
<%@include file="template/header.jsp" %>
<br><br><br><br>
<div class="container" style="margin-left: 30px">


    <div class="ui sizer vertical segment">
        <div class="ui huge header">  <c:out value="${ObjEvento.titulo}" /></div>

        <div class="ui two top attached buttons">
            <div class="ui grid">

                <div class="four wide column"> <a href="${contextPath}/BuscaController?action=compra&idevento=${ObjEvento.idevento}"> <div class="massive ui button primary">Comprar Ingresso</div></a></div>
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
    
        
    <div class="ui relaxed divided list">
        Veja quem confirmou Presença
        <c:forEach items="${presentes}" var="presente">
        <div class="item">
            <img src="https://randomuser.me/api/portraits/lego/${random.nextInt}.jpg" style="height: 40px;" />
            <div class="content">
                <a class="header"><c:out value="${presente.username}" /> </a>
                <div class="description">Updated ...</div>
            </div>
        </div>       
        </c:forEach>
    </div>


    <%--<c:out value="${ObjEvento}" /> --%>
</div>

<%@include file="template/bottom.jsp" %>
