
package controller;

import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.facade.ItemDoPedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizItemPedidoController {

    private ItemDoPedidoFacadeRemote itemDoPedidoFacade;

    public MatrizItemPedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        itemDoPedidoFacade = (ItemDoPedidoFacadeRemote) ctx.lookup("ejb/ItemDoPedidoFacade");
    }

    public void create(ItemDoPedido itemDoPedido) {
        itemDoPedidoFacade.create(itemDoPedido);
    }
    
    public void edit(ItemDoPedido itemDoPedido) {
        itemDoPedidoFacade.edit(itemDoPedido);
    }
    
    public void remove(ItemDoPedido itemDoPedido) {
        itemDoPedidoFacade.remove(itemDoPedido);
    }
    
    public List<ItemDoPedido> findAll(int idPedido) {
        return (itemDoPedidoFacade.findAll(idPedido));
    }      
            
    public List<ItemDoPedido> findAll() {
        return (itemDoPedidoFacade.findAll());
    }
    
    
}