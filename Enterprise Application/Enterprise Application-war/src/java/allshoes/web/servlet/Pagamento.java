/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.facade.CartBeanRemote;
import allshoes.jpa.Cliente;
import allshoes.jpa.Endereco;
import allshoes.jpa.Estado;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.StatusDoPedido;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
public class Pagamento extends HttpServlet {
    private static final String STATEFUL_BEAN_KEY = "STATEFUL_BEAN_KEY";

    @EJB(mappedName = "ejb/ClienteFacade")
    private ClienteFacadeRemote ejb;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Header header = new Header(false, "Pagamento");
        Footer footer = new Footer(false);
        
        String username = null;
        HttpSession session = request.getSession();
        try {
           username = session.getAttribute("username").toString();
        }
        catch (NullPointerException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/Pagamento");
            rd.forward(request, response);
        }
        
        Cliente cliente = ejb.find(username);
        Endereco enderecoPedido;
        
        if (request.getParameter("rdEndereco").toString().equals("enderecoCadastrado")) {
            enderecoPedido = cliente.getEndereco();
        } else {
            Endereco novoEndereco = new Endereco();
            novoEndereco.setRua(request.getParameter("txtRua"));
            novoEndereco.setNumero(request.getParameter("txtNumero"));
            novoEndereco.setComplemento(request.getParameter("txtComplemento"));
            novoEndereco.setCep(request.getParameter("txtCEP"));
            novoEndereco.setBairro(request.getParameter("txtBairro"));
            novoEndereco.setCidade(request.getParameter("txtCidade"));
            novoEndereco.setEstado(Estado.valueOf(request.getParameter("ddlEstado")));
            enderecoPedido = novoEndereco;
        }
        
        CartBeanRemote carrinho = getCartBean(request);
        double total = 0;
        ArrayList<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
        itens = (ArrayList<ItemDoPedido>)carrinho.getItems();
        for (ItemDoPedido i : itens) {
            total += i.getSubTotal();
        }
        
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(new java.util.Date());
        pedido.setEndereco(enderecoPedido);
        pedido.setStatus(StatusDoPedido.Aberto);
        
        session.setAttribute("pedido", pedido);
        session.setAttribute("itensDoPedido",itens);
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Pagamento</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("<a href='" + request.getContextPath() + "/MeuCarrinho'>Meu Carrinho</a>");
            out.println(" > ");
            out.println("Pagamento");
            out.println("</div>");
            
            out.println("<h2>Escolha a forma de pagamento:</h2>");
            out.println("<img src='images/visa-48px.png' alt='visa' class='formaPgto' onclick=\"mostrarFormaPgtoEscolhida('visa');\" />");
            
            out.println("<div class='divFormaPgto' id='visa'>");
            out.println("<h2>VISA</h2>");
            out.println("<form action='RealizarPagamento' method='post'>");
            out.println("<input type='hidden' value='visa' />");
            out.println("<div class='ckbsPgto'>");
            out.println("<input type='radio' name='ckbParcelas' value='1' >1 x R$ "+total+"</input><br/>");
            out.println("<input type='radio' name='ckbParcelas' value='2' >2 x R$ "+(total/2)+"</input><br/>");
            out.println("<input type='radio' name='ckbParcelas' value='3' >3 x R$ "+(total/3)+"</input><br/>");
            out.println("<input type='radio' name='ckbParcelas' value='4' >4 x R$ "+(total/4)+"</input><br/>");
            out.println("<input type='radio' name='ckbParcelas' value='5' >5 x R$ "+(total/5)+"</input><br/>");
            out.println("<input type='radio' name='ckbParcelas' value='6' >6 x R$ "+(total/6)+"</input>");
            out.println("</div>");
            out.println("<div class='dadosPgto'>");
            out.println("<table border='0' cellpadding='3' cellspacing='3'>");
            out.println("<tr>");
            out.println("<td>Número do Cartão</td>");
            out.println("<td>Código de Segurança</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='text' name='txtNumCartao' /></td>");
            out.println("<td><input type='text' name='txtCodSeguranca' size='1'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nome do Titular</td>");
            out.println("<td>Validade</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='text' name='txtNomeTitular' size='40' /></td>");
            out.println("<td>");
            out.println("<select name='drpdownValidadeMes'>");
            out.println("<option value='01'>01</option>");
            out.println("<option value='02'>02</option>");
            out.println("<option value='03'>03</option>");
            out.println("<option value='04'>04</option>");
            out.println("<option value='05'>05</option>");
            out.println("<option value='06'>06</option>");
            out.println("<option value='07'>07</option>");
            out.println("<option value='08'>08</option>");
            out.println("<option value='09'>09</option>");
            out.println("<option value='10'>10</option>");
            out.println("<option value='11'>11</option>");
            out.println("<option value='12'>12</option>");
            out.println("</select>");
            out.println("<select name='drpdownValidadeAno'>");
            out.println("<option value='2013'>2013</option>");
            out.println("<option value='2014'>2014</option>");
            out.println("<option value='2015'>2015</option>");
            out.println("<option value='2016'>2016</option>");
            out.println("<option value='2017'>2017</option>");
            out.println("<option value='2018'>2018</option>");
            out.println("</select>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2' align='right'><input type='submit' value=' Confirmar compra ' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            
            out.println("</div>");
            
            out.println(footer.getFooterPadrao());

        } finally {            
            out.close();
        }
    }
    
    private CartBeanRemote getCartBean(HttpServletRequest request) throws ServletException {
        HttpSession httpSession = request.getSession(true);
        CartBeanRemote carrinho = (CartBeanRemote) httpSession.getAttribute(STATEFUL_BEAN_KEY);
        if (carrinho == null) {
            try {
                InitialContext ic = new InitialContext();
                carrinho = (CartBeanRemote) ic.lookup("ejb/CartBean");
                httpSession.setAttribute(STATEFUL_BEAN_KEY, carrinho);
            } catch (NamingException e) {
                throw new ServletException(e);
            }
        }
        return carrinho;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
