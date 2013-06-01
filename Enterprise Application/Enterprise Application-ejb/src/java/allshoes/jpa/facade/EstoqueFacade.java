package allshoes.jpa.facade;

import allshoes.jpa.Estoque;
import allshoes.jpa.Endereco;
import allshoes.jpa.Filial;
import allshoes.jpa.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/EstoqueFacade")
public class EstoqueFacade extends AbstractFacade<Estoque> implements EstoqueFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueFacade() {
        super(Estoque.class);
    }
    
    
    
}
