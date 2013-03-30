package allshoes.web.model;

public class Header {
    
    private String headerPadrao = "";

    public Header(boolean logado, String pageTitle) {
        this.headerPadrao += "<html>";
        this.headerPadrao += "<head>";
        this.headerPadrao += "<title>All Shoes - "+ pageTitle +"</title>";
        this.headerPadrao += "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
        this.headerPadrao += "<link rel='stylesheet' href='/Enterprise_Application-war/css/styles.css'/>";
        this.headerPadrao += "<script type='text/javascript' src='/Enterprise_Application-war/js/jquery-1.8.2.min.js'></script>";
        this.headerPadrao += "<script type='text/javascript' src='/Enterprise_Application-war/js/custom.js'></script>";
        this.headerPadrao += "<script type='text/javascript' src='/Enterprise_Application-war/js/script.js'></script>";
        this.headerPadrao += "</head>";
        this.headerPadrao += "<body>";
        this.headerPadrao += "<div id='header'>";
        this.headerPadrao += "<div id='topo'>";
        this.headerPadrao += "<div id='topo-left'>";
        this.headerPadrao += "<a href='/Enterprise_Application-war/'>";
        this.headerPadrao += "<img class='logo' src='images/logo.jpg' alt='Logo All Shoes' />";
        this.headerPadrao += "</a>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "<div id='topo-right'>";
        this.headerPadrao += "<div id='links-topo'>";
        this.headerPadrao += "<div id='usuario'>";
        
        this.headerPadrao += "Bem-vindo, <a id='linkLogin' href='Login'>faça seu login ou cadastre-se</a>";
        
        this.headerPadrao += "</div>";
        this.headerPadrao += "<div id='links'>";
        this.headerPadrao += "<a href='MeusPedidos'>Meus Pedidos</a>";
        this.headerPadrao += "<a href='MeuCadastro'>Meu Cadastro</a>";
        this.headerPadrao += "<a href='Atendimento'>Atendimento</a>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "<div id='links-botoes'>";
        this.headerPadrao += "<div id='botoes'>";
        this.headerPadrao += "<form action='MeuCarrinho' method='post'>";
        this.headerPadrao += "<input type='submit' value='Meu Carrinho' />";
        this.headerPadrao += "</form>";
        this.headerPadrao += "<form action='ListaDeDesejos' method='post'>";
        this.headerPadrao += "<input type='submit' value='Lista de Desejos' />";
        this.headerPadrao += "</form>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "<div id='menuT'>";
        this.headerPadrao += "<ul>";
        this.headerPadrao += "<li><a href='Masculino'>Masculino</a></li>";
        this.headerPadrao += "<li><a href='Feminino'>Feminino</a></li>";
        this.headerPadrao += "<li><a href='Infantil'>Infantil</a></li>";
        this.headerPadrao += "<li><a href='Marcas'>Marcas</a></li>";
        this.headerPadrao += "</ul>";
        this.headerPadrao += "<form action='Busca' method='get'>";
        this.headerPadrao += "<input type='text' size='90' name='k' />";
        this.headerPadrao += "<input type='submit' value='Buscar' />";
        this.headerPadrao += "</form>";
        this.headerPadrao += "</div>";
        this.headerPadrao += "</div>";
    }

    public String getHeaderPadrao() {
        return headerPadrao;
    }
    
}
