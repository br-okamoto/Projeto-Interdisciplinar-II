package Teste;

import allshoes.jpa.Endereco;
import allshoes.jpa.Estoque;
import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Filial;
import allshoes.jpa.Funcionario;
import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.Produto;
import allshoes.jpa.StatusDoPedido;
import controller.estoqueController;
import controller.filialController;
import controller.funcionarioController;
import controller.historicoDoPedidoController;
import controller.itemDoPedidoController;
import controller.pedidoController;
import controller.produtoController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class Teste {

    public static void main(String args[]) throws Exception {

        funcionarioController controlaFuncionario = new funcionarioController();
        produtoController controlaProduto = new produtoController();
        estoqueController controlaEstoque = new estoqueController();
        pedidoController controlaPedido = new pedidoController();
        filialController controlaFilial = new filialController();
        itemDoPedidoController controlaItemDoPedido = new itemDoPedidoController();
        historicoDoPedidoController controlaHistoricoDoPedido = new historicoDoPedidoController();

        Pedido pedidos = new Pedido();
        ItemDoPedido item = new ItemDoPedido();
        Produto produtos = new Produto();
        Estoque_Produto ep = new Estoque_Produto();
        Estoque estoques = new Estoque();
        Produto produto = new Produto();
        Filial filial = new Filial();
        Estoque_Produto estoqueProduto = new Estoque_Produto();
        Estoque estoque = new Estoque();
        
        
        List<Funcionario> func = controlaFuncionario.findAll();
        
        JOptionPane.showMessageDialog(null, controlaFuncionario.find("funcionario"));
         
       
     
        }
    }

