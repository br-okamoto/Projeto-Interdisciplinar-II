<%-- 
    Document   : header
    Created on : 02/03/2013, 07:58:23
    Author     : Bruno
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
</head>
<body>

<div id="header">
    <div id="topo">
        <div id="topo-left">
            <a href="/">
                <img class="logo" src="/images/logo.png" alt="Logo All Shoes" />
            </a>
        </div>
        <div id="topo-right">
            <div id="links-topo">
                <div id="usuario">
                    Bem-vindo, <a href="Login">faça seu login ou cadastre-se</a>
                </div>
                <div id="links">
                    <a href="MeusPedidos">Meus Pedidos</a>
                    <a href="MeuCadastro">Meu Cadastro</a>
                    <a href="Atendimento">Atendimento</a>
                </div>
            </div>
            <div id="links-botoes">
                <div id="botoes">
                    <input type="button" onclick="MeuCarrinho" value="Meu Carrinho" />
                    <input type="button" onclick="ListaDeDesejos" value="Lista de Desejos" />
                </div>
            </div>
        </div>
    </div>
    
    <div id="menu">
        <ul>
            <li><a href="Masculino">Masculino</a></li>
            <li><a href="Feminino">Feminino</a></li>
            <li><a href="Infantil">Infantil</a></li>
            <li><a href="Marcas">Marcas</a></li>
        </ul>
        <form action="Buscar" method="get">
            <input type="text" size="90" name="txtBusca" />
            <input type="submit" value="Buscar" />
        </form>
    </div>
</div>

</body>
</html>
