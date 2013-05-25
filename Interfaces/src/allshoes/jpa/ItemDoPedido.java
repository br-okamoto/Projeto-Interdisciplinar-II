package allshoes.jpa;

import allshoes.jpa.Cliente;
import allshoes.jpa.Endereco;
import allshoes.jpa.Filial;
import allshoes.jpa.Pedido;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class ItemDoPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemDoPedido;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Pedido pedido;
    
    private int quantidade;
    private double subTotal;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Produto produto;

    public int getIdItemDoPedido() {
        return idItemDoPedido;
    }

    public void setIdItemDoPedido(int idItemDoPedido) {
        this.idItemDoPedido = idItemDoPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    
    
}