<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    
    <form:form method="POST" modelAttribute="userForm" class="form-signin">
      
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''} form-out">
                <div class="form-in"> 
                      <h2 class="form-signin-heading">Criar Conta</h2>
                <form:input type="text" path="username" class="form-control" placeholder="Nome de usuario"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Senha"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirmar Senha"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
        
        <input type="checkbox" required />
        <label>Concordo com os termos de uso</label>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Pronto</button>
        <h4 class="text-center"><a href="${contextPath}/login">Possuo uma conta</a></h4>
             <h5 class="text-center"><a href="${contextPath}/">Home</a></h5>
             
            </div>
            </div>
    </form:form>
    
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
