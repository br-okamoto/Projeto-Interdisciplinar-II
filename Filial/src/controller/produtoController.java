
package controller;

import allshoes.jpa.Funcionario;
import allshoes.jpa.Produto;
import allshoes.jpa.facade.ProdutoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class produtoController {

    private ProdutoFacadeRemote produtoFacade;

    public produtoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (ProdutoFacadeRemote) ctx.lookup("ejb/ProdutoFacade");
    }

    public void create(Produto produto) {
        produtoFacade.create(produto);
    }

    public List<Produto> find(String username){
        return produtoFacade.find(username);
    }
            
            
    public List<Produto> findAll() {
        return (produtoFacade.findAll());
    }
    
    
}