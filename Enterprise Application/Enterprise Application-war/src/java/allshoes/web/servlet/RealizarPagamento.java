/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.facade.CartBeanRemote;
import allshoes.jpa.Cliente;
import allshoes.jpa.Endereco;
import allshoes.jpa.Estado;
import allshoes.jpa.Filial;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.StatusDoPedido;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.jpa.facade.FilialFacadeRemote;
import allshoes.jpa.facade.ItemDoPedidoFacadeRemote;
import allshoes.jpa.facade.PedidoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author 31145507
 */
public class RealizarPagamento extends HttpServlet {
    
    private static final String STATEFUL_BEAN_KEY = "STATEFUL_BEAN_KEY";

    @EJB
    PedidoFacadeRemote pedidoEjb;
    
    @EJB
    ItemDoPedidoFacadeRemote itemPedidoEjb;
    
    @EJB(mappedName = "ejb/ClienteFacade")
    private ClienteFacadeRemote ejb;
    
    @EJB
    private FilialFacadeRemote filiaEjb;
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
        
        HttpSession session = request.getSession();
        
        String username = null;

        try {
           username = session.getAttribute("username").toString();
        }
        catch (NullPointerException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/Pagamento");
            rd.forward(request, response);
        }
        Cliente cliente = ejb.find(username);
        Endereco enderecoPedido = new Endereco();
        
        if (session.getAttribute("endereco") == null) {
            enderecoPedido.setRua(cliente.getEndereco().getRua());
            enderecoPedido.setNumero(cliente.getEndereco().getNumero());
            enderecoPedido.setComplemento(cliente.getEndereco().getComplemento());
            enderecoPedido.setCep(cliente.getEndereco().getCep());
            enderecoPedido.setBairro(cliente.getEndereco().getBairro());
            enderecoPedido.setCidade(cliente.getEndereco().getCidade());
            enderecoPedido.setEstado(cliente.getEndereco().getEstado());
        } else {
            
            enderecoPedido = (Endereco)session.getAttribute("endereco");
        }
        
        Filial matriz = new Filial();
        matriz = filiaEjb.find("matriz");
        
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(new java.util.Date());
        pedido.setEndereco(enderecoPedido);
        pedido.setFilial(matriz);
        pedido.setStatus(StatusDoPedido.Aberto);
        
       
        
        //INTEGRAÇÃO com a operadora do cartão para realizar a transação - set pagamentoRealizado = true se realizado com sucesso!
        pedido.setPagamentoRealizado(true); 
        
        
        pedido.setStatus(StatusDoPedido.AguardandoMatriz);

        pedidoEjb.create(pedido);
        List<Pedido> ped = pedidoEjb.findAll();
            int idPedido = 0;
            for (Pedido p : ped) {
                if (idPedido < p.getIdPedido()) {
                    idPedido = p.getIdPedido();
                }
            }
        pedido.setIdPedido(idPedido);
        session.setAttribute("pedido", pedido);
        
        CartBeanRemote carrinho = getCartBean(request);

        ArrayList<ItemDoPedido> itens = (ArrayList<ItemDoPedido>)carrinho.getItems();
        for (ItemDoPedido i : itens) {
            i.setPedido(pedido);
            itemPedidoEjb.create(i);
        }
        session.setAttribute("itens", itens);
        
        RequestDispatcher rd = request.getRequestDispatcher("FinalizacaoDoPedido");
        rd.forward(request, response);
            
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
