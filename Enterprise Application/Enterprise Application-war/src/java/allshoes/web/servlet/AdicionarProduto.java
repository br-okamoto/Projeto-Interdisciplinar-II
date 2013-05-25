/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.facade.CartBean;
import allshoes.facade.CartBeanRemote;
import allshoes.jpa.Cliente;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.ListaDeDesejo;
import allshoes.jpa.Pedido;
import allshoes.jpa.Produto;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.jpa.facade.ListaDeDesejoFacadeRemote;
import allshoes.jpa.facade.PedidoFacadeRemote;
import allshoes.jpa.facade.ProdutoFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class AdicionarProduto extends HttpServlet {

    private static final String STATEFUL_BEAN_KEY = "STATEFUL_BEAN_KEY";
    
    @EJB
    ProdutoFacadeRemote prodEjb;
    
    @EJB
    ListaDeDesejoFacadeRemote listaEjb;
    
    @EJB
    ClienteFacadeRemote clienteEjb;
    
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
        
        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
        Produto produto = prodEjb.find(cod_produto);
        
        CartBeanRemote carrinho = getCartBean(request);
        
        String action = request.getParameter("action");

        if ("Adicionar a Lista de Desejos".equals(action)) {
            HttpSession session = request.getSession();
        
            String username = null;

            try {
               username = session.getAttribute("username").toString();
            }
            catch (NullPointerException ex) {
                RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/ListaDeDesejos");
                rd.forward(request, response);
            }
            Cliente cliente = clienteEjb.find(username);
            
            List<ListaDeDesejo> listaDesejos = listaEjb.findAll();
            boolean isOnTheList = false;
            for (ListaDeDesejo l : listaDesejos) {
                if (l.getProduto().getIdProduto() == produto.getIdProduto() && l.getCliente().getIdPessoa() == cliente.getIdPessoa())
                    isOnTheList = true;
            }
            if (!isOnTheList) {
            ListaDeDesejo item = new ListaDeDesejo();
                item.setCliente(cliente);
                item.setProduto(produto);
                listaEjb.create(item);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("ListaDeDesejos");
            rd.forward(request, response);
        } else if ("Comprar".equals(action)) {

            carrinho.addItem(produto);
            
            RequestDispatcher rd = request.getRequestDispatcher("MeuCarrinho");
            rd.forward(request, response);
        }

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdicionarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+action+"</h1>");
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

    private CartBeanRemote getCartBean(HttpServletRequest request) throws ServletException {
        HttpSession httpSession = request.getSession(true);
        CartBeanRemote carrinho = (CartBeanRemote) httpSession.getAttribute(STATEFUL_BEAN_KEY);
        if (carrinho == null) {
            try {
                InitialContext ic = new InitialContext();
                carrinho = (CartBeanRemote) ic.lookup("ejb/CartBean");
                httpSession.setAttribute(STATEFUL_BEAN_KEY, carrinho);
            } catch (NamingException e) {
                throw new ServletException(e);
            }
        }
        return carrinho;
    }
}
