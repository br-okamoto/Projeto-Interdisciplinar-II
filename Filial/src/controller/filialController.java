
package controller;

import allshoes.jpa.Filial;
import allshoes.jpa.facade.FilialFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class filialController {

    private FilialFacadeRemote filialFacade;

    public filialController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        filialFacade = (FilialFacadeRemote) ctx.lookup("ejb/FilialFacade");
    }

    public void create(Filial filial) {
        filialFacade.create(filial);
    }

    public Filial find(String name){
        return filialFacade.find(name);
    }
    
    public Filial find(int codFilial){
        return filialFacade.find(codFilial);
    }

    public List<Filial> findAll() {
        return (filialFacade.findAll());
    }
    
    
}