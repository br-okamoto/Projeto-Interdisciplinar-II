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
public class ConfirmarEndereco extends HttpServlet {

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
        Header header = new Header(false, "Confirmar Endereço");
        Footer footer = new Footer(false);
        
        String username = null;
        HttpSession session = request.getSession();
        try {
           username = session.getAttribute("username").toString();
        }
        catch (NullPointerException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/ConfirmarEndereco");
            rd.forward(request, response);
        }
        Cliente cliente = ejb.find(username);
        
        try {
           
            out.println(header.getHeaderPadrao());
            
            out.println("<form action='Pagamento' method='post'>");
            out.println("<h2>Escolha o endereço de entrega:</h2>");
            out.println("<div class='endereco'>");
            out.println("<input type='radio' name='rdEndereco' value='enderecoCadastrado'>Endereço cadastrado</input>");
            out.println("<table cellpadding='3' cellspacing='3' border='0' >");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Rua</td>");
            out.println("<td style='width:310px;'>"+cliente.getEndereco().getRua()+"</td>");
            out.println("<td class='lbl_cadastro2'>Número</td>");
            out.println("<td>"+cliente.getEndereco().getNumero()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Complemento</td>");
            out.println("<td colspan='3'>"+cliente.getEndereco().getComplemento()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CEP</td>");
            out.println("<td colspan='3'>"+cliente.getEndereco().getCep()+"</td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Bairro</td>");
            out.println("<td colspan='3'>"+cliente.getEndereco().getBairro()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Cidade</td>");
            out.println("<td colspan='3'>"+cliente.getEndereco().getCidade()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Estado</td>");
            out.println("<td colspan='3'>");
            out.println(cliente.getEndereco().getEstado());
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            
            out.println("<div class='endereco'>");
            out.println("<input type='radio' name='rdEndereco' value='enderecoAlternativo'>Endereço alternativo</input>");
            out.println("<table cellpadding='3' cellspacing='3' border='0' >");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Rua</td>");
            out.println("<td style='width:310px;'><input name='txtRua' type='text' class='txtRua'/></td>");
            out.println("<td class='lbl_cadastro2'>Número</td>");
            out.println("<td><input name='txtNumero' type='text' class='txtNumero'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Complemento</td>");
            out.println("<td colspan='3'><input name='txtComplemento' type='text' class='txtComplemento'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CEP</td>");
            out.println("<td colspan='3'><input name='txtCEP' type='text' class='txtCEP'/></td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Bairro</td>");
            out.println("<td colspan='3'><input name='txtBairro' type='text' class='txtBairro'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Cidade</td>");
            out.println("<td colspan='3'><input name='txtCidade' type='text' class='txtCidade'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Estado</td>");
            out.println("<td colspan='3'>");
            out.println("<select name='ddlEstado'>");
            out.println("<option value='AC' selected='selected'>Acre - AC</option>");
            out.println("<option value='AL'>Alagoas - AL</option>");
            out.println("<option value='AP'>Amapá - AP</option>");
            out.println("<option value='AM'>Amazonas - AM</option>");
            out.println("<option value='BA'>Bahia&nbsp; - BA</option>");
            out.println("<option value='CE'>Ceará - CE</option>");
            out.println("<option value='DF'>Distrito Federal&nbsp; - DF</option>");
            out.println("<option value='ES'>Espírito Santo - ES</option>");
            out.println("<option value='GO'>Goiás - GO</option>");
            out.println("<option value='MA'>Maranhão - MA</option>");
            out.println("<option value='MT'>Mato Grosso - MT</option>");
            out.println("<option value='MS'>Mato Grosso do Sul - MS</option>");
            out.println("<option value='MG'>Minas Gerais - MG</option>");
            out.println("<option value='PA'>Pará - PA</option>");
            out.println("<option value='PB'>Paraíba - PB</option>");
            out.println("<option value='PR'>Paraná - PR</option>");
            out.println("<option value='PE'>Pernambuco - PE</option>");
            out.println("<option value='PI'>Piauí - PI</option>");
            out.println("<option value='RJ'>Rio de Janeiro - RJ</option>");
            out.println("<option value='RN'>Rio Grande do Norte - RN</option>");
            out.println("<option value='RS'>Rio Grande do Sul - RS</option>");
            out.println("<option value='RO'>Rondônia - RO</option>");
            out.println("<option value='RR'>Roraima - RR</option>");
            out.println("<option value='SC'>Santa Catarina - SC</option>");
            out.println("<option value='SP'>São Paulo - SP</option>");
            out.println("<option value='SE'>Sergipe - SE</option>");
            out.println("<option value='TO'>Tocantins - TO</option>");
            out.println("</select>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("");
            out.println("<div class='btnSubmit'>");
            out.println("<input type='submit' value='Cadastrar' name='action'/>");
            out.println("</div>");
            out.println("</div>");
            
            
            out.println("</form>");

            
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
