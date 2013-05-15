
package allshoes.jpa.facade;

import allshoes.jpa.HistoricoDoPedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/HistoricoDoPedidoFacade")
public class HistoricoDoPedidoFacade extends AbstractFacade<HistoricoDoPedido> implements HistoricoDoPedidoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoDoPedidoFacade() {
        super(HistoricoDoPedido.class);
    }

    @Override
    public void create(HistoricoDoPedido historicoDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(HistoricoDoPedido historicoDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(HistoricoDoPedido historicoDoPedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HistoricoDoPedido find(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<HistoricoDoPedido> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<HistoricoDoPedido> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


   
}
