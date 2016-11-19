<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@include file="/views/template/header.jsp" %>

<br><br><br><br>

<div class="container" style="margin-left: 30px">
    <div class="ui cards" style="margin-left: 0; margin-right: 0">
        <c:forEach items="${filteredEventList}" var="evento">
            <div class="ui card ">
                <div class="card">
                    <div class="content" style="padding: 15px">
                        <div class="header">
                            <c:out value="${evento.titulo}" />
                        </div>
                        <div class="meta">
                            <a>  <c:out value="by ${evento.anfitriao}" /></a>
                        </div>
                        <div class="description content">
                            <span class="right ">
                                <c:out value="${evento.endereco}" />
                            </span>
                        </div>
                    </div>
                    <div class="extra content" style="padding: 15px">
                        <p class="">
                            <c:out value="${evento.datainicio} - ${evento.datafim}" />
                        </p>
                    </div>
                </div>

                <a href="${contextPath}/BuscaController?action=detalhes&idevento=${evento.idevento}" >
                    <div class="ui link bottom attached button primary">
                        Ver
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>

<script src="${contextPath}/resources/js/publicarEvento.js"></script>

<%@include file="/views/template/bottom.jsp" %>
