/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class HistoricoDoPedido implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idHistorico;
    @OneToMany(fetch = FetchType.EAGER)
    private Pedido idPedido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;
    private String observacao;
    @OneToOne(fetch = FetchType.EAGER)
    private StatusDoPedido idStatus;

    public int getIdHistorico() {
        return idHistorico;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public String getObservacao() {
        return observacao;
    }

    public StatusDoPedido getIdStatus() {
        return idStatus;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setIdStatus(StatusDoPedido idStatus) {
        this.idStatus = idStatus;
    }
    
    
}
