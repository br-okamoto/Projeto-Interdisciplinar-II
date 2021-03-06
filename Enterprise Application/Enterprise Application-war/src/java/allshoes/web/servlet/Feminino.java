/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Produto;
import allshoes.jpa.facade.ProdutoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class Feminino extends HttpServlet {
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Header header = null;
        Footer footer = new Footer(false);
        
        String username = null;
        HttpSession session = request.getSession();
        try {
            username = session.getAttribute("username").toString();
            header = new Header(true,"Feminino", username);
        }
        catch (NullPointerException ex) {
            header = new Header(false,"Feminino", "");
        }
        
        List<Produto> produtos = prodEjb.findAll();
        
        try {

            out.println(header.getHeaderPadrao());
            
            //out.println("<h1>Feminino - pendente inserir código</h1>");
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
            out.println("<div id='pageTitle'><h1>Feminino</h1></div>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Feminino");
            out.println("</div>");
            
            if (produtos != null) {
                for (Produto p : produtos) {
                    if (p.getDepartamento().getNomeDepartamento().toString().equals("Feminino")) {
                        out.println("<div class='departamentoProduto'>");
                        out.println("<a href='DetalheDoProduto?cod_produto="+p.getCod_produto()+"'><img src='" + request.getContextPath() + "/images/produtos/"+p.getCod_produto()+".jpg' alt='' /></a>");
                        out.println("<h2><a href='DetalheDoProduto?cod_produto="+p.getCod_produto()+"'>"+p.getNome()+"</a></h2>");
                        out.println("<div class='precoProduto'>R$ "+p.getPreco()+"</div>");
                        out.println("</div>");
                    }
                }
            }
            
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
