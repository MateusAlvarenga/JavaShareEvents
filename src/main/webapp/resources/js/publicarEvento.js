$(function () {

    $("#geocomplete").geocomplete({
        country: 'br',
        map: ".map_canvas",
    }).bind("geocode:result", function (event, result) {
        result = result.address_components;
        console.log(result[3]);
        $('#cidade').val(result[1].long_name);
        $('#estado').val(result[2].long_name);
        $('#pais').val(result[3].long_name);
    });

    setTimeout(function () {

        $('#datafim').datetimepicker({format: 'Y/M/D H:m:s'});
        $('#datainicio').datetimepicker({format: 'Y/M/D H:m:s'});

        $("#datainicio").on("dp.change", function (e) {
            $('#datafim').data("DateTimePicker").minDate(e.date);
        });
        $("#datafim").on("dp.change", function (e) {
            $('#datainicio').data("DateTimePicker").maxDate(e.date);
        });



    }, 100);




});