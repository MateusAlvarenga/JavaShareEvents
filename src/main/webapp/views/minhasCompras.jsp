<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user_name" value="${requestScope['user'].username}"/>

<%@include file="template/header.jsp" %>

<div style="margin-top: 60px; margin-left: 40px">
    <div class="ui cards" style="margin-left: 0; margin-right: 0">
        <c:forEach items="${compras}" var="compra">
            <div class="ui card ">
                <div class="card">
                    <div class="content" style="padding: 15px">
                        <div class="header">
                            <p><c:out value="${compra.evento.titulo}" /></p>
                        </div>
                        <div class="meta">
                            <a><p><c:out value="por ${compra.evento.anfitriao.username}" /></p></a>
                        </div>
                        <div class="description content">
                            <span class="right ">
                                <p><c:out value="${compra.evento.endereco}" /></p>
                                <p><c:out value="${compra.evento.dataInicio} - ${compra.evento.dataFim}" /></p>
                            </span>
                        </div>
                    </div>
                    <div class="extra content" style="padding: 0 15px 15px;">
                        <p>Quantidade: <c:out value="${compra.quantidade}" /></p>
                        <p>Total: <c:out value="${compra.total}" /></p>
                    </div>
                </div>

                <a href="${contextPath}/busca/detalhes?idevento=${compra.evento.id}" >
                    <div class="ui link bottom attached button primary">
                        Ver
                    </div>
                </a>
            </div>   
        </c:forEach>
    </div>
</div>

<%@include file="template/bottom.jsp" %>
