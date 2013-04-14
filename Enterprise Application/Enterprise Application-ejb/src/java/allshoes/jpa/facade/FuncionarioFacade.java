package allshoes.jpa.facade;

import allshoes.jpa.Funcionario;
import allshoes.jpa.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/FuncionarioFacade")
public class FuncionarioFacade extends AbstractFacade<Funcionario> implements FuncionarioFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioFacade() {
        super(Funcionario.class);
    }
    
    @Override
    public Funcionario find(String username) {
        Query q1 = em.createQuery("SELECT f FROM Funcionario f WHERE f.login = :login");
        q1.setParameter("login", username);
        List<Funcionario> funcionarios = q1.getResultList();
        if (funcionarios.isEmpty()) {
            return null;
        }
        else {
            return funcionarios.get(0);
        }
    }
}
