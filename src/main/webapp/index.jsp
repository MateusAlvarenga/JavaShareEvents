<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<%@include file="views/template/header.jsp" %>

<script src="${contextPath}/resources/css/homepage.css"></script>

<div class="ui vertical feature segment">
    <div class="ui centered page grid">
        <div class="fourteen wide column">
            <div class="ui transition  ">

                <div class="ui centered lead header">Encontre aqui os melhores eventos!</div>

                <div class="ui centerted circular image">
                    <video id="banner_video" loop controls preload="auto">
                        <source src="http://d1gkntzr8mxq7s.cloudfront.net/sympla.mp4">
                        <img src="http://www.sympla.com.br/vids/sympla_loop_720p.jpg" alt="flamingo">
                    </video>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="views/template/bottom.jsp" %>

<script src="${contextPath}/resources/js/homepage.js"></script>
