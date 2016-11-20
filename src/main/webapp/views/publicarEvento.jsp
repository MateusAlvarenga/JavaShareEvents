<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/latest/css/bootstrap.css" />
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet" />
        <link href="${contextPath}/resources/css/semantic.min.css" rel="stylesheet" />
        <link href="${contextPath}/resources/css/homepage.css" rel="stylesheet" />
        <link href="${contextPath}/resources/iconfonts/flaticon.css" type="text/css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css"  type="text/css" rel="stylesheet" />
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js"></script>
        <script src="${contextPath}/resources/js/semantic.min.js"></script>
        <script src="${contextPath}/resources/js/homepage.js"></script>
        <script src="//maps.googleapis.com/maps/api/js?libraries=places&amp;key=AIzaSyC9V7jv_0HCSU81VYsUwDBBFfnFkyTBsEs"></script>
        <script src="${contextPath}/resources/js/jquery.geocomplete.min.js"></script>

        <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>

        <!-- Include Date Range Picker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>


        <style type="text/css" media="screen">
            .map_canvas { float: left;height: 500px;width: 100% }
        </style>
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

        <br><br>

        <div class="ui container">
            <form action="/TadEventosS/eventos/publicar"  id="eventoform" method="post" modelAttribute="eventoForm">
                <div class="ui form">
                    <div class="field">
                        <label path="titulo">Titulo</label>
                        <input path="titulo" name="titulo" required="" placeholder="" id="titulo"   />
                    </div>

                    <div class="field">
                        <label path="descricao">Descricao do Evento</label>
                        <textarea name="descricao" path="descricao" type="textarea" id="descicao" required="" ></textarea >
                    </div>

                    <div class="field">
                        <label path="preco_entrada" required="">Preco unitário do ingresso</label>
                        <input name="preco_entrada" path="preco_entrada" type="number"  min="1" step="any" required="" />
                    </div>

                    <div class="two fields">
                        <div class="field">
                            <label path="datainicio">Inicio do evento</label>

                            <div class="container">
                                <div class="row">
                                    <div class='col-sm-6'>
                                        <div class="form-group">
                                            <div class='input-group date' id='datetimepicker1'>
                                                <input path="datainicio" name="datainicio" id="datainicio" type="text" name="daterange" required="" />
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
                            <label path="datafim">Fim do evento</label>

                            <div class="container">
                                <div class="row">
                                    <div class='col-sm-6'>
                                        <div class="form-group">
                                            <div class='input-group date' id='datetimepicker1'>
                                                <input path="datafim" name="datafim" id="datafim" type="text" name="daterange" required="" />
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="field">
                        <label path="endereco"> <i class="flaticon-position link icon"></i>Local</label>
                        <input name="endereco"  id="geocomplete" name="geocomplete" type="text" placeholder="Local" value=""  required="" />
                    </div>
                </div>

                <br><br>
                
                <div class="field">
                    <button  style="height: 50px;width: 135px;" type="submit" class="primary big ui  button">
                        Enviar
                    </button >
                </div>
            </form >
            <div class="map_canvas"></div>
        </div>

        <br><br>

        <!-- Rodape-->
        <div class="ui vertical segment">
            <div class="ui stackable center aligned page grid">
                <div class="row">
                    <div class="eight wide column">
                        <h4 class="ui header">
                            TADeventos
                        </h4>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script type="text/javascript">
        function SubmeterEBuscar() {
            var campo = "cidade";
            var valor = $('input[name=locality]').val();

            if (valor == "") {

                campo = "estado";
                valor = $('input[name=administrative_area_level_1]').val();

                if (valor == "") {
                    campo = "Pais";
                    valor = $('input[name=country]').val();
                }


                if (valor == "")
                    return;

            }
            //  console.log(valor);
            window.location.href = "${contextPath}/BuscaController?action=busca&coluna=" + campo + "&valor=" + valor;
        }

        $("#geocomplete").geocomplete({
            country: 'br',
            details: "form",
        });

        $("#geocomplete").on('keyup', function (e) {

            if (e.keyCode == 13) {

                SubmeterEBuscar();
            }
        });
    </script>
</body>

<script type="text/javascript">
    $(function () {//d/%m/%Y %H:%i:%s

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

        $('#datafim').datetimepicker({format: 'DD/MM/YYYY'});
        $('#datainicio').datetimepicker({format: 'DD/MM/YYYY'});

        $("#datainicio").on("dp.change", function (e) {
            $('#datafim').data("DateTimePicker").minDate(e.date);
        });
        $("#datafim").on("dp.change", function (e) {
            $('#datainicio').data("DateTimePicker").maxDate(e.date);
        });

        $('textarea:eq(0)').attr('required', '');
        $('input:eq(1)').attr('required', '');
        $('input:eq(3)').attr('required', '');
        $('input:eq(5)').attr('required', '');
        $('input:eq(6)').attr('required', '');
        $('#geocomplete').attr('required', '');

    });
</script>

</html>
