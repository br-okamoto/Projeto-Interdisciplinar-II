
package controller;

import allshoes.jpa.facade.ProdutoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import allshoes.jpa.Produto;


public class MatrizProdutoController {

    private ProdutoFacadeRemote produtoFacade;

    public MatrizProdutoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ProdutoFacadeRemote) ctx.lookup("ejb/ProdutoFacade");
    }

    
    public void create (Produto produto) {
        produtoFacade.create(produto);
    }
    
    public void edit(Produto produto) {
        produtoFacade.edit(produto);
    }

    public void remove(Produto produto) {
        produtoFacade.remove(produto);
    }
    

    public List<Produto> find(String nome){
        return produtoFacade.find(nome);
    }
            
            
    public List<Produto> findAll() {
        return (produtoFacade.findAll());
    }
    
    
}