
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>
 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
<c:url var="GravarEvento" value="${contextPath}/GravarEvento" > </c:url>

--%>
    <script>
        window.history.pushState('Object', 'Title', "${contextPath}" + '/BuscaController?action=compra');  
    </script>
<%@include file="template/header.jsp" %>
<br><br><br><br>
<div class="container" style="margin-left: 30px; margin-right: 50px">
    <form class="ui form" method="GET" action="${contextPath}/BuscaController?action=efetivar_compra" ><%-- action="${contextPath}/EfetivarCompra" --%>
        <input type="hidden" name="action" value="efetivar_compra" />
        <div class="fields two">
            <div class="ui field big icon input">
                <label>Qtd.</label>
                <input id="qtd" value="1" name="qtd" type="number" min="1" />
                <input id="valor_unitario" value="${ObjEvento.preco_entrada}" hidden=""  name="preco_entrada"  />
                <input class="valor-total" name="valor_total"  hidden=""  />
            </div>
            <div class="field">
                <span>R$</span>
                <span id="valor-total" >0,00 </span>
            </div>
        </div>
        <div class="fields two" hidden="">
            <div class="field">
                <input type="text" name="idevento" value="${ObjEvento.idevento}">
                 <input type="text" name="user" value="${user_name}">
            </div>
        </div>
        <h4 class="ui dividing header">Dados Bancarios</h4>
        <div class="field">
            <label>Card Type</label>
             
            <select class="ui dropdown"  id="card_type" name="card_type">
                <option value="Visa">Visa</option>
                <option value="Amex">American Express</option>
                <option value="MasterCard">MasterCard</option>
            </select>
        </div>
        <div class="fields">
            <div class="seven wide field">
                <label>Card Number</label>
                <input type="text" id="card_number" class="card-number"  name="card_number" maxlength="16" placeholder="Card #">
            </div>
            <div class="three wide field">
                <label>CVC</label>
                <input type="text" id="digito_verificador"  name="digito_verificador"  maxlength="3" placeholder="CVC">
            </div>
            <div class="six wide field">
                <label>Expiration</label>
                <div class=" field">                    
                    <input type="text" name="expiration" id="expiration" class="expiration"  placeholder="Expiration"  />                    
                </div>
            </div>

        </div>
        <button type="submit" class="positive ui button">Comprar</button>
        <button type="button" class="cancel ui button"><a href="${contextPath}/">Cancelar</button>
    </form>
</div>

<script src="${contextPath}/resources/js/jquery.maskedinput.min.js"></script>
<script src="${contextPath}/resources/js/jspdf.js"></script>
<script src="${contextPath}/resources/js/compra.js"></script>
<span> <c:out value="${ObjEvento}" /></span>
<%@include file="template/bottom.jsp" %>
