
package allshoes.jpa.facade;

import allshoes.jpa.ListaDeDesejo;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful(mappedName = "ejb/ListaDeDesejoFacade")
public class ListaDeDesejoFacade extends AbstractFacade<ListaDeDesejo> implements ListaDeDesejoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaDeDesejoFacade() {
        super(ListaDeDesejo.class);
    }

    
}