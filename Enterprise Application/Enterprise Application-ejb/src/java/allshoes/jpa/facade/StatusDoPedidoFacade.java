
package allshoes.jpa.facade;

import allshoes.jpa.StatusDoPedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/StatusDoPedidoFacade")
public class StatusDoPedidoFacade extends AbstractFacade<StatusDoPedido> implements StatusDoPedidoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusDoPedidoFacade() {
        super(StatusDoPedido.class);
    }
    
    @Override
    public void create(StatusDoPedido statusDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(StatusDoPedido statusDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(StatusDoPedido statusDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public StatusDoPedido find(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<StatusDoPedido> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<StatusDoPedido> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}