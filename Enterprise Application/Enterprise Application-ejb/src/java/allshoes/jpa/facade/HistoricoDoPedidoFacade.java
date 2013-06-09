
package allshoes.jpa.facade;

import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public List<HistoricoDoPedido> findAllPedido(Pedido pedido) {
        Query q1 = em.createQuery("SELECT h FROM HistoricoDoPedido h WHERE h.pedido.idPedido = :idPedido");
        q1.setParameter("idPedido", pedido.getIdPedido());
        List<HistoricoDoPedido> historicos = q1.getResultList();
        if (historicos.isEmpty()) {
            return null;
        }
        else {
            return historicos;
        }
    }

}
