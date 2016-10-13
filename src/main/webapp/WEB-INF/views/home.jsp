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


        <script>
            $(function () {

                document.getElementById('banner_video').play();

                $('.ui.card').popup();

                $("#geocomplete").geocomplete({
                    country: 'br',
                    details: "form",
                });

            });
        </script>


        <style>
            video::-webkit-media-controls {
                display: none;
            }
        </style>
    </head>

    <form hidden >


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



    <body id="home">
        <div class="ui inverted masthead centered segment">
            <div class="ui page grid">
                <div class="column">



                    <div class="ui secondary pointing menu">
                        <a class="logo item">
                            TAD Eventos
                        </a>
                        <a class="active item">
                            <i href="" class="flaticon-home"></i> Home
                        </a>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <a href="${contextPath}/PublicarEvento" class="ui item"><i class="write icon"></i>Publicar Novo Evento </a>
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


                    <div class="ui hidden transition information">

                        <p class="ui centered lead">Encontre os melhores eventos! 
                        </p>
                        <c:if test="${pageContext.request.userPrincipal == null}">
                        <a href="#" class="large basic inverted animated fade ui button">
                            <div class="visible content">Come to TADeventos</div>                            
                            <div class="hidden content" onclick="window.location.href='/registration'"  >Criar uma nova conta</div>                            
                         </a>
                          </c:if>
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
        <div class="ui vertical feature segment">
            <div class="ui centered page grid">
                <div class="fourteen wide column">
                    <div class="ui three column center aligned stackable divided grid">
                        <div class="column column-feature">
                            <div class="ui icon header">
                                <i class="flaticon-connecting icon"></i>
                                Courses
                            </div>
                            <p>Take your kitty to a cat-ducation course and learn how to treat her well.</p>
                            <p>
                                <a class="ui button" href="#">
                                    Learn
                                </a>
                            </p>
                        </div>
                        <div class="column column-feature">
                            <div class="ui icon header">
                                <i class="flaticon-calendar icon"></i>
                                Library
                            </div>
                            <p>Dig through our cat library to found out amazing things you can do with your kitty.</p>
                            <p>
                                <a class="ui green right labeled icon button" href="#">
                                    Research
                                    <i class="right flaticon-move icon"></i>
                                </a>
                            </p>
                        </div>
                        <div class="column column-feature">
                            <div class="ui icon header">
                                <i class="flaticon-speech icon"></i>
                                Community
                            </div>
                            <p>Get feedback on your cat from a community of loving pet owners on our online...</p>
                            <p>
                                <a class="ui button" href="#">
                                    Share
                                </a>
                            </p>
                        </div>
                    </div>



                </div>
            </div>

            <div class="ui centered page grid">
                <h3 class="subscribe-header">Subscribe to Mailing List</h3> 
                <p class="ui centered lead large">At least he won't reach his highest potential unless you enroll him in Cat University's 2013 class.</p>
                <div class="ui form eight wide subscribe column">

                    <div class="field">

                        <div class="ui fluid action input">
                            <input placeholder="Susbcribe..." type="text">
                            <div class="ui button">Susbcribe</div>
                        </div>
                    </div>

                </div>

            </div>       

        </div>



        <div class="ui recent-works vertical segment">
            <div class="ui very relaxed stackable centered page grid">
                <div class="row">
                    <div class="eight wide centered column">
                        <h1 class="center aligned ui inverted header">
                            Recent Works
                        </h1>
                        <div class="ui horizontal divider"><i class="white flaticon-camera icon"></i></div>
                        <p class="ui centered lead">Checkout Our Recently Completed Works<br>you will be amazed!.</p>
                    </div>
                </div>
                <div class="fourteen wide column">
                    <div class="ui three column aligned stackable divided grid">



                        <div class="column">

                            <div class="ui card" data-html="<div class='header'>User Rating</div><div class='content'><div class='ui star rating'><i class='active icon'></i><i class='active icon'></i><i class='active icon'></i><i class='icon'></i><i class='icon'></i></div></div>">
                                <div class="image">
                                    <img src="images/totoro-horizontal.jpg">
                                </div>
                                <div class="content">
                                    <div class="header">My Neighbor Totoro</div>
                                    <div class="description">
                                        Two sisters move to the country with their father in order to be closer to their hospitalized mother, and discover the surrounding trees are inhabited by magical spirits.
                                    </div>
                                </div>
                                <div class="ui two bottom attached buttons">
                                    <div class="ui button">
                                        <i class="flaticon-plus icon"></i>
                                        Queue
                                    </div>
                                    <div class="ui pink button">
                                        <i class="flaticon-play icon"></i>
                                        Watch
                                    </div>
                                </div>
                            </div>

                        </div>



                        <div class="column">

                            <div class="ui card" data-html="<div class='header'>User Rating</div><div class='content'><div class='ui star rating'><i class='active icon'></i><i class='active icon'></i><i class='active icon'></i><i class='icon'></i><i class='icon'></i></div></div>">
                                <div class="image">
                                    <img src="images/totoro-horizontal.jpg">
                                </div>
                                <div class="content">
                                    <div class="header">My Neighbor Totoro</div>
                                    <div class="description">
                                        Two sisters move to the country with their father in order to be closer to their hospitalized mother, and discover the surrounding trees are inhabited by magical spirits.
                                    </div>
                                </div>
                                <div class="ui two bottom attached buttons">
                                    <div class="ui button">
                                        <i class="flaticon-plus icon"></i>
                                        Queue
                                    </div>
                                    <div class="ui pink button">
                                        <i class="flaticon-play icon"></i>
                                        Watch
                                    </div>
                                </div>
                            </div>

                        </div>


                        <div class="column">

                            <div class="ui card" data-html="<div class='header'>User Rating</div><div class='content'><div class='ui star rating'><i class='active icon'></i><i class='active icon'></i><i class='active icon'></i><i class='icon'></i><i class='icon'></i></div></div>">
                                <div class="image">
                                    <img src="images/totoro-horizontal.jpg">
                                </div>
                                <div class="content">
                                    <div class="header">My Neighbor Totoro</div>
                                    <div class="description">
                                        Two sisters move to the country with their father in order to be closer to their hospitalized mother, and discover the surrounding trees are inhabited by magical spirits.
                                    </div>
                                </div>
                                <div class="ui two bottom attached buttons">
                                    <div class="ui button">
                                        <i class="flaticon-plus icon"></i>
                                        Queue
                                    </div>
                                    <div class="ui pink button">
                                        <i class="flaticon-play icon"></i>
                                        Watch
                                    </div>
                                </div>
                            </div>

                        </div>




                    </div>
                </div>
            </div>
        </div>

<!-- Rodape-->
        <div class="ui vertical segment">
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

