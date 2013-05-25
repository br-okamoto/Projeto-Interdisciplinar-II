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
 * @author Bruno
 */
public class FinalizacaoDoPedido extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        Header header = new Header(false, "Finalização do Pedido");
        Footer footer = new Footer(false);
        
        HttpSession session = request.getSession();
        
        Pedido pedido = (Pedido)session.getAttribute("pedido");
        
        
        
        try {

            out.println(header.getHeaderPadrao());
            
            out.println("<div id='contentSemMenu'>");
            out.println("<h1>Finalização do Pedido</h1>");
            out.println("<div id='breadcrumb'>Você está em: ");
            out.println("<a href='" + request.getContextPath() + "'>Home</a>");
            out.println(" > ");
            out.println("<a href='" + request.getContextPath() + "/MeuCarrinho'>Meu Carrinho</a>");
            out.println(" > ");
            out.println("<a href='" + request.getContextPath() + "/Pagamento'>Pagamento</a>");
            out.println(" > ");
            out.println("Finalização do Pedido");
            out.println("</div>");
            
            out.println("<h1>Pedido Realizado</h1>");
            out.println("<h2>Informações gerais do pedido</h2>");
            out.println("<table border='0'>");
            out.println("<tr>");
            out.println("<td>Número do Pedido:</td>");
            out.println("<td>"+pedido.getIdPedido()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Status do Pedido:</td>");
            String statusPedido = pedido.getStatus() == StatusDoPedido.AguardandoPagamento ? "Aguardando Pagamento" : "Processando pedido";
            out.println("<td>"+statusPedido+"</td>");
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
            itens = (ArrayList<ItemDoPedido>)session.getAttribute("itens");
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
