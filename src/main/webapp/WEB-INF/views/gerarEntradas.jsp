<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
<c:url var="GravarEvento" value="${contextPath}/GravarEvento" > </c:url>

--%>

<%@include file="header.jsp" %>
<br><br><br><br>
<div class="container" style="margin-left: 30px; margin-right: 50px">

 <h2>Pronto, voce pode gerar seus ingressos agora:</h2>
  <button id="generate" class="massive ui button primary ">Gerar Ingresso</button>


</div>


<script src="${contextPath}resources/js/FileSaver.min.js"></script>
<script src="${contextPath}resources/js/jspdf.js"></script>
<script>
  alert('sdfasd');
  $('#generate').click(function (){

    var doc = new jsPDF();
    var cont;
    doc.text(20, 20, 'TADEVENTOS');
    for(cont = 0; cont < ${qtd}; cont++){
       doc.addPage('a5','l');
       doc.setFontSize(32);
       doc.text(20, 20, 'TADEVENTOS');
       doc.setFontSize(16);
      doc.text(20, 30, "Convite codigo: ${evento.idevento}");
       doc.text(20,40,"${evento}");
    }

     doc.save();

  });
  </script>
<%@include file="bottom.jsp" %>
