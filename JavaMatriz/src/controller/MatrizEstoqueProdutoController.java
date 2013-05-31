
package controller;

import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Filial;
import allshoes.jpa.Produto;
import allshoes.jpa.facade.EstoqueProdutoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizEstoqueProdutoController {

    private EstoqueProdutoFacadeRemote estoqueFacade;

    public MatrizEstoqueProdutoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        estoqueFacade = (EstoqueProdutoFacadeRemote) ctx.lookup("ejb/Estoque_ProdutoFacade");
    }

    public void create(Estoque_Produto estoque_produto) {
        estoqueFacade.create(estoque_produto);
    }
    
    public void edit(Estoque_Produto estoque_produto) {
        estoqueFacade.edit(estoque_produto);
    } 

    public List<Estoque_Produto> find(Produto produto){
        return estoqueFacade.find(produto);
    }
          
    public List <Estoque_Produto> find(Filial filial) {
        return estoqueFacade.find(filial);
    }
    
    List<Estoque_Produto> find(Produto produto, Filial filial){
        return estoqueFacade.find(produto, filial);
    }
    
    public boolean aumentarEstoque(Filial filial, Produto produto, int quantidade){
        return estoqueFacade.aumentarEstoque(filial, produto, quantidade);
    }
    
    public boolean reduzirEstoque(Filial filial, Produto produto, int quantidade){
        return estoqueFacade.reduzirEstoque(filial, produto, quantidade);
    }
    
    public List<Estoque_Produto> findAll(){
        return estoqueFacade.findAll();
    }
            
}