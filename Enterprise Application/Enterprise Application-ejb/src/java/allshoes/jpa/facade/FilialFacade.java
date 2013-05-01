package allshoes.jpa.facade;

import allshoes.jpa.Filial;
import allshoes.jpa.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/FilialFacade")
public class FilialFacade extends AbstractFacade<Filial> implements FilialFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilialFacade() {
        super(Filial.class);
    }
    
    @Override
    public Filial find(String nome) {
        Query q1 = em.createQuery("SELECT c FROM Filial c WHERE c.login = :login");
        q1.setParameter("login", nome);
        List<Filial> filials = q1.getResultList();
        if (filials.isEmpty()) {
            return null;
        }
        else {
            return filials.get(0);
        }
    }
}
