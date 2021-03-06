/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.Usuario;
import allshoes.jpa.facade.ClienteFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class Autenticar extends HttpServlet {
    
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
        String username = request.getParameter("txtLogin");
        char[] senha = request.getParameter("txtSenha").toCharArray();
        String returnURL = request.getParameter("returnURL");
        Cliente cliente = ejb.find(username);
        
        //usuario nao encontrado
        if(cliente==null) {
            request.setAttribute("msgErro","Usuário não existe. Por favor, faça o cadastro primeiro.");
            RequestDispatcher rd = request.getRequestDispatcher("Login");
            
            rd.forward(request, response);
        } else {
            Usuario tentandoLogar = new Usuario(username, senha);
            //usuario encontrado, mas senha errada
            if (!Arrays.equals(cliente.getSenha(),senha)) {
                request.setAttribute("msgErro","Senha incorreta. Por favor, tente de novo." + cliente.getSenha().toString() + " - " + senha.toString());
                RequestDispatcher rd = request.getRequestDispatcher("Login");
                
                rd.forward(request, response);
            } else { //usuario encontrado e senha correta: redireciona para a pagina que o usuario estava antes do login
                HttpSession session = request.getSession();
                session.setAttribute("username", cliente.getLogin());
                session.setAttribute("nome", cliente.getNome());
                session.setAttribute("idpessoa", cliente.getIdPessoa());
                response.sendRedirect(returnURL);
            }
        }
        
            
       

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdicionarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
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
