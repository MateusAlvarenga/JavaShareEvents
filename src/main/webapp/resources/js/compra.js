 function UpdateValue(){
    var newvalue = Number($('#valor_unitario').val()) * Number($('#qtd').val());
    $('#valor-total').html(newvalue);
    $('.valor-total').val(newvalue);
 }
 
 $('#qtd').bind('keyup mouseup', function () {    
     UpdateValue();
});

UpdateValue();
$('#card_number').attr('required','');
$('#card_number').attr('min','11');
$('#digito_verificador').attr('required','');
$('#digito_verificador').attr('min','3');
$('#expiration').attr('required','');
 
$(".expiration").mask('99/9999');
$(".card-number").mask('9999 9999 9999 9999');

 //data-mask="##/####"
 //data-mask="#### #### #### ####"