
package controller;

import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.facade.HistoricoDoPedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class historicoDoPedidoController {
    private HistoricoDoPedidoFacadeRemote historicoDoPedidoFacade;

    public historicoDoPedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        historicoDoPedidoFacade = (HistoricoDoPedidoFacadeRemote) ctx.lookup("ejb/HistoricoDoPedidoFacade");
    }
    
    public void create(HistoricoDoPedido historicoDoPedido) {
        historicoDoPedidoFacade.create(historicoDoPedido);
    }
   
   public void edit(HistoricoDoPedido historicoDoPedido){
       historicoDoPedidoFacade.edit(historicoDoPedido);
   }
  
   public List<HistoricoDoPedido> findAll(){
       return historicoDoPedidoFacade.findAll();
   }
   
   public HistoricoDoPedido find(Object id){
       return historicoDoPedidoFacade.find(id);
   }
}
