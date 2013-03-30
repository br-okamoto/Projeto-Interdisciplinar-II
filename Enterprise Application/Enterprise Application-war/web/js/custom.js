function mostrarFormaPgtoEscolhida(formapagamento) {
    $('.divFormaPgto').hide();
    $('#'+formapagamento).show();
    
}
$(document).ready(function(){
    var currentURL = window.location.href;
    $("#linkLogin").attr("href","Login?returnURL="+currentURL);
});