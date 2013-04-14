/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Sexo;
import allshoes.jpa.Cliente;
import allshoes.jpa.Endereco;
import allshoes.jpa.Estado;
import allshoes.jpa.Pessoa;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Cadastrar extends HttpServlet {
    
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
        Date date;
        String action = request.getParameter("action");
        
        Cliente cliente = new Cliente();
        if(action.equals("Alterar")) {
            HttpSession session = request.getSession();
            cliente.setIdPessoa(Integer.parseInt(session.getAttribute("idpessoa").toString()));
        }
        cliente.setNome(request.getParameter("txtNome"));
        cliente.setCpf(request.getParameter("txtCPF"));
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = (java.util.Date)formatter.parse(request.getParameter("txtDtNascimento"));
        }
        catch (ParseException e) {
            date = null;
        }
        cliente.setDataNascimento(date);
        cliente.setSexo(Sexo.valueOf(request.getParameter("rdSexo")));
        cliente.setTelefone(request.getParameter("txtTelefone"));
        cliente.setCelular(request.getParameter("txtCelular"));
        cliente.setEmail(request.getParameter("txtEmail"));
        cliente.setLogin(request.getParameter("txtEmail"));
        cliente.setSenha(request.getParameter("txtSenha").toCharArray());
        
        Endereco endereco = new Endereco();
        endereco.setRua(request.getParameter("txtRua"));
        endereco.setNumero(request.getParameter("txtNumero"));
        endereco.setComplemento(request.getParameter("txtComplemento"));
        endereco.setCep(request.getParameter("txtCEP"));
        endereco.setBairro(request.getParameter("txtBairro"));
        endereco.setCidade(request.getParameter("txtCidade"));
        endereco.setEstado(Estado.valueOf(request.getParameter("ddlEstado")));
        //endereco.setPes((Pessoa)cliente);
        
        cliente.setEndereco(endereco);

        try {
           
            out.println(header.getHeaderPadrao());
            if(action.equals("Cadastrar")) {
                ejb.create(cliente);
                out.println("<div class='cadastroSucesso'>");
                out.println("<img src='images/icon-ok.png' alt='sucesso' />");
                out.println("<span>Cadastro realizado com sucesso!</span><br/>");
                out.println("<input type='button' value=' Voltar ' onclick='javascript:history.go(-2)' />");
                out.println("</div>");
            }
            else if (action.equals("Alterar")) {
                ejb.edit(cliente);
                out.println("<div class='cadastroSucesso'>");
                out.println("<img src='images/icon-ok.png' alt='sucesso' />");
                out.println("<span>Alteração realizada com sucesso!</span><br/>");
                out.println("<input type='button' value=' Voltar ' onclick='/Enterprise_Application-war/MeuCadastro' />");
                out.println("</div>");
            }
            

            
            out.println(footer.getFooterPadrao());

        } catch(Exception e) {
            out.println("<div class='cadastroSucesso'>");
            out.println("<img src='images/icon-error.png' alt='erro' />");
            out.println("<span>Não foi possível realizar o cadastro. Por favor, tente novamente</span><br/>");
            out.println("<input type='button' value=' Voltar ' onclick='javascript:history.go(-2);' />");
            out.println("</div>");
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
