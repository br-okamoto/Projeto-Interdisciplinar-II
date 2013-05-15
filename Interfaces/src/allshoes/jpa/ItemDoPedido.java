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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItemDoPedido;
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido idPedido;
    private int quantidade;
    private double subTotal;

    public int getIdItemDoPedido() {
        return idItemDoPedido;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setIdItemDoPedido(int idItemDoPedido) {
        this.idItemDoPedido = idItemDoPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
}