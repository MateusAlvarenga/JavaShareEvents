 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
<c:url var="GravarEvento" value="${contextPath}/GravarEvento" > </c:url>

--%>

<%@include file="/views/template/header.jsp" %>

<br><br><br><br>

<div class="container" style="margin-left: 30px">
    <div class="ui cards">
        <c:forEach items="${filteredEventList}" var="evento">

            <div class="ui link card ">
                <div class="card">
                    <div class="image">
                        <img src="https://unsplash.it/290/200/?random&n=${evento.idevento}">
                    </div>
                    <div class="content">
                        <div class="header"><n><c:out value="${evento.titulo}" /></n></div>
                        <div class="meta">
                            <a>  <c:out value="by ${evento.anfitriao}" /></a>
                        </div>
                        <div class="description content">
                          <span class="right ">
                            <c:out value="${evento.endereco}" />
                          </span>
                        </div>
                    </div>
                    <div class="extra content">

                        <span class="">
                            <c:out value="${evento.datainicio} - ${evento.datafim}" />
                        </span>
                        <span>

                        </span>
                    </div>
                </div>
                <div class="ui bottom attached button primary">

                  <a href="${contextPath}/BuscaController?action=detalhes&idevento=${evento.idevento}" >ver</a>
                </div>
            </div>

            <%--<c:out value="${evento}" />  --%>

        </c:forEach>

    </div>
</div>
<script src="${contextPath}/resources/js/publicarEvento.js"></script>
<%@include file="/views/template/bottom.jsp" %>
