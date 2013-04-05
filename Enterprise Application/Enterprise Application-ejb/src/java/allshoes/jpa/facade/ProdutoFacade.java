package allshoes.jpa.facade;

import allshoes.jpa.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/ProdutoFacade")
public class ProdutoFacade extends AbstractFacade<Produto> implements ProdutoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }
    
    public Produto find(String username) {
        Query q1 = em.createQuery("SELECT c FROM Produto c JOIN Usuario u WHERE c.idPessoa = u.idPEssoa AND u.login = :login");
        q1.setParameter("login", username);
        List<Produto> produtos = q1.getResultList();
        if (produtos.isEmpty())
            return null;
        else
            return produtos.get(0);
    }
}
