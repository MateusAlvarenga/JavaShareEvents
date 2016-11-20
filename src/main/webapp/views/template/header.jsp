<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${sessionScope.username}"/>

<html>
    <head>
        <!-- Standard Meta -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <!-- Site Properities -->
        <title>TAD Eventos</title>
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet" />
        <link href="${contextPath}/resources/css/semantic.min.css" rel="stylesheet" />
        <link href="${contextPath}/resources/css/homepage.css" rel="stylesheet" />
        <link href="${contextPath}/resources/iconfonts/flaticon.css" type="text/css" rel="stylesheet" />
        <link  href="${contextPath}resources/css/credit.css" />
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js"></script>        
        <script src="${contextPath}/resources/js/semantic.min.js"></script>
        <script src="${contextPath}/resources/js/homepage.js"></script>
        
        <script src="//maps.googleapis.com/maps/api/js?libraries=places&amp;key=AIzaSyC9V7jv_0HCSU81VYsUwDBBFfnFkyTBsEs"></script>
        <script src="${contextPath}/resources/js/jquery.geocomplete.min.js"></script>
    </head>
    
    <body id="home">
        <div class="ui inverted masthead centered segment">
            <div class="ui page grid">
                <div class="column">

                    <div class="ui secondary pointing menu">
                        <a class="logo item" href="${contextPath}/">
                            TAD Eventos 
                        </a>

                        <span class="item">&nbsp;</span>    

                        <c:if test="${not empty user_name}">
                            <div class="ui dropdown item">
                                ${user_name} <i class="dropdown icon"></i>
                                <div class="menu">
                                    <a href="${contextPath}/eventos/publicar" class="ui item">
                                        <i class="write icon"></i>Publicar Novo Evento 
                                    </a>
                                    <a href="${contextPath}/busca/minhas-publicacoes" class="ui item">
                                        <i class="write icon"></i>Minhas Publicações
                                    </a>
                                    <a href="${contextPath}/busca/minhas-compras" class="ui item">
                                        <i class="write icon"></i>Minhas compras
                                    </a>
                                </div>
                            </div>
                        </c:if>

                        <div class="right menu">
                            <div class="item">
                                <div class="ui icon input">
                                    <form action="${contextPath}/busca/evento" method="GET" style="margin: 0">
                                        <input type="text" placeholder="Buscar eventos na sua cidade" name="cidade" style="min-width: 250px" />
                                    </form>
                                    
                                    <i class="link flaticon-position icon"></i>
                                </div>
                            </div>
                            <c:if test="${empty user_name}">
                                <a href="${contextPath}/views/login.jsp" class="ui item">Login</a>
                            </c:if>
                            <c:if test="${not empty user_name}">
                                <a href="${contextPath}/login" class="ui item">Logout</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>


