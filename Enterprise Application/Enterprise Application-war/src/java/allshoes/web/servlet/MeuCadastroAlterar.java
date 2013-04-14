/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.Sexo;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class MeuCadastroAlterar extends HttpServlet {
    @EJB(mappedName = "ejb/ClienteFacade")
    ClienteFacadeRemote ejb;

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
        Header header = new Header(false, "Cadastrar");
        Footer footer = new Footer(false);
        HttpSession session = request.getSession();
        Cliente cliente = ejb.find(Integer.parseInt(session.getAttribute("idpessoa").toString()));
        
        try {
           
            out.println(header.getHeaderPadrao());
            
            out.println("<form action='Cadastrar' method='post'>");
            out.println("<h1>Cadastro</h1>");
            out.println("<table width='100%' cellpadding='3' cellspacing='3' border='0'>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Nome</td>");
            out.println("<td><input name='txtNome' type='text' class='txtNome' value='" + cliente.getNome() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CPF</td>");
            out.println("<td><input name='txtCPF' type='text' class='txtCPF' value='" + cliente.getCpf() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Data de Nascimento</td>");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            String data = formatter.format(cliente.getDataNascimento());
            out.println("<td><input name='txtDtNascimento' type='text' class='txtDtNascimento' value='" + data + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Sexo</td>");
            out.println("<td>");
            if (cliente.getSexo() == Sexo.Masculino) {
                out.println("<input name='rdSexo' type='radio' class='txtSexo' value='Masculino' checked>Masculino</input>");
                out.println("<input name='rdSexo' type='radio' class='txtSexo' value='Feminino'>Feminino</input>");
            } else {
                out.println("<input name='rdSexo' type='radio' class='txtSexo' value='Masculino'>Masculino</input>");
                out.println("<input name='rdSexo' type='radio' class='txtSexo' value='Feminino' checked>Feminino</input>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Telefone</td>");
            out.println("<td><input name='txtTelefone' type='text' class='txtTelefone' value='" + cliente.getTelefone() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Celular</td>");
            out.println("<td><input name='txtCelular' type='text' class='txtCelular' value='" + cliente.getCelular() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>E-mail</td>");
            out.println("<td><input name='txtEmail' type='text' class='txtEmail' value='" + cliente.getEmail() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Senha</td>");
            out.println("<td><input name='txtSenha' type='password' class='txtSenha'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Confirmar senha</td>");
            out.println("<td><input name='txtConfSenha' type='password' class='txtSenha'/></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("");
            out.println("<h1>Endereço</h1>");
            out.println("<table cellpadding='3' cellspacing='3' border='0' >");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Rua</td>");
            out.println("<td style='width:310px;'><input name='txtRua' type='text' class='txtRua' value='" + cliente.getEndereco().getRua() + "'/></td>");
            out.println("<td class='lbl_cadastro2'>Número</td>");
            out.println("<td><input name='txtNumero' type='text' class='txtNumero' value='" + cliente.getEndereco().getNumero() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Complemento</td>");
            out.println("<td colspan='3'><input name='txtComplemento' type='text' class='txtComplemento' value='" + cliente.getEndereco().getComplemento() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CEP</td>");
            out.println("<td colspan='3'><input name='txtCEP' type='text' class='txtCEP' value='" + cliente.getEndereco().getCep() + "'/></td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Bairro</td>");
            out.println("<td colspan='3'><input name='txtBairro' type='text' class='txtBairro' value='" + cliente.getEndereco().getBairro() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Cidade</td>");
            out.println("<td colspan='3'><input name='txtCidade' type='text' class='txtCidade' value='" + cliente.getEndereco().getCidade() + "'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Estado</td>");
            out.println("<td colspan='3'>");
            out.println("<select name='ddlEstado'>");
            out.println("<option value='AC'>Acre - AC</option>");
            out.println("<option value='AL'>Alagoas - AL</option>");
            out.println("<option value='AP'>Amapá - AP</option>");
            out.println("<option value='AM'>Amazonas - AM</option>");
            out.println("<option value='BA'>Bahia - BA</option>");
            out.println("<option value='CE'>Ceará - CE</option>");
            out.println("<option value='DF'>Distrito Federal - DF</option>");
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
            out.println("<input type='submit' value='Alterar' name='action'/>");
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
