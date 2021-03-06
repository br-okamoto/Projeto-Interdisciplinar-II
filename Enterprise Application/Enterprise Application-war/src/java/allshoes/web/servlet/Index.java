/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Produto;
import allshoes.jpa.facade.EstoqueProdutoFacadeRemote;
import allshoes.jpa.facade.ProdutoFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import allshoes.web.model.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "Index", urlPatterns = {"/"})
public class Index extends HttpServlet {
    
    @EJB(mappedName = "ejb/ProdutoFacade")
    private ProdutoFacadeRemote ejb;

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
        Header header = null;
        Footer footer = new Footer(false);
        
        String username = null;
        HttpSession session = request.getSession();
        try {
            username = session.getAttribute("username").toString();
            header = new Header(true,"Home", username);
        }
        catch (NullPointerException ex) {
            header = new Header(false,"Home", "");
        }
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            
                out.println("<div id='gallery'>");
            
                    out.println("<div id='slides'>");
                        out.println("<div class='slide'><a href='DetalheDoProduto?cod_produto=1'><img src='"+request.getContextPath()+"/images/adidas.jpg' width='992' height='298' alt='side' /></a></div>");
                        out.println("<div class='slide'><a href='DetalheDoProduto?cod_produto=2'><img src='"+request.getContextPath()+"/images/mizuno.jpg' width='992' height='298' alt='side' /></a></div>");
                        out.println("<div class='slide'><a href='DetalheDoProduto?cod_produto=3'><img src='"+request.getContextPath()+"/images/nike.jpg' width='992' height='298' alt='side' /></a></div>");
                    out.println("</div>");
            
                    out.println("<div id='menu'>");
                        out.println("<ul>");
                            out.println("<li class='fbar'>&nbsp;</li>");
                            out.println("<li class='menuItem'><a><img src='"+request.getContextPath()+"/images/thumb_adidas.jpg' alt='thumbnail' /></a></li>");
                            out.println("<li class='menuItem'><a><img src='"+request.getContextPath()+"/images/thumb_mizuno.jpg' alt='thumbnail' /></a></li>");
                            out.println("<li class='menuItem'><a><img src='"+request.getContextPath()+"/images/thumb_nike.jpg' alt='thumbnail' /></a></li>");
                        out.println("</ul>");
                    out.println("</div>");
            
                out.println("</div>");
                
                out.println("<div id='home-listagem'");
                List<Produto> produtos = ejb.findAll();
                for (Produto p : produtos) {
                    out.println("<div class='box-produto'>");
                    out.println("<a href='"+request.getContextPath()+"/DetalheDoProduto?cod_produto="+p.getCod_produto()+"'><img src='"+request.getContextPath()+"/images/produtos/"+p.getCod_produto()+".jpg' /></a>");
                    out.println("<a href='"+request.getContextPath()+"/DetalheDoProduto?cod_produto="+p.getCod_produto()+"'>"+p.getNome()+"</a><br/>");
                    out.println("R$ " + p.getPreco());
                    out.println("</div>");
                }
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
