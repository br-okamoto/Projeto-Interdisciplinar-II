package allshoes.jpa.facade;

import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Filial;
import allshoes.jpa.Produto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EstoqueProdutoFacadeRemote {
    
    void create(Estoque_Produto estoque_produto);

    void edit(Estoque_Produto estoque_produto);

    void remove(Estoque_Produto estoque_produto);
    
    boolean aumentarEstoque(Filial filial, Produto produto, int quantidade);
    
    boolean reduzirEstoque(Filial filial, Produto produto, int quantidade);

    //find todas filiais com um produto em estoque
    List<Estoque_Produto> find(Produto produto);
    
    //find todos produtos em estoque de uma filial
    List<Estoque_Produto> find(Filial filial);
    
    //find estoque de um produto em uma filial
    List<Estoque_Produto> find(Produto produto, Filial filial);

    List<Estoque_Produto> findAll();

    List<Estoque_Produto> findRange(int[] range);

    int count();
    
}
