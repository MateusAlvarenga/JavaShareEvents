
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<%@include file="views/template/header.jsp" %>
<script src="${contextPath}/resources/css/homepage.css"></script>
<div class="ui vertical feature segment">
    <div class="ui centered page grid">
        <div class="fourteen wide column">
            <div class="ui transition  ">

                <div class="ui centered lead header">Encontre aqui os melhores eventos!
                    <c:if test="${user_name} == null">
                        <span >
                            <a  href="#" class=" basic inverted animated fade ui button tblack">
                                <div class="visible content tblack">Come to TADeventos</div>
                                <div class="hidden content tblack" onclick="window.location.href = '/registration'"  >Criar uma nova conta</div>
                            </a>
                        </span>
                    </c:if>
                </div>

                <div class="ui centerted circular image">
                    <video id="banner_video" loop controls preload="auto">
                        <source src="http://d1gkntzr8mxq7s.cloudfront.net/sympla.mp4">
                        <img src="http://www.sympla.com.br/vids/sympla_loop_720p.jpg" alt="flamingo">
                    </video>
                </div>
            </div>
        </div>
    </div>

    <%@include file="views/template/bottom.jsp" %>

    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

  
    <script src="${contextPath}/resources/js/homepage.js"></script>
    <script>
        window.history.pushState('Object', 'Title', "${contextPath}" + '/');
    </script>
