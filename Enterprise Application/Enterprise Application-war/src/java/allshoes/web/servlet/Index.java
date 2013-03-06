/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import allshoes.web.model.*;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "Index", urlPatterns = {"/"})
public class Index extends HttpServlet {

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
            out.println("<title>All Shoes - Home</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='" + CSSurl + "'/>");
            out.println("<script type='text/javascript' src='"+request.getContextPath()+"/js/jquery-1.8.2.min.js' ></script>");
            out.println("<script type='text/javascript' src='"+request.getContextPath()+"/js/script.js' ></script>");
            out.println("</head>");
            out.println("<body>");
            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<div id='gallery'>");
            out.println("<div id='slides'>");
            out.println("<div class='slide'><img src='"+request.getContextPath()+"/images/adidas.jpg' width='1000' height='300' alt='side' /></div>");
            out.println("<div class='slide'><img src='"+request.getContextPath()+"/images/mizuno.jpg' width='1000' height='300' alt='side' /></div>");
            out.println("<div class='slide'><img src='"+request.getContextPath()+"/images/nike.jpg' width='1000' height='300' alt='side' /></div>");
            out.println("</div>");
            out.println("<div id='menu'>");
            out.println("<ul>");
            out.println("<li class='fbar'>&nbsp;</li>");
            out.println("<li class='menuItem'><a href='DetalheDoProduto/?pid=111'><img src='"+request.getContextPath()+"/images/thumb_adidas.jpg' alt='thumbnail' /></a></li>");
            out.println("<li class='menuItem'><a href='DetalheDoProduto/?pid=222'><img src='"+request.getContextPath()+"/images/thumb_mizuno.jpg' alt='thumbnail' /></a></li>");
            out.println("<li class='menuItem'><a href='DetalheDoProduto/?pid=222'><img src='"+request.getContextPath()+"/images/thumb_nike.jpg' alt='thumbnail' /></a></li>");
            out.println("</ul>");
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
