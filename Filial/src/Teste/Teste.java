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
import controller.itemDoPedidoController;
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
        itemDoPedidoController controlaItemDoPedido = new itemDoPedidoController();

        Pedido pedidos = new Pedido();
        ItemDoPedido item = new ItemDoPedido();
        Produto produtos = new Produto();
        Estoque_Produto ep = new Estoque_Produto();
        Estoque estoques = new Estoque();
        
        int idEstoqueProduto = 0;
        int quantidade = 0;
        List <Estoque_Produto> estoqueProduto = controlaEstoque.findAll();
        for(Estoque_Produto estoque : estoqueProduto){
            if((estoque.getProduto().getIdProduto() == 1) && (estoque.getEstoque().getIdEstoque() == 1)){
                idEstoqueProduto = estoque.getIdEstoque_Produto();
                quantidade = estoque.getQuantidade();
            }
        }
        
        estoques.setIdEstoque(1);
        produtos.setIdProduto(1);
        ep.setIdEstoque_Produto(idEstoqueProduto);
        ep.setQuantidade(quantidade - 3);
        ep.setEstoque(estoques);
        ep.setProduto(produtos);
        controlaEstoque.edit(ep);
     
        JOptionPane.showMessageDialog(null, "Item adicionado");
    }
}
