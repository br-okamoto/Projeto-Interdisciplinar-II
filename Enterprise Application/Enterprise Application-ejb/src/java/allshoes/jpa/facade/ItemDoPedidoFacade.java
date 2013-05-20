
package allshoes.jpa.facade;

import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public List<ItemDoPedido> findAll(int idPedido) {
        Query q1 = em.createQuery("SELECT i FROM ItemDoPedido i WHERE i.pedido.idPedido = :idPedido");
        q1.setParameter("idPedido", idPedido);
        List<ItemDoPedido> is = q1.getResultList();
        if (is.isEmpty()) {
            return null;
        }
        else {
            return is;
        }
    }
    
    
}