
package allshoes.jpa.facade;

import allshoes.jpa.HistoricoDoPedido;
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

}
