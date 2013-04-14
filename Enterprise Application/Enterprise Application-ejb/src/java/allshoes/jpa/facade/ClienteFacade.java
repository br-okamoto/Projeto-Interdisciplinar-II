package allshoes.jpa.facade;

import allshoes.jpa.Cliente;
import allshoes.jpa.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/ClienteFacade")
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente find(String username) {
        Query q1 = em.createQuery("SELECT c FROM Cliente c WHERE c.login = :login");
        q1.setParameter("login", username);
        List<Cliente> clientes = q1.getResultList();
        if (clientes.isEmpty())
            return null;
        else {
            /*Query q2 = em.createQuery("SELECT e FROM Endereco e WHERE e.pes.idPessoa = :idPes");
            q2.setParameter("idPes", clientes.get(0).getIdPessoa());
            List<Endereco> endereco = q2.getResultList();
            if (endereco.isEmpty()) {
                clientes.get(0).setEndereco(new Endereco());
            } else {
                clientes.get(0).setEndereco(endereco.get(0));
            }*/
            return clientes.get(0);
        }
    }
}
