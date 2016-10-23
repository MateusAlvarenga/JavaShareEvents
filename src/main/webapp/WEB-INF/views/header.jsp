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
                        <a class="logo item">
                            TAD Eventos
                        </a>
                        <a href="${contextPath}/" class=" item">
                            <i  class="flaticon-home"></i>Home
                        </a>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <div class="ui dropdown item">
                                ${pageContext.request.userPrincipal.name} <i class="dropdown icon"></i>
                                <div class="menu">
                                    <a href="${contextPath}/PublicarEvento" class="ui item"><i class="write icon"></i>Publicar Novo Evento </a>
                                    <a href="${contextPath}/Eventos?coluna=anfitriao&valor=${pageContext.request.userPrincipal.name}" class="ui item">
                                        <i class="write icon"></i>Minhas Publicações
                                    </a>
                                </div>
                            </div>
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

        <form hidden="" >
            <fieldset>
                <h3>Address-Details</h3>

                <label>Name</label>
                <input name="name" type="text" value="">

                <label>POI Name</label>
                <input name="point_of_interest" type="text" value="">

                <label>Latitude</label>
                <input name="lat" type="text" value="">

                <label>Longitude</label>
                <input name="lng" type="text" value="">

                <label>Location</label>
                <input name="location" type="text" value="">

                <label>Location Type</label>
                <input name="location_type" type="text" value="">

                <label>Formatted Address</label>
                <input name="formatted_address" type="text" value="">

                <label>Bounds</label>
                <input name="bounds" type="text" value="">

                <label>Viewport</label>
                <input name="viewport" type="text" value="">

                <label>Route</label>
                <input name="route" type="text" value="">

                <label>Street Number</label>
                <input name="street_number" type="text" value="">

                <label>Postal Code</label>
                <input name="postal_code" type="text" value="">

                <label>Locality</label>
                <input name="locality" type="text" value="">

                <label>Sub Locality</label>
                <input name="sublocality" type="text" value="">

                <label>Country</label>
                <input name="country" type="text" value="">

                <label>Country Code</label>
                <input name="country_short" type="text" value="">

                <label>State</label>
                <input name="administrative_area_level_1" type="text" value="">

                <label>Place ID</label>
                <input name="place_id" type="text" value="">

                <label>ID</label>
                <input name="id" type="text" value="">

                <label>Reference</label>
                <input name="reference" type="text" value="">

                <label>URL</label>
                <input name="url" type="text" value="">

                <label>Website</label>
                <input name="website" type="text" value="">
            </fieldset>
        </form>

    
