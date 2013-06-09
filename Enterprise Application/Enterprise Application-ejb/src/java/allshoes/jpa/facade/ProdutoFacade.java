package allshoes.jpa.facade;

import allshoes.jpa.Marca;
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
    
    public Produto find(int cod_produto) {
        Query q1 = em.createQuery("SELECT p FROM Produto p WHERE p.cod_produto = :cod_produto");
        q1.setParameter("cod_produto", cod_produto);
        List<Produto> produtos = q1.getResultList();
        if (produtos.isEmpty())
            return null;
        else
            return produtos.get(0);
    }
    
    public List<Produto> find(String nome) {
        Query q1 = em.createQuery("SELECT p FROM Produto p WHERE UPPER(p.nome) LIKE :nome");
        q1.setParameter("nome", nome.toUpperCase());
        List<Produto> produtos = q1.getResultList();
        if (produtos.isEmpty())
            return null;
        else
            return produtos;
    }
    
    public List<Produto> find(Marca marca) {
        Query q1 = em.createQuery("SELECT p FROM Produto p WHERE p.marca = :marca");
        q1.setParameter("marca", marca.toString());
        List<Produto> produtos = q1.getResultList();
        if (produtos.isEmpty())
            return null;
        else
            return produtos;
    }
    
    @Override
    public List<Produto> busca(String termo) {
        Query q1 = em.createQuery("SELECT p FROM Produto p WHERE lower(p.nome) LIKE :nome OR lower(p.marca) LIKE :marca OR lower(p.descricao) LIKE :descricao");
        q1.setParameter("nome", "%"+termo.toLowerCase()+"%");
        q1.setParameter("marca", "%"+termo.toLowerCase()+"%");
        q1.setParameter("descricao", "%"+termo.toLowerCase()+"%");
        List<Produto> produtos = q1.getResultList();
        if (produtos.isEmpty())
            return null;
        else
            return produtos;
    }
}
