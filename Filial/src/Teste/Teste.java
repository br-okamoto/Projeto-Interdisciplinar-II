package Teste;

import allshoes.jpa.Endereco;
import allshoes.jpa.Estoque;
import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Filial;
import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.Produto;
import allshoes.jpa.StatusDoPedido;
import controller.estoqueController;
import controller.filialController;
import controller.pedidoController;
import controller.produtoController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

public class Teste {

    public static void main(String args[]) throws Exception {

        produtoController controlaProduto = new produtoController();
        estoqueController controlaEstoque = new estoqueController();
        pedidoController controlaPedido = new pedidoController();
        filialController controlaFilial = new filialController();

        Date data = new Date();
        String dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(data);

        Endereco endereco = new Endereco();
        Filial filial = new Filial();
        Produto produto = new Produto();
        Estoque estoque = new Estoque();
        Estoque_Produto ep = new Estoque_Produto();
        Pedido pedido = new Pedido();
        ItemDoPedido item = new ItemDoPedido();
        HistoricoDoPedido historico = new HistoricoDoPedido();

        filial.setIdFilial(1);
        endereco.setIdEndereco(1);

        List<Pedido> ped = controlaPedido.findAll();
        int id = 0;
        for(Pedido p : ped){
            if(id < p.getIdPedido()){
            id = p.getIdPedido();
            }
        }

        JOptionPane.showMessageDialog(null, id);

         pedido.setIdPedido(id + 1);
         pedido.setDataPedido(data);
         pedido.setPagamentoRealizado(true);
         pedido.setStatus(StatusDoPedido.Finalizado);
         pedido.setFilial(filial);

         
         controlaPedido.create(pedido);  
    }
}
