
package controller;

import allshoes.jpa.Usuario;
import allshoes.jpa.facade.UsuarioFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class FilialController {

    private UsuarioFacadeRemote usuarioFacade;

    public FilialController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        usuarioFacade = (UsuarioFacadeRemote) ctx.lookup("ejb/UsuarioFacade");
    }

    public void create(Usuario usuario) {
        usuarioFacade.create(usuario);
    }

    public Usuario find(String username){
        return usuarioFacade.find(username);
    }
            
            
    public List<Usuario> findAll() {
        return (usuarioFacade.findAll());
    }
    
    
}