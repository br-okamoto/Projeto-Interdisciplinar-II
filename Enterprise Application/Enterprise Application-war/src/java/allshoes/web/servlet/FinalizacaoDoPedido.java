/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.StatusDoPedido;
import allshoes.jpa.facade.ItemDoPedidoFacadeRemote;
import allshoes.jpa.facade.PedidoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
public class FinalizacaoDoPedido extends HttpServlet {
    
    @EJB
    PedidoFacadeRemote pedidoEjb;
    
    @EJB
    ItemDoPedidoFacadeRemote itemPedidoEjb;

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
        Header header = new Header(false, "Finalização do Pedido");
        Footer footer = new Footer(false);
        
        HttpSession session = request.getSession();
        Pedido pedido = (Pedido)session.getAttribute("pedido");
        ArrayList<ItemDoPedido> itens = (ArrayList<ItemDoPedido>)session.getAttribute("itensDoPedido");
        
        pedidoEjb.create(pedido);
        
        for (ItemDoPedido i : itens) {
            i.setPedido(pedido);
            itemPedidoEjb.create(i);
        }
        
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Finalização do Pedido</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("<a href='" + request.getContextPath() + "/MeuCarrinho'>Meu Carrinho</a>");
            out.println(" > ");
            out.println("<a href='" + request.getContextPath() + "/Pagamento'>Pagamento</a>");
            out.println(" > ");
            out.println("Finalização do Pedido");
            out.println("</div>");
            
            out.println("<h1>Pedido Realizado</h1>");
            out.println("<h2>Informações gerais do pedido</h2>");
            out.println("<table border='0'>");
            out.println("<tr>");
            out.println("<td>Número do Pedido:</td>");
            out.println("<td>"+pedido.getIdPedido()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Status do Pedido:</td>");
            String statusPedido = pedido.getStatus() == StatusDoPedido.AguardandoPagamento ? "Aguardando Pagamento" : "Processando pedido";
            out.println("<td>"+statusPedido+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Data do Pedido:</td>");
            out.println("<td>"+pedido.getDataPedido()+"</td>");
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<h2>Detalhes do Pedido</h2>");
            out.println("");
            out.println("<h2>Forma de Pagamento</h2>");
            out.println("");
            out.println("<h2>Endereco de Entrega</h2>");
            out.println("");
            
            out.println("</div>");
            
            out.println(footer.getFooterPadrao());

        } finally {            
            out.close();
        }
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
