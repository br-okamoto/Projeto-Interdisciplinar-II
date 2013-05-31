
package controller;

import allshoes.jpa.Estoque;
import allshoes.jpa.facade.EstoqueFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizEstoqueController {

    private EstoqueFacadeRemote estoqueFacade;

    public MatrizEstoqueController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        estoqueFacade = (EstoqueFacadeRemote) ctx.lookup("ejb/EstoqueFacade");
    }

    public void create(Estoque estoque) {
        estoqueFacade.create(estoque);
    }
    
    public void edit(Estoque estoque) {
        estoqueFacade.edit(estoque);
    }
    
    public void remove(Estoque estoque) {
        estoqueFacade.remove(estoque);
    }
    
    
            
            
    public List<Estoque> findAll() {
        return (estoqueFacade.findAll());
    }
    
    
}