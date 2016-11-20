<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@include file="template/header.jsp" %>

<div class="ui vertical feature segment">
    <form method="POST" action="${contextPath}/login" class="form-signin" style="min-width: 450px"> 
        <div class="form-group ${error != null ? 'has-error' : ''} form-out">            
            <div class="form-in">
                <h2 class="form-heading">Log in</h2>

                <span>${message}</span>

                <div class="ui large fluid input">
                    <input name="username" type="text" class="form-control" placeholder="Nome de usuario" autofocus="true"/>
                </div>

                <br>
                
                <div class="ui large fluid input">
                    <input name="password" type="password" class="form-control" placeholder="Senha"/>
                </div>

                <span>${error}</span>

                <br>
                
                <button class="large primary ui button" type="submit">Log In</button>
                
                <h4 class="text-center"><a href="${contextPath}/views/cadastro.jsp">Criar uma nova conta</a></h4>
            </div>
        </div>
    </form>
</div>

<%@include file="template/bottom.jsp" %>

