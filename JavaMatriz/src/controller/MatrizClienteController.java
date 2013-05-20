
package controller;

import allshoes.jpa.Cliente;
import allshoes.jpa.facade.ClienteFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizClienteController {

    private ClienteFacadeRemote clienteFacade;

    public MatrizClienteController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        clienteFacade = (ClienteFacadeRemote) ctx.lookup("ejb/ClienteFacade");
    }

    public void create(Cliente cliente) {
        clienteFacade.create(cliente);
    }
    
    public void edit(Cliente cliente) {
        clienteFacade.edit(cliente);
    }
    
    public void remove(Cliente cliente) {
        clienteFacade.remove(cliente);
    }
    
    public Cliente find(String username){
        return clienteFacade.find(username);
    }
            
            
    public List<Cliente> findAll() {
        return (clienteFacade.findAll());
    }
    
    
}