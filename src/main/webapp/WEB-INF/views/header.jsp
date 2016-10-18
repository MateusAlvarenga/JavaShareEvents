<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
    <head>
        <!-- Standard Meta -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

        <!-- Site Properities -->
        <title>TAD Eventos</title>

        <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> 
        <link href="${contextPath}/resources/css/semantic.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/homepage.css" rel="stylesheet">
        <link href="${contextPath}/resources/iconfonts/flaticon.css" type="text/css" rel="stylesheet">
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
                        <a class="logo item">
                            TAD Eventos
                        </a>
                        <a href="${contextPath}/" class=" item">
                            <i  class="flaticon-home"></i>Home 
                        </a>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <a href="#" class="active ui item"><i class="write icon"></i>Publicar Novo Evento </a>
                                <a class="ui item">${pageContext.request.userPrincipal.name}  </a>
                         </c:if>

                        <div class="right menu">

                            <div class="item">
                                <div class="ui icon input">
                                    <input id="geocomplete" type="text" placeholder="Eventos na sua cidade" value="" />
                                    <i class="flaticon-position link icon"></i>
                                </div>
                            </div>
                            <c:if test="${pageContext.request.userPrincipal == null}">
                                <a href="${contextPath}/login" class="ui item">LogIn</a>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal != null}">
                                <a href="#" class="ui item" onclick="document.forms['logoutForm'].submit()">Logout</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>