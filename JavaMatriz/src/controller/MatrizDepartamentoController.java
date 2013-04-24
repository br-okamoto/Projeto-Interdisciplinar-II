
package controller;

import allshoes.jpa.facade.DepartamentoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import allshoes.jpa.Departamento;


public class MatrizDepartamentoController {

    private DepartamentoFacadeRemote departamentoFacade;

    public MatrizDepartamentoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        departamentoFacade = (DepartamentoFacadeRemote) ctx.lookup("ejb/DepartamentoFacade");
    }

    
    public void create (Departamento departamento) {
        departamentoFacade.create(departamento);
    }
    
    public void edit(Departamento departamento) {
        departamentoFacade.edit(departamento);
    }

    public void remove(Departamento departamento) {
        departamentoFacade.remove(departamento);
    }
    

    public Departamento find(String nome){
        return departamentoFacade.find(nome);
    }
            
            
    public List<Departamento> findAll() {
        return (departamentoFacade.findAll());
    }
    
    
}