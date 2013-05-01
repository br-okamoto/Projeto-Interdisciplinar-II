package allshoes.jpa.facade;

import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Endereco;
import allshoes.jpa.Filial;
import allshoes.jpa.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/Estoque_ProdutoFacade")
public class EstoqueProdutoFacade extends AbstractFacade<Estoque_Produto> implements EstoqueProdutoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueProdutoFacade() {
        super(Estoque_Produto.class);
    }
    
    @Override
    public List<Estoque_Produto> find(Produto produto){
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.produto.idProduto = :idproduto");
        q1.setParameter("idproduto", produto.getIdProduto());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty()) {
            return null;
        }
        else {
            return eps;
        }
    }
    
    @Override
    public List<Estoque_Produto> find(Filial filial){
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.estoque.idEstoque = :idestoque");
        q1.setParameter("idestoque", filial.getEstoque().getIdEstoque());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty()) {
            return null;
        }
        else {
            return eps;
        }
    }
    
    @Override
    public List<Estoque_Produto> find(Produto produto, Filial filial){
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.estoque.idEstoque = :idestoque AND ep.produto.idProduto = :idproduto");
        q1.setParameter("idestoque", filial.getEstoque().getIdEstoque());
        q1.setParameter("idproduto", produto.getIdProduto());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty()) {
            return null;
        }
        else {
            return eps;
        }
    }
    
    @Override
    public boolean aumentarEstoque(Filial filial, Produto produto, int quantidade){
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.estoque.idEstoque = :idestoque AND ep.produto.idProduto = :idproduto");
        q1.setParameter("idestoque", filial.getEstoque().getIdEstoque());
        q1.setParameter("idproduto", produto.getIdProduto());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty()) {
            Estoque_Produto ep = new Estoque_Produto();
            ep.setEstoque(filial.getEstoque());
            ep.setProduto(produto);
            ep.setQuantidade(quantidade);
            create(ep);
            return true;
        }
        else {
            int novaQuantidade = eps.get(0).getQuantidade() + quantidade;
            eps.get(0).setQuantidade(novaQuantidade);
            edit(eps.get(0));
            return true;
        }
    }
    
    @Override
    public boolean reduzirEstoque(Filial filial, Produto produto, int quantidade){
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.estoque.idEstoque = :idestoque AND ep.produto.idProduto = :idproduto");
        q1.setParameter("idestoque", filial.getEstoque().getIdEstoque());
        q1.setParameter("idproduto", produto.getIdProduto());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty() || eps.get(0).getQuantidade() < quantidade) {
            return false;
        }
        else {
            int novaQuantidade = eps.get(0).getQuantidade() - quantidade;
            eps.get(0).setQuantidade(novaQuantidade);
            edit(eps.get(0));
            return true;
        }        
    }
}
