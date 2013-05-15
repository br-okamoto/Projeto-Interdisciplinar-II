
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
    
    @Override
    public void create(ItemDoPedido itemDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(ItemDoPedido itemDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(ItemDoPedido itemDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ItemDoPedido find(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ItemDoPedido> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ItemDoPedido> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}