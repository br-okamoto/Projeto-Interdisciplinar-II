package Teste;

import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Produto;
import controller.estoqueController;
import controller.produtoController;
import java.util.List;

public class Teste {

    public static void main(String args[]) throws Exception {


        estoqueController estoque = new estoqueController();
        produtoController prod = new produtoController();

        List<Produto> produtos = prod.findName("tenis");
        List<Estoque_Produto> ep = estoque.findAll();
        
                
        for (Produto p : produtos) {
            System.out.println(p.getCod_produto() + " " + p.getDescricao());
            
        }




    }
}
