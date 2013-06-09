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
public class DetalheDoProduto extends HttpServlet {
    
    @EJB(mappedName = "ejb/ProdutoFacade")
    ProdutoFacadeRemote ejb;

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
            header = new Header(true,"Detalhe do Produto", username);
        }
        catch (NullPointerException ex) {
            header = new Header(false,"Detalhe do Produto", "");
        }
        
        
        
        try {
            
            int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
            Produto produto = ejb.find(cod_produto);
        
            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Detalhe do Produto</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("<a href=''>[ dinamico ]</a>");
            out.println(" > ");
            out.println("Detalhe do Produto");
            out.println("</div>");
            
            out.println("<img src='" + request.getContextPath() + "/images/produtos/" + produto.getCod_produto() + ".jpg' alt='' class='imgDetalheProduto'/>");
            
            out.println("<div id='produtosInfo'>");
            out.println("<h1>" + produto.getNome() + "</h1>");
            out.println("<form id='formProduto' action='AdicionarProduto' method='post'>");
            out.println("<table border='0' cellpadding='3' cellspacing='3' width='100%'>");
            out.println("<tr>");
            out.println("<td><b>Preço:</b></td>");
            out.println("<td>R$ " + produto.getPreco() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>6 x R$ xx sem juros</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'><b>Cor:</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'>");
            out.println(produto.getCor());
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'><b>Tamanho:</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'>");
            out.println(produto.getTamanho());
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2' align='right'><input type='submit' name='action' value='Adicionar a Lista de Desejos' />&nbsp;&nbsp;&nbsp;<input type='submit' name='action' value='Comprar' /></td>");
            out.println("</tr>");
            out.println("<td style='display:none'><input type='hidden' name='cod_produto' value='"+produto.getCod_produto()+"' /></td>");
            out.println("<tr>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div>");
            out.println(produto.getDescricao());
            out.println("</div>");
            
            out.println("<div>&nbsp;</div>");
            out.println("<div>&nbsp;</div>");
            out.println("<div>&nbsp;</div>");
            out.println("<div>&nbsp;</div>");
            
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
