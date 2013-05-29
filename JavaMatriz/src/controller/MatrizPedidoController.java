
package controller;

import allshoes.jpa.Pedido;
import allshoes.jpa.facade.PedidoFacadeRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;


public class MatrizPedidoController {

    private PedidoFacadeRemote pedidoFacade;

    public MatrizPedidoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        pedidoFacade = (PedidoFacadeRemote) ctx.lookup("ejb/PedidoFacade");
    }

    public void create(Pedido pedido) {
        pedidoFacade.create(pedido);
    }
    
    public void edit(Pedido pedido) {
        pedidoFacade.edit(pedido);
    }
    
    public void remove(Pedido pedido) {
        pedidoFacade.remove(pedido);
    }
    
    public Pedido find(Object id){
        return pedidoFacade.find(id);
    }
    
    public Pedido find(int idPedido) {
        return pedidoFacade.find(idPedido);
    }
            
            
    public List<Pedido> findAll() {
        return (pedidoFacade.findAll());
    }
    
    
}