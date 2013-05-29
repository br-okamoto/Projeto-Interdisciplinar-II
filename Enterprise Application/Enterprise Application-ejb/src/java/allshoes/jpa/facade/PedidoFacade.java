
package allshoes.jpa.facade;

import allshoes.jpa.Pedido;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful(mappedName = "ejb/PedidoFacade")
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
    public Pedido find(int idPedido) {
        Query q1 = em.createQuery("SELECT p FROM Pedido p WHERE p.idPedido = :idPedido");
        q1.setParameter("idPedido", idPedido);
        List<Pedido> pedidos = q1.getResultList();
        if (pedidos.isEmpty()) {
            return null;
        }
        else {
            return pedidos.get(0);
        }
    }
}