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

<form id="logoutForm" method="GET" action="${contextPath}/LoginController">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

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

</html>
