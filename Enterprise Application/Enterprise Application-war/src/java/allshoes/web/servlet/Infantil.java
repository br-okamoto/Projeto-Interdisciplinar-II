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
public class Infantil extends HttpServlet {

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
            out.println("<title>All Shoes - Infantil</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='" + CSSurl + "'/>");
            out.println("</head>");
            out.println("<body>");
            out.println(header.getHeaderPadrao());
            
            //out.println("<h1>Infantil - pendente inserir código</h1>");
            out.println("<div id='menuLateral'>");
            out.println("<div id='Categorias'>");
            out.println("<h2>Categorias</h2>");
            out.println("</div>");
            out.println("<div id='Marcas'>");
            out.println("<h2>Marcas</h2>");
            out.println("</div>");
            out.println("<div id='Tamanho'>");
            out.println("<h2>Tamanho</h2>");
            out.println("</div>");
            out.println("<div id='Preco'>");
            out.println("<h2>Preço</h2>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div id='content'>");
            out.println("<div id='pageTitle'><h1>Infantil<h1></div>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Infantil");
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
