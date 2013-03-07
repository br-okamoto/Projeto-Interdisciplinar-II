/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
public class Pagamento extends HttpServlet {

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
        Header header = new Header(false);
        Footer footer = new Footer(false);
        String CSSurl = request.getContextPath() + "/css/styles.css";
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>All Shoes - Meus Pedidos</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='" + CSSurl + "'/>");
            out.println("<script type='text/javascript' src='"+request.getContextPath()+"/js/jquery-1.8.2.min.js' ></script>");
            out.println("<script type='text/javascript' src='"+request.getContextPath()+"/js/custom.js' ></script>");
            out.println("</head>");
            out.println("<body>");
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
            out.println("asd");
            out.println("</div>");
            
            out.println("</div>");
            
            out.println(footer.getFooterPadrao());
            out.println("</body>");
            out.println("</html>");
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
