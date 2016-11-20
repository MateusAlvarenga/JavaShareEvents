<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@include file="template/header.jsp" %>

<div class="ui vertical feature segment">            
    <form method="POST"  action="${contextPath}/cadastro" class="form-signin" style="min-width: 450px">
        <div class="form-group ${status.error ? 'has-error' : ''} form-out">
            <div class="form-in"> 
                <h2 class="form-signin-heading">Criar Conta</h2>

                <div class="ui large fluid input">
                    <input name="username" required="" type="text" path="username" class="form-control" placeholder="Nome de usuario" autofocus="true">
                    <errors path="username"></errors>
                </div>

                <br>

                <div class="ui large fluid input">
                    <input  name="pass" required="" type="password" path="password" class="form-control" placeholder="Senha">
                    <errors path="password"></errors>
                </div>

                <br>

                <div class="ui large fluid input">
                    <input name="pass-confirm" required="" type="password" path="passwordConfirm" class="form-control" placeholder="Confirmar Senha"></input>
                    <errors path="passwordConfirm"></errors>
                </div>

                <br>

                <button class="ui large primary button" type="submit">Cadastrar</button>

                <h4 class="text-center"><a href="${contextPath}/views/login.jsp">Possuo uma conta</a></h4>
            </div>
        </div>
    </form>
</div>   

<%@include file="template/bottom.jsp" %>
