<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@include file="template/header.jsp" %>

<div class="container" style="margin-left: 30px; margin-right: 30px">
    <div class="ui sizer vertical segment">
        <div class="ui huge header">  
            <c:out value="${ObjEvento.titulo}" />
        </div>

        <a href="${contextPath}/BuscaController?action=compra&idevento=${ObjEvento.idevento}"> 
            <div class="massive ui button primary">Comprar Ingresso</div>
        </a> 

        <div class="ui segment">
            <p>Endereço: <c:out value="${ObjEvento.endereco}" /></p>
            <p>Descição: <c:out value="${ObjEvento.descricao}" /></p>
            <p>Anfitrião: <c:out value="${ObjEvento.anfitriao}" /></p>
            <p>Data: <c:out value="${ObjEvento.datainicio}" /> - <c:out value="${ObjEvento.datafim}" /></p>
            <p>Preço: R$ <c:out value="${ObjEvento.preco_entrada}" /></p>
        </div>

        <div class="ui divider"></div>
    </div>
</div>

<%@include file="template/bottom.jsp" %>
