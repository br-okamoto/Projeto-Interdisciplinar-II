package allshoes.jpa.facade;

import allshoes.jpa.Marca;
import allshoes.jpa.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/DepartamentoFacade")
public class DepartamentoFacade extends AbstractFacade<Departamento> implements DepartamentoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    public Departamento find(String nome) {
        Query q1 = em.createQuery("SELECT p FROM Departamento p WHERE UPPER(p.nomeDepartamento) LIKE :nome");
        q1.setParameter("nome", nome.toUpperCase());
        List<Departamento> departamentos = q1.getResultList();
        if (departamentos.isEmpty())
            return null;
        else
            return departamentos.get(0);
    }
    
}
