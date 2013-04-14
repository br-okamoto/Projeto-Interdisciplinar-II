/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
public class MeuCadastro extends HttpServlet {

    @EJB(mappedName = "ejb/ClienteFacade")
    private ClienteFacadeRemote ejb;
    
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
        Header header = new Header(false, "Meu Cadastro");
        Footer footer = new Footer(false);
        
        try {
            HttpSession session = request.getSession(false);
            String username = session.getAttribute("username").toString();
            
            Cliente cliente = ejb.find(username);
            
            out.println(header.getHeaderPadrao());

            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Meu Cadastro</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Meu Cadastro");
            out.println("</div>");
            
            out.println("<form action='MeuCadastro-Alterar' method='post'>");
            out.println("<h1>Dados Pessoais</h1>");
            out.println("<table width='100%' cellpadding='3' cellspacing='3' border='0'>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Nome</td>");
            out.println("<td>" + cliente.getNome()+ "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CPF</td>");
            out.println("<td>" + cliente.getCpf() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Data de Nascimento</td>");
            out.println("<td>" + cliente.getDataNascimento() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Sexo</td>");
            out.println("<td>" + cliente.getSexo() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Telefone</td>");
            out.println("<td>" + cliente.getTelefone() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Celular</td>");
            out.println("<td>" + cliente.getCelular() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>E-mail</td>");
            out.println("<td>" + cliente.getEmail() + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("");
            out.println("<h1>Endereço</h1>");
            out.println("<table cellpadding='3' cellspacing='3' border='0' >");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Rua</td>");
            out.println("<td style='width:310px;'>" + cliente.getEndereco().getRua() + "</td>");
            out.println("<td class='lbl_cadastro2'>Número</td>");
            out.println("<td>" + cliente.getEndereco().getNumero() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Complemento</td>");
            out.println("<td colspan='3'>" + cliente.getEndereco().getComplemento() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CEP</td>");
            out.println("<td colspan='3'>" + cliente.getEndereco().getCep() + "</td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Bairro</td>");
            out.println("<td colspan='3'>" + cliente.getEndereco().getBairro() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Cidade</td>");
            out.println("<td colspan='3'>" + cliente.getEndereco().getCidade() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Estado</td>");
            out.println("<td colspan='3'>" + cliente.getEndereco().getEstado() + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("");
            out.println("<div class='btnSubmit'>");
            out.println("<input type='submit' value=' Alterar '/>");
            out.println("</div>");
            out.println("</form>");
            
            out.println("</div>");

            out.println(footer.getFooterPadrao());
            

        } catch (NullPointerException e) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=http://localhost:8080/Enterprise_Application-war/MeuCadastro");            
            rd.forward(request, response);
        }
        finally {            
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
