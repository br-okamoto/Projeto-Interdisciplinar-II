package allshoes.web.model;

public class Footer {
    
    private String footerPadrao = "";

    public Footer(boolean logado) {
        this.footerPadrao += "<div id='footer'>";
        this.footerPadrao += "<div id='footer-topo'>";
        this.footerPadrao += "<div id='formasPagamento'>";
        this.footerPadrao += "<div>Formas de Pagamento</div>";
        this.footerPadrao += "<img src='images/visa-48px.png' alt='visa' />";
        this.footerPadrao += "<img src='images/mastercard-48px.png' alt='mastercard' />";
        this.footerPadrao += "<img src='images/amex-48px.png' alt='american express' />";
        this.footerPadrao += "<img src='images/hipercard-48px.png' alt='hipercard' />";
        this.footerPadrao += "<img src='images/pagseguro-48px.png' alt='pagseguro' />";
        this.footerPadrao += "<img src='images/paypal-48px.png' alt='paypal' />";
        this.footerPadrao += "<img src='images/boleto-48px.png' alt='boleto' />";
        this.footerPadrao += "</div>";
        this.footerPadrao += "<div id='redesSociais'>";
        this.footerPadrao += "<div>Redes Sociais</div>";
        this.footerPadrao += "<a href='http://www.facebook.com' target='_blank'><img src='images/facebook.png' alt='facebook' /></a>";
        this.footerPadrao += "<a href='http://www.twitter.com' target='_blank'><img src='images/twitter.png' alt='twitter' /></a>";
        this.footerPadrao += "<a href='http://www.youtube.com' target='_blank'><img src='images/youtube.png' alt='youtube' /></a>";
        this.footerPadrao += "</div>";
        this.footerPadrao += "</div>";
        this.footerPadrao += "<div id='footer-central'>";
        this.footerPadrao += "<h2>Central de Atendimento</h2>";
        this.footerPadrao += "(11) 4000-0000";
        this.footerPadrao += "</div>";
        this.footerPadrao += "<div id='footer-copyright'>Todos os direitos reservados.</div>";
        this.footerPadrao += "</div>";
        this.footerPadrao += "</body>";
        this.footerPadrao += "</html>";
    }

    public String getFooterPadrao() {
        return footerPadrao;
    }
    
}
