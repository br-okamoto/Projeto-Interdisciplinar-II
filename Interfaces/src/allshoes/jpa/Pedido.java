package allshoes.jpa;

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
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente idCliente;
    @OneToOne(fetch = FetchType.EAGER)
    private Endereco idEndereco;
    @ManyToOne(fetch = FetchType.EAGER)
    private Filial idFilial;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public Filial getIdFilial() {
        return idFilial;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    public void setIdFilial(Filial idFilial) {
        this.idFilial = idFilial;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    
    
    
}
