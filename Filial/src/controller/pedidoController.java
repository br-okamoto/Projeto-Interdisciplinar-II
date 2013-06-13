package controller;

import allshoes.jpa.Pedido;
import allshoes.jpa.Funcionario;
import allshoes.jpa.facade.PedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class pedidoController {

    private PedidoFacadeRemote pedidoFacade;

    public pedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        pedidoFacade = (PedidoFacadeRemote) ctx.lookup("ejb/PedidoFacade");
    }

   public void create(Pedido pedido) {
        pedidoFacade.create(pedido);
    }
   
   public void edit(Pedido pedido){
       pedidoFacade.edit(pedido);
   }
  

   public List<Pedido> findAll(){
       return pedidoFacade.findAll();
   }
   
   public Pedido find(Object id){
       return pedidoFacade.find(id);
   }
   
   public Pedido find(int id){
       return pedidoFacade.find(id);
   }
}
