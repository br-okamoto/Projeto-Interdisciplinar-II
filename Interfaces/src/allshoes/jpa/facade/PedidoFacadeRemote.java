package allshoes.jpa.facade;

import allshoes.jpa.Pedido;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoFacadeRemote {
    
    void create(Pedido pedido);

    void edit(Pedido pedido);

    void remove(Pedido pedido);

    Pedido find(Object id);

    List<Pedido> findAll();

    List<Pedido> findRange(int[] range);

    int count();
    
}