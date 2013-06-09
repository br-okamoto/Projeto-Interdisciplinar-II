/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.ListaDeDesejo;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.jpa.facade.ListaDeDesejoFacadeRemote;
import allshoes.jpa.facade.ProdutoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ListaDeDesejos extends HttpServlet {
    
    @EJB
    private ListaDeDesejoFacadeRemote listaEjb;
    
    @EJB
    private ClienteFacadeRemote clienteEjb;
    
    @EJB
    private ProdutoFacadeRemote produtoEjb;

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
           header = new Header(true,"Infantil", username);
        }
        catch (NullPointerException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/ListaDeDesejos");
            rd.forward(request, response);
        }
        
        Cliente cliente = clienteEjb.find(username);
        List<ListaDeDesejo> lista = listaEjb.findAll();
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Lista de Desejos</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("Lista de Desejos");
            out.println("</div>");
            
            for (ListaDeDesejo l : lista) {
                if (l.getCliente().getIdPessoa() == cliente.getIdPessoa()) {
                    out.println("<div class='departamentoProduto'>");
                    out.println("<form action='AdicionarProduto' method='post'>");
                    out.println("<img src='" + request.getContextPath() + "/images/produtos/"+l.getProduto().getCod_produto()+".jpg' alt='' />");
                    out.println("<h2>"+l.getProduto().getNome()+"</h2>");
                    out.println("<div class='precoProduto'>"+l.getProduto().getPreco()+"</div>");
                    out.println("<input type='hidden' name='cod_produto' value='" + l.getProduto().getCod_produto() + "' />");
                    out.println("<input type='hidden' name='action' value='RemoverListaDesejos' />");
                    out.println("<input type='submit' id='removerLista' value=' Remover ' />");
                    out.println("</form>");
                    out.println("</div>");
                }
            }
            
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
