package allshoes.jpa.facade;

import allshoes.jpa.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/UsuarioFacade")
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario find(String username) {
        Query q1 = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
        q1.setParameter("login", username);
        List<Usuario> usuarios = q1.getResultList();
        if (usuarios.isEmpty())
            return null;
        else
            return usuarios.get(0);
    }
}
