package allshoes.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Estoque_Produto implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque_Produto;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Filial filial;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Produto produto;
    
    private int quantidade;  

    public int getIdEstoque_Produto() {
        return idEstoque_Produto;
    }

    public void setIdEstoque_Produto(int idEstoque_Produto) {
        this.idEstoque_Produto = idEstoque_Produto;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
