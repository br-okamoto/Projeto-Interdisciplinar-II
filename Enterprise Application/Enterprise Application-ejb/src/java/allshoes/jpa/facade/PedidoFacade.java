
package allshoes.jpa.facade;

import allshoes.jpa.Pedido;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    
}