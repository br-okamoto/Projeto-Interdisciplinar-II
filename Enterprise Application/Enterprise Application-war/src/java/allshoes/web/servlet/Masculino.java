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
public class Masculino extends HttpServlet {

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
        Header header = new Header(false, "Masculino");
        Footer footer = new Footer(false);
        
        try {
            out.println(header.getHeaderPadrao());
            
            //out.println("<h1>Masculino - pendente inserir código</h1>");
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
            
            out.println("<div id='pageTitle'><h1>Masculino</h1></div>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Masculino");
            out.println("</div>");
            
            out.println("<div class='departamentoProduto'>");
            out.println("<a href='DetalheDoProduto?pid=111'><img src='" + request.getContextPath() + "/images/adidas-galeria.jpg' alt='' /></a>");
            out.println("<h2><a href='DetalheDoProduto?pid=111'>Adidas 4.3</a></h2>");
            out.println("<div class='precoProduto'>R$ 159,90</div>");
            out.println("<div class='precoProduto'>6 x R$ 26,65 sem juros</div>");
            out.println("</div>");
            
            out.println("<div class='departamentoProduto'>");
            out.println("<img src='" + request.getContextPath() + "/images/mizuno-galeria.jpg' alt='' />");
            out.println("<h2>Mizuno Wave Ultima 4</h2>");
            out.println("<div class='precoProduto'>R$ 399,90</div>");
            out.println("<div class='precoProduto'>6 x R$ 66,65 sem juros</div>");
            out.println("</div>");
            
            out.println("<div class='departamentoProduto'>");
            out.println("<img src='" + request.getContextPath() + "/images/nike-galeria.jpg' alt='' />");
            out.println("<h2>Nike Lunarglide+4</h2>");
            out.println("<div class='precoProduto'>R$ 499,90</div>");
            out.println("<div class='precoProduto'>6 x R$ 83,32 sem juros</div>");
            out.println("</div>");
            
            out.println("<div class='departamentoProduto'>");
            out.println("<img src='" + request.getContextPath() + "/images/adidas-galeria.jpg' alt='' />");
            out.println("<h2>Tênis Adidas 4.3</h2>");
            out.println("<div class='precoProduto'>R$ 159,90</div>");
            out.println("<div class='precoProduto'>6 x R$ 26,65 sem juros</div>");
            out.println("</div>");
            
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
