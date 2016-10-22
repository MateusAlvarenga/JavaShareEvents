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

                  <a href="${contextPath}/Detalhes/?idevento=${evento.idevento}">ver</a>
                </div>
            </div>

            <%--<c:out value="${evento}" />  --%>

        </c:forEach>

    </div>
</div>
<script src="${contextPath}/resources/js/publicarEvento.js"></script>
<%@include file="bottom.jsp" %>
