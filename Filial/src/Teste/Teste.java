package Teste;

import allshoes.jpa.Estoque_Produto;
import controller.estoqueController;
import java.util.List;

public class Teste {

    public static void main(String args[]) throws Exception {
       
        
       estoqueController estoque = new estoqueController();
       
    
       
       List<Estoque_Produto> e = estoque.findAll();
       for(Estoque_Produto est : e){
       System.out.println(" CodProd " + est.getProduto().getNome() + " Qtd " + est.getQuantidade());
        
       
       
       }
    
    }
}
