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
public class Login extends HttpServlet {

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
        Header header = new Header(false, "Login");
        Footer footer = new Footer(false);
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='loginBox'>");
            out.println("<h1>Login</h1>");
            out.println("<form action='Autenticar' method='post'>");
            out.println("<table border='0' cellpadding='3' cellspacing='3'>");
            out.println("<tr>");
            out.println("<td>Usuário</td>");
            out.println("<td colspan='2'><input type='text' name='txtLogin'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Senha</td>");
            out.println("<td colspan='2'><input type='password' name='txtSenha'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='3'><input type='hidden' value='"+request.getParameter("returnURL") +"' name='returnURL'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan='2'><a href='EsqueciMinhaSenha'>Esqueci minha senha<a/></td>");
            out.println("<td align='right'><input type='submit' value='Acessar'/></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div id='loginCadastrarbt'>");
            out.println("<h2>Ainda não tenho cadastro</h2>");
            out.println("<form action='Cadastro' method='post'>");
            out.println("<div>");
            out.println("<input type='submit' value='Cadastrar'/>");
            out.println("</div>");
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
