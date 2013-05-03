
package controller;

import allshoes.jpa.Departamento;
import allshoes.jpa.facade.DepartamentoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class departamentoController {

    private DepartamentoFacadeRemote departamentoFacade;

    public departamentoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        departamentoFacade = (DepartamentoFacadeRemote) ctx.lookup("ejb/DepartamentoFacade");
    }

    public Departamento find(String nome) {
        return departamentoFacade.find(nome);
    }

    public List<Departamento> findAll() {
        return departamentoFacade.findAll();
    }
}