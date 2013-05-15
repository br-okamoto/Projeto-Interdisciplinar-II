
package allshoes.jpa.facade;

import allshoes.jpa.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/PedidoFacade")
public class PedidoFacade extends AbstractFacade<Pedido> implements PedidoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    @Override
    public void create(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pedido find(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pedido> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Pedido> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}