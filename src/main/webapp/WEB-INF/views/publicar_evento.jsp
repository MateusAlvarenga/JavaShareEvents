<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="GravarEvento" value="${contextPath}/GravarEvento" > </c:url>
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

        <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/latest/css/bootstrap.css" />

        <!-- Include Date Range Picker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

        <script>
            $(function () {

                $("#geocomplete").geocomplete({
                    country: 'br',
                    map: ".map_canvas",
                }).bind("geocode:result", function (event, result) {
                    result = result.address_components;
                    console.log(result[3]);
                    $('#cidade').val(result[1].long_name);
                    $('#estado').val(result[2].long_name);
                    $('#pais').val(result[3].long_name);
                });




            });
        </script>
        <style type="text/css" media="screen">
            .map_canvas { float: left;height: 500px;width: 800px }

        </style>
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

        <p></p> <div class="ui container">
            <form:form action="${GravarEvento}"  id="eventoform" method="post" modelAttribute="eventoForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="ui form">
                    <div class="field">
                        <form:label path="titulo">Titulo</form:label>
                        <form:input path="titulo" required="" placeholder="" id="titulo"   />
                    </div>
                
                <div class="field">
                    <form:label path="descricao">Descricao do Evento</form:label>
                    <form:textarea path="descricao" type="textarea" id="descicao" required="" ></form:textarea >
                    </div>
                    
                <div class="field">
                    <form:label path="count_entradas">Numero de ingressos</form:label>
                    <form:input path="count_entradas" type="number"  min="1" step="any" required="" />
                </div>
                <div class="field">
                    <form:label path="preco_entrada">Preco unitário do ingresso</form:label>
                    <form:input path="preco_entrada" type="number"  min="1" step="any" required="" />
                </div>
                 <form:input path="anfitriao" value="${pageContext.request.userPrincipal.name}" hidden="" />
                <div class="field">
                    <form:label path="datainicio">Inicio do evento</form:label>

                        <div class="container">
                            <div class="row">
                                <div class='col-sm-6'>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker1'>
                                        <form:input path="datainicio" id="datainicio" type="text" name="daterange"  />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                                               
                <div class="field">
                    <form:label path="datafim">Até</form:label>

                        <div class="container">
                            <div class="row">
                                <div class='col-sm-6'>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker1'>
                                        <form:input path="datafim" id="datafim" type="text" name="daterange"  />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <script type="text/javascript">
                                $(function () {//d/%m/%Y %H:%i:%s
                                    $('#datafim').datetimepicker({format: 'Y/M/D H:m:s'});
                                    $('#datainicio').datetimepicker({format: 'Y/M/D H:m:s'});

                                    $("#datainicio").on("dp.change", function (e) {
                                        $('#datafim').data("DateTimePicker").minDate(e.date);
                                    });
                                    $("#datafim").on("dp.change", function (e) {
                                        $('#datainicio').data("DateTimePicker").maxDate(e.date);
                                    });


                                });
                            </script>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <form:label path="endereco"> <i class="flaticon-position link icon"></i>Local</form:label>
                    <form:input path="endereco" id="geocomplete" name="geocomplete" type="text" placeholder="Local" value=""  required="" />
                </div>

                <span  hidden>
                    <label>Locality</label>
                    <form:input path="cidade"  id="cidade"  type="text" value="" required="" />      

                    <label>Country</label>
                    <form:input path="pais" id="pais" type="text" value="" /> 

                    <label>State</label>
                    <form:input path="estado" id="estado" name="administrative_area_level_1" type="text" value="" />
                </span>
            </div>
            <div class="field">
                <form:button  style="height: 50px;width: 135px;" type="submit" class="primary big ui  button">
                    Enviar
                </form:button >
            </div>
        </form:form >
        <div class="map_canvas"></div>
    </div>
    <br><br>
    <!-- Rodape-->
    <div class="ui vertical centered segment">
        <div class="ui stackable center aligned page grid">
            <div class="row">
                <div class="eight wide column">
                    <h1 class="ui header">
                        Our Clients
                    </h1><div class="ui horizontal divider"><i class="flaticon-settings icon"></i></div>
                    <p class="ui centered lead">
                        Many Companies Rely on Our Cat Knowledge
                    </p>
                    <br/>
                </div>
            </div>
            <div class="four column logo row">
                <div class="column">
                    <div class="ui shape">
                        <div class="sides">
                            <div class="active side">
                                <i class="huge flaticon-facebook icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-twitter icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-pinterest icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-more icon"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="column">
                    <div class="ui shape">
                        <div class="sides">
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-more icon"></i>
                            </div>
                            <div class="active side">
                                <i class="huge flaticon-twitter icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-facebook icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-twitter icon"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="column">
                    <div class="ui shape">
                        <div class="sides">
                            <div class="active side">
                                <i class="huge flaticon-facebook icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-twitter icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-pinterest icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-more icon"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="column">
                    <div class="ui shape">
                        <div class="sides">
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-more icon"></i>
                            </div>
                            <div class="active side">
                                <i class="huge flaticon-twitter icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-facebook icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-google icon"></i>
                            </div>
                            <div class="side">
                                <i class="huge flaticon-twitter icon"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="ui inverted footer vertical segment center">
        <div class="ui stackable center aligned page grid">
            <div class="four column row">

                <div class="column">
                    <h5 class="ui inverted header">Courses</h5>
                    <div class="ui inverted link list">
                        <a class="item">Registration</a>
                        <a class="item">Course Calendar</a>
                        <a class="item">Professors</a>
                    </div>
                </div>
                <div class="column">
                    <h5 class="ui inverted header">Library</h5>
                    <div class="ui inverted link list">
                        <a class="item">A-Z</a>
                        <a class="item">Most Popular</a>
                        <a class="item">Recently Changed</a>
                    </div>
                </div>
                <div class="column">
                    <h5 class="ui inverted header">Community</h5>
                    <div class="ui inverted link list">
                        <a class="item">BBS</a>
                        <a class="item">Careers</a>
                        <a class="item">Privacy Policy</a>
                    </div>
                </div>

                <div class="column">
                    <h5 class="ui inverted header"> </h5>
                    <addr>
                    </addr>
                </div>
            </div>
        </div>
    </div>
</body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</html>
