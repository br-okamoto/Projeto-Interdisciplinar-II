
package controller;

import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.facade.HistoricoDoPedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizHistoricoPedidoController {

    private HistoricoDoPedidoFacadeRemote historicoDoPedidoFacade;

    public MatrizHistoricoPedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        historicoDoPedidoFacade = (HistoricoDoPedidoFacadeRemote) ctx.lookup("ejb/HistoricoDoPedidoFacade");
    }

    public void create(HistoricoDoPedido historicoDoPedido) {
        historicoDoPedidoFacade.create(historicoDoPedido);
    }
    
    public void edit(HistoricoDoPedido historicoDoPedido) {
        historicoDoPedidoFacade.edit(historicoDoPedido);
    }
    
    public void remove(HistoricoDoPedido historicoDoPedido) {
        historicoDoPedidoFacade.remove(historicoDoPedido);
    }
    
    public List<HistoricoDoPedido> findAll() {
        return (historicoDoPedidoFacade.findAll());
    }      
    
    
}