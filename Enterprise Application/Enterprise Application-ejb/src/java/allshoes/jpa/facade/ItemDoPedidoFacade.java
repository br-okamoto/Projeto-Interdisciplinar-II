
package allshoes.jpa.facade;

import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/ItemDoPedidoFacade")
public class ItemDoPedidoFacade extends AbstractFacade<ItemDoPedido> implements ItemDoPedidoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemDoPedidoFacade() {
        super(ItemDoPedido.class);
    }
    
    
}