/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.Pedido;
import allshoes.jpa.StatusDoPedido;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 31145507
 */
public class RealizarPagamento extends HttpServlet {

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

        boolean pagamentoRealizado = false;
        
        HttpSession session = request.getSession();
        
        Pedido pedido = (Pedido)session.getAttribute("pedido");
        
        //INTEGRAÇÃO com a operadora do cartão para realizar a transação - set pagamentoRealizado = true se realizado com sucesso!
        pedido.setPagamentoRealizado(pagamentoRealizado);
        
        session.setAttribute("pedido", pedido);
        pedido.setStatus(StatusDoPedido.AguardandoPagamento);
        
        if (pagamentoRealizado) {
            pedido.setStatus(StatusDoPedido.AguardandoMatriz);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("FinalizacaoDoPedido");
        rd.forward(request, response);
            
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
