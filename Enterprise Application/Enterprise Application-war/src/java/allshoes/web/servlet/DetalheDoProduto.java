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
public class DetalheDoProduto extends HttpServlet {

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
        Header header = new Header(false, "Detalhe do Produto");
        Footer footer = new Footer(false);
        
        try {
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
            
            out.println("<img src='" + request.getContextPath() + "/images/produtos/adidas-g.jpg' alt='' class='imgDetalheProduto'/>");
            
            out.println("<div id='produtosInfo'>");
            out.println("<h1>Tênis Adidas 4.3</h1>");
            out.println("<form id='formProduto' action='AdicionarProduto' method='post'>");
            out.println("<table border='0' cellpadding='3' cellspacing='3' width='100%'>");
            out.println("<tr>");
            out.println("<td><b>Preço:</b></td>");
            out.println("<td>R$ 159,90</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>6 x R$ 26,65 sem juros</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'><b>Cores disponíveis:</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'>");
            out.println("<input type='radio' name='rdCor' value='cor1'>Cor 1</input>");
            out.println("<input type='radio' name='rdCor' value='cor2'>Cor 2</input>");
            out.println("<input type='radio' name='rdCor' value='cor2'>Cor 3</input>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'><b>Tamanhos disponíveis:</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'>");
            out.println("<input type='radio' name='rdTamanho' value='35'>35</input>");
            out.println("<input type='radio' name='rdTamanho' value='36'>36</input>");
            out.println("<input type='radio' name='rdTamanho' value='37'>37</input>");
            out.println("<input type='radio' name='rdTamanho' value='38'>38</input>");
            out.println("<input type='radio' name='rdTamanho' value='39'>39</input>");
            out.println("<input type='radio' name='rdTamanho' value='40'>40</input>");
            out.println("<input type='radio' name='rdTamanho' value='41'>41</input>");
            out.println("<input type='radio' name='rdTamanho' value='42'>42</input>");
            out.println("<input type='radio' name='rdTamanho' value='43'>43</input>");
            out.println("<input type='radio' name='rdTamanho' value='44'>44</input>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<tr>");
            out.println("<td colspan='2' align='right'><input type='submit' name='action' value='Adicionar a Lista de Desejos' />&nbsp;&nbsp;&nbsp;<input type='submit' name='action' value='Comprar' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("</table>");
            out.println("</form>");
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
