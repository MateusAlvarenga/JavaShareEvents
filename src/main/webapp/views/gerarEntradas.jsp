<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@include file="template/header.jsp" %>

<br><br><br><br>

<div class="container" style="margin-left: 30px; margin-right: 50px">
    <h2>Pronto, voce pode gerar seus ingressos agora:</h2>
    <button id="generate" class="massive ui button primary ">Gerar Ingresso</button>
</div>

<script src="${contextPath}/resources/js/FileSaver.min.js"></script>
<script src="${contextPath}/resources/js/jspdf.js"></script>
<script>
    //alert('sdfasd');
    $('#generate').click(function () {
        var doc = new jsPDF();
        var cont;
        doc.text(20, 20, 'TADEVENTOS');
        
        for (cont = 0; cont < ${qtd}; cont++) {
            doc.addPage('a5', 'l');
            doc.setFontSize(32);
            doc.text(20, 20, 'TADEVENTOS');
            doc.setFontSize(16);
            var zerofilled = ('0000' +${evento.idevento}).slice(-4);
            doc.text(20, 30, "Convite evento " + zerofilled);
            doc.text(20, 40, "${evento.titulo}");
            doc.text(20, 50, "${evento.cidade}");
            doc.text(20, 60, "${evento.estado}");
            doc.text(20, 70, "${evento}");
        }

        doc.save("${evento.titulo}");
    });
    
    window.history.pushState('Object', 'Title', "${contextPath}" + '/BuscaController?action=efetivar_compra');
</script>

<%@include file="template/bottom.jsp" %>
