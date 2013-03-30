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
public class MeuCarrinho extends HttpServlet {

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
        Header header = new Header(false, "Meu Carrinho");
        Footer footer = new Footer(false);
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Meu Carrinho</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Meu Carrinho");
            out.println("</div>");
            out.println("<form action='Pagamento' method='post'>");
            out.println("<table id='tbCarrinho' border='0' cellpadding='3' cellspacing='3' width='1000'>");
            out.println("<tr>");
            out.println("<th colspan='2' align='left'>Produto</th>");
            out.println("<th colspan='2' align='center'>Quantidade</th>");
            out.println("<th align='center'>Preço</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width='130' align='left'>");
            out.println("<a href='DetalheDoProduto?pid=111'><img src='" + request.getContextPath() + "/images/adidas-galeria.jpg' alt='' width='120' height='120'/></a>");
            out.println("</td>");
            out.println("<td valign='top'>");
            out.println("<a href='DetalheDoProduto?pid=111'><h2>Tênis Adidas 4.3</h2></a>");
            out.println("<span><b>Cor:</b> Cor 1</span><br/>");
            out.println("<span><b>Tamanho:</b> 42</span>");
            out.println("</td>");
            out.println("<td width='50' align='center'>");
            out.println("<input type='text' name='nQtde' size='1' value='1'/>");
            out.println("</td>");
            out.println("<td width='50' align='center'>");
            out.println("<input type='button' onclick='aumentarQtde();' value=' + ' /><br/><br/>");
            out.println("<input type='button' onclick='diminuirQtde();' value=' &ndash; ' />");
            out.println("</td>");
            out.println("<td width='150' align='center'><b>R$ 159,90</b></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='5'>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='5' align='right'><input type='submit' value=' Continuar ' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            
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
