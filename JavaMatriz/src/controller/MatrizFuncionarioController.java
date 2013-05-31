
package controller;

import allshoes.jpa.Funcionario;
import allshoes.jpa.facade.FuncionarioFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizFuncionarioController {

    private FuncionarioFacadeRemote funcionarioFacade;

    public MatrizFuncionarioController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        funcionarioFacade = (FuncionarioFacadeRemote) ctx.lookup("ejb/FuncionarioFacade");
    }

    public void create(Funcionario funcionario) {
        funcionarioFacade.create(funcionario);
    }
    
    public void edit(Funcionario funcionario) {
        funcionarioFacade.edit(funcionario);
    }
    
    public void remove(Funcionario funcionario) {
        funcionarioFacade.remove(funcionario);
    }
    
    public Funcionario find(String username){
        return funcionarioFacade.find(username);
    }
            
            
    public List<Funcionario> findAll() {
        return (funcionarioFacade.findAll());
    }
    
    
}