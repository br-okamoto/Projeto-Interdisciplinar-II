package allshoes.jpa.facade;

import allshoes.jpa.StatusDoPedido;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface StatusDoPedidoFacadeRemote {
    
    void create(StatusDoPedido  statusDoPedido);

    void edit(StatusDoPedido statusDoPedido);

    void remove(StatusDoPedido statusDoPedido);

    StatusDoPedido find(Object id);

    List<StatusDoPedido> findAll();

    List<StatusDoPedido> findRange(int[] range);

    int count();
    
}