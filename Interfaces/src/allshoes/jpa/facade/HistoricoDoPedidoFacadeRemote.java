
package allshoes.jpa.facade;

import allshoes.jpa.HistoricoDoPedido;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface HistoricoDoPedidoFacadeRemote {
    
    void create(HistoricoDoPedido historicoDoPedido);

    void edit(HistoricoDoPedido historicoDoPedido);

    void remove(HistoricoDoPedido historicoDoPedido);

    HistoricoDoPedido find(Object id);

    List<HistoricoDoPedido> findAll();

    List<HistoricoDoPedido> findRange(int[] range);

    int count();
    
}
