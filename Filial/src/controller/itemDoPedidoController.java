package controller;

import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.facade.ItemDoPedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class itemDoPedidoController {

    private ItemDoPedidoFacadeRemote itemDoPedidoFacade;

    public itemDoPedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        itemDoPedidoFacade = (ItemDoPedidoFacadeRemote) ctx.lookup("ejb/ItemDoPedidoFacade");
    }

   public void create(ItemDoPedido itemDoPedido) {
        itemDoPedidoFacade.create(itemDoPedido);
    }
   
   public void edit(ItemDoPedido itemDoPedido){
       itemDoPedidoFacade.edit(itemDoPedido);
   }
  

   public List<ItemDoPedido> findAll(){
       return itemDoPedidoFacade.findAll();
   }
   
   public List<ItemDoPedido> findAll(int idPedido){
       return itemDoPedidoFacade.findAll(idPedido);
   }
   
   public ItemDoPedido find(Object id){
       return itemDoPedidoFacade.find(id);
   }
}
