
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Criar uma conta</title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    </head>

    <body>

        <div class="container ">

            <form method="POST"  action="${contextPath}/RegistrationController" class="form-signin">


                <div class="form-group ${status.error ? 'has-error' : ''} form-out">
                    <div class="form-in"> 
                        <h2 class="form-signin-heading">Criar Conta</h2>
                        <input name="username" required="" type="text" path="username" class="form-control" placeholder="Nome de usuario"
                               autofocus="true"></input>
                        <errors path="username"></errors>
                        <input  name="pass" required="" type="password" path="password" class="form-control" placeholder="Senha"></input>
                        <errors path="password"></errors>
                        <input name="pass-confirm" required="" type="password" path="passwordConfirm" class="form-control"
                               placeholder="Confirmar Senha"></input>
                        <errors path="passwordConfirm"></errors>
                        <input type="checkbox" required="" />
                        <label>Concordo com os termos de uso</label>

                        <button class="btn btn-lg btn-primary btn-block" type="submit">Pronto</button>
                        <h4 class="text-center"><a href="${contextPath}/views/login.jsp">Possuo uma conta</a></h4>
                        <h5 class="text-center"><a href="${contextPath}/">Home</a></h5>
                    </div>
                </div>
            </form>
        </div>
        <!-- /container -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
