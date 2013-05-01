
package controller;

import allshoes.jpa.facade.FilialFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import allshoes.jpa.Filial;


public class MatrizFilialController {

    private FilialFacadeRemote filialFacade;

    public MatrizFilialController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        filialFacade = (FilialFacadeRemote) ctx.lookup("ejb/FilialFacade");
    }

    
    public void create (Filial filial) {
        filialFacade.create(filial);
    }
    
    public void edit(Filial filial) {
        filialFacade.edit(filial);
    }

    public void remove(Filial filial) {
        filialFacade.remove(filial);
    }
    

    public Filial find(String nome){
        return filialFacade.find(nome);
    }
            
            
    public List<Filial> findAll() {
        return (filialFacade.findAll());
    }
    
    
}