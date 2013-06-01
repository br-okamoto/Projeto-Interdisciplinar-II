/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.Pedido;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.jpa.facade.PedidoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
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
public class MeusPedidos extends HttpServlet {
    
    @EJB
    PedidoFacadeRemote pedidoEjb;
    
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
        Header header = new Header(false, "Meus Pedidos");
        Footer footer = new Footer(false);
        
        String username = null;
        HttpSession session = request.getSession();
        try {
           username = session.getAttribute("username").toString();
        }
        catch (NullPointerException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/MeusPedidos");
            rd.forward(request, response);
        }
        
        Cliente cliente = ejb.find(username);
        List<Pedido> pedidos = pedidoEjb.findAll();
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Meus Pedidos</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Meus Pedidos");
            out.println("</div>");
            
            out.println("<table cellpadding='3' cellspacing='3' border='0'>");
            out.println("<tr>");
            out.println("<td>Número do Pedido</td>");
            out.println("<td>Data do Pedido</td>");
            out.println("<td>Status do Pedido</td>");
            out.println("</tr>");
            for (Pedido p : pedidos) {
                //Verificar se p não é uma venda de balcao (cliente == null)
                if (p.getCliente() != null) {
                    if (p.getCliente().getIdPessoa() == cliente.getIdPessoa()) {
                        out.println("<tr>");
                        out.println("<td><a href='" + request.getContextPath() + "/DetalheDoPedido?idPedido="+p.getIdPedido()+"'>"+p.getIdPedido()+"</a></td>");
                        out.println("<td>"+p.getDataPedido()+"</td>");
                        out.println("<td>"+p.getStatus()+"</td>");
                        out.println("</tr>");
                    }
                }
            }
            out.println("</table>");
            
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
