/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.facade.CartBean;
import allshoes.facade.CartBeanRemote;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.Produto;
import allshoes.jpa.facade.PedidoFacadeRemote;
import allshoes.jpa.facade.ProdutoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Bruno
 */
public class MeuCarrinho extends HttpServlet {
    private static final String STATEFUL_BEAN_KEY = "STATEFUL_BEAN_KEY";

    @EJB
    ProdutoFacadeRemote prodEjb;
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
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Header header = new Header(false, "Meu Carrinho");
        Footer footer = new Footer(false);
        
        CartBeanRemote carrinho = getCartBean(request);
        
        ArrayList<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
        
        String action = request.getParameter("action");
        if (action != null) {
            int cod_prod = Integer.parseInt(request.getParameter("cod_produto"));
            Produto produto = prodEjb.find(cod_prod);
            if (" + ".equals(action)) {
                carrinho.addItem(produto);
            } else if ("reduzir".equals(action)){
                carrinho.removeItem(produto);
            }
        }

        itens = (ArrayList<ItemDoPedido>)carrinho.getItems();
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Meu Carrinho</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Meu Carrinho");
            out.println("</div>");
            
            out.println("<table id='tbCarrinho' border='0' cellpadding='3' cellspacing='3' width='1000'>");
            out.println("<tr>");
            out.println("<th colspan='2' align='left'>Produto</th>");
            out.println("<th colspan='2' align='center'>Quantidade</th>");
            out.println("<th align='center'>Preço</th>");
            out.println("</tr>");
            
            for (ItemDoPedido i : itens) {
                out.println("<form action='MeuCarrinho' method='post'>");
                out.println("<tr>");
                out.println("<td width='130' align='left'>");
                out.println("<a href='DetalheDoProduto?cod_produto="+i.getProduto().getCod_produto()+"'><img src='" + request.getContextPath() + "/images/produtos/"+i.getProduto().getCod_produto()+".jpg' alt='' width='120' height='120'/></a>");
                out.println("</td>");
                out.println("<td valign='top'>");
                out.println("<a href='DetalheDoProduto?cod_produto="+i.getProduto().getCod_produto()+"'><h2>"+i.getProduto().getNome()+"</h2></a>");
                out.println("<span><b>Cor:</b> "+i.getProduto().getCor()+"</span><br/>");
                out.println("<span><b>Tamanho:</b> "+i.getProduto().getTamanho()+"</span>");
                out.println("</td>");
                out.println("<td width='50' align='center'>");
                out.println("<input type='text' name='nQtde' size='1' value='"+i.getQuantidade()+"'/>");
                out.println("</td>");
                out.println("<td width='50' align='center'>");
                out.println("<input type='hidden' value='"+i.getProduto().getCod_produto()+"' name='cod_produto'/>");
                out.println("<input type='submit' value=' + ' name='action' /><br/><br/>");
                out.println("<input type='submit' value=' &ndash; ' />");
                out.println("<input type='hidden' value='reduzir' name='action' />");
                out.println("</td>");
                out.println("<td width='150' align='center'><b>R$ "+i.getSubTotal()+"</b></td>");
                out.println("</tr>");
                 out.println("</form>");
            }
            
            
            
            out.println("<tr>");
            out.println("<td colspan='5'>&nbsp;</td>");
            out.println("</tr>");
            out.println("<form action='ConfirmarEndereco' method='post'>");
            out.println("<tr>");
            out.println("<td colspan='5' align='right'><input type='submit' value=' Continuar ' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");
            
            out.println(footer.getFooterPadrao());

        } finally {            
            out.close();
        }
    }
    
    private static Context getInitialContext() throws NamingException {
        return new InitialContext();
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(MeuCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(MeuCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
