/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.web.servlet;

import allshoes.jpa.Cliente;
import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.StatusDoPedido;
import allshoes.jpa.facade.ClienteFacadeRemote;
import allshoes.jpa.facade.FilialFacadeRemote;
import allshoes.jpa.facade.HistoricoDoPedidoFacadeRemote;
import allshoes.jpa.facade.ItemDoPedidoFacadeRemote;
import allshoes.jpa.facade.PedidoFacadeRemote;
import allshoes.web.model.Footer;
import allshoes.web.model.Header;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class DetalheDoPedido extends HttpServlet {
    
    @EJB
    private PedidoFacadeRemote pedidoEjb;
    
    @EJB
    private ItemDoPedidoFacadeRemote itemPedidoEjb;
    
    @EJB
    private ClienteFacadeRemote clienteEjb;
    
    @EJB
    private FilialFacadeRemote filialEjb;
    
    @EJB
    private HistoricoDoPedidoFacadeRemote histEjb;

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
        int idPedido = 0;
        HttpSession session = request.getSession();
        try {
           username = session.getAttribute("username").toString();
           header = new Header(true,"Detalhe do Pedido", username);
        }
        catch (NullPointerException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Login?returnURL=/Enterprise_Application-war/MeusPedidos");
            rd.forward(request, response);
        }
        try {
            idPedido = Integer.parseInt(request.getParameter("idPedido"));
        }
        catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("/Enterprise_Application-war/MeusPedidos");
            rd.forward(request, response);
        }
        Cliente cliente = clienteEjb.find(username);
        Pedido pedido = pedidoEjb.find(idPedido);
        List<HistoricoDoPedido> historico = histEjb.findAllPedido(pedido);
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Detalhe do Pedido</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("<a href='MeusPedidos'>Meus Pedidos</a>");
            out.println(" > ");
            out.println("Detalhe do Pedido");
            out.println("</div>");
            
            out.println("<h2>Informações gerais do pedido</h2>");
            out.println("<table border='0'>");
            out.println("<tr>");
            out.println("<td>Número do Pedido:</td>");
            out.println("<td>"+pedido.getIdPedido()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Status do Pedido:</td>");
            out.println("<td>"+pedido.getStatus()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Data do Pedido:</td>");
            out.println("<td>"+pedido.getDataPedido()+"</td>");
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<h2>Detalhes do Pedido</h2>");
            out.println("<table id='tbCarrinho' border='0' cellpadding='3' cellspacing='3' width='1000'>");
            out.println("<tr>");
            out.println("<th colspan='2' align='left'>Produto</th>");
            out.println("<th colspan='2' align='center'>Quantidade</th>");
            out.println("<th align='center'>Preço</th>");
            out.println("</tr>");
            List<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
            itens = itemPedidoEjb.findAll(idPedido);
            for (ItemDoPedido i : itens) {
                out.println("<tr>");
                out.println("<td width='130' align='left'>");
                out.println("<a href='DetalheDoProduto?cod_produto="+i.getProduto().getCod_produto()+"'><img src='" + request.getContextPath() + "/images/produtos/"+i.getProduto().getCod_produto()+".jpg' alt='' width='120' height='120'/></a>");
                out.println("</td>");
                out.println("<td valign='top'>");
                out.println("<a href='DetalheDoProduto?cod_produto="+i.getProduto().getCod_produto()+"'><h2>"+i.getProduto().getNome()+"</h2></a>");
                out.println("<span><b>Cor:</b> "+i.getProduto().getCor()+"</span><br/>");
                out.println("<span><b>Tamanho:</b> "+i.getProduto().getTamanho()+"</span>");
                out.println("</td>");
                out.println("<td width='50' align='center'>");
                out.println("<span>"+i.getQuantidade()+"</span>");
                out.println("</td>");
                out.println("<td width='50' align='center'>");

                out.println("</td>");
                out.println("<td width='150' align='center'><b>R$ "+i.getSubTotal()+"</b></td>");
                out.println("</tr>");
            }

            out.println("</table>");
            
            out.println("");
            out.println("<h2>Forma de Pagamento</h2>");
            out.println("");
            out.println("<h2>Endereco de Entrega</h2>");
            out.println("<table cellpadding='3' cellspacing='3' border='0' >");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Rua</td>");
            out.println("<td style='width:310px;'>"+pedido.getEndereco().getRua()+"</td>");
            out.println("<td class='lbl_cadastro2'>Número</td>");
            out.println("<td>"+pedido.getEndereco().getNumero()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Complemento</td>");
            out.println("<td colspan='3'>"+pedido.getEndereco().getComplemento()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>CEP</td>");
            out.println("<td colspan='3'>"+pedido.getEndereco().getCep()+"</td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Bairro</td>");
            out.println("<td colspan='3'>"+pedido.getEndereco().getBairro()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Cidade</td>");
            out.println("<td colspan='3'>"+pedido.getEndereco().getCidade()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='lbl_cadastro'>Estado</td>");
            out.println("<td colspan='3'>");
            out.println(pedido.getEndereco().getEstado());
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("");
            
            out.println("<h2>Histórico do Pedido</h2>");
            out.println("<table border='0' cellpadding='3' cellspacing='3'>");
            out.println("<tr>");
            out.println("<td width='230px'>Data</td>");
            out.println("<td width='400px'>Status</td>");
            out.println("</tr>");
            if (historico != null) {
                for (HistoricoDoPedido h : historico) {
                    out.println("<tr>");
                    out.println("<td>"+h.getDataPedido()+"</td>");
                    out.println("<td>"+h.getStatus().toString()+"</td>");
                    out.println("</tr>");
                }
            }
            out.println("</table>");
            
            out.println("<div>&nbsp;</div>");
            out.println("<div>&nbsp;</div>");
            
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
