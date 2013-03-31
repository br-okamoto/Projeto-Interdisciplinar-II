/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Sexo;
import allshoes.jpa.Usuario;
import allshoes.jpa.facade.UsuarioFacadeRemote;
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

/**
 *
 * @author Bruno
 */
public class Cadastrar extends HttpServlet {
    
    @EJB(mappedName = "ejb/UsuarioFacade")
    UsuarioFacadeRemote ejb;

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
        
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("txtNome"));
        usuario.setCpf(request.getParameter("txtCPF"));
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = (java.util.Date)formatter.parse(request.getParameter("txtDtNascimento"));
        }
        catch (ParseException e) {
            date = null;
        }
        usuario.setDataNascimento(date);
        Sexo sexo = request.getParameter("rdSexo")=="Masculino" ? Sexo.Masculino : Sexo.Feminino;
        usuario.setSexo(sexo);
        usuario.setTelefone(request.getParameter("txtTelefone"));
        usuario.setCelular(request.getParameter("txtCelular"));
        usuario.setEmail(request.getParameter("txtEmail"));
        usuario.setLogin(request.getParameter("txtEmail"));
        usuario.setSenha(request.getParameter("txtSenha").toCharArray());
        
        try {
           
            out.println(header.getHeaderPadrao());
            ejb.create(usuario);
            out.println("<div class='cadastroSucesso'>");
            out.println("<img src='images/icon-ok.png' alt='sucesso' />");
            out.println("<span>Cadastro realizado com sucesso!</span><br/>");
            out.println("<input type='button' value=' Voltar ' onclick='javascript:history.go(-2);' />");
            out.println("</div>");

            
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
