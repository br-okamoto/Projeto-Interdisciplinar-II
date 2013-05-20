
package allshoes.jpa.facade;

import allshoes.jpa.ItemDoPedido;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface ItemDoPedidoFacadeRemote {
    
    void create(ItemDoPedido itemDoPedido);

    void edit(ItemDoPedido itemDoPedido);

    void remove(ItemDoPedido itemDoPedido);

    ItemDoPedido find(Object id);

    List<ItemDoPedido> findAll();
    
    List<ItemDoPedido> findAll(int idPedido);

    List<ItemDoPedido> findRange(int[] range);

    int count();
    
}