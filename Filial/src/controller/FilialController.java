
package controller;

import exemplo.jpa.Contato;
import exemplo.jpa.facade.ContatoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class FilialController {

    private ContatoFacadeRemote contatoFacade;

    public FilialController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        contatoFacade = (ContatoFacadeRemote) ctx.lookup("ejb/UsuarioFacade");
    }

    public void create(Contato entity) {
        contatoFacade.create(entity);
    }

    public List<Contato> findAll() {
        return (contatoFacade.findAll());
    }
}