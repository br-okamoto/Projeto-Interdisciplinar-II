
package controller;

import allshoes.jpa.Funcionario;
import allshoes.jpa.facade.FuncionarioFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class FilialController {

    private FuncionarioFacadeRemote funcionarioFacade;

    public FilialController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        funcionarioFacade = (FuncionarioFacadeRemote) ctx.lookup("ejb/FuncionarioFacade");
    }

    public void create(Funcionario funcionario) {
        funcionarioFacade.create(funcionario);
    }

    public Funcionario find(String username){
        return funcionarioFacade.find(username);
    }
            
            
    public List<Funcionario> findAll() {
        return (funcionarioFacade.findAll());
    }
    
    
}