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
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.filial.idFilial = :idFilial");
        q1.setParameter("idFilial", filial.getIdFilial());
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
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.filial.idFilial = :idFilial AND ep.produto.idProduto = :idproduto");
        q1.setParameter("idFilial", filial.getIdFilial());
        q1.setParameter("idproduto", produto.getIdProduto());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty()) {
            Estoque_Produto ep = new Estoque_Produto();
            ep.setFilial(filial);
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
        Query q1 = em.createQuery("SELECT ep FROM Estoque_Produto ep WHERE ep.filial.idFilial = :idfilial AND ep.produto.idProduto = :idproduto");
        q1.setParameter("idfilial", filial.getIdFilial());
        q1.setParameter("idproduto", produto.getIdProduto());
        List<Estoque_Produto> eps = q1.getResultList();
        if (eps.isEmpty() || eps.get(0).getQuantidade() < quantidade) {
            return false;
        }
        else {
            int novaQuantidade = eps.get(0).getQuantidade() - quantidade;
            if (novaQuantidade > 0) {
                eps.get(0).setQuantidade(novaQuantidade);
                edit(eps.get(0));
            } 
            else {
                remove(eps.get(0));
            }
            return true;
        }        
    }
    
    @Override
    public List<Produto> findAllUnique(){
        Query q1 = em.createQuery("SELECT p FROM Produto p WHERE p.idProduto in (SELECT ep.produto.idProduto FROM Estoque_Produto ep GROUP BY ep.produto.idProduto)");
        List<Produto> ps = q1.getResultList();
        if (ps.isEmpty()) {
            return null;
        }
        else {
            return ps;
        } 
    }
    
    @Override
    public List<Estoque_Produto> findAll() {
        Query q = em.createQuery("SELECT ep FROM Estoque_Produto ep");
        List<Estoque_Produto> ep = q.getResultList();
        if(ep.isEmpty()) {
            return null;
        }
        else {
            return ep;
        }
    }
    
}
