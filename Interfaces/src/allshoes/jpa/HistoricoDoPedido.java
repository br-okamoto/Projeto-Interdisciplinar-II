/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorico;
    @OneToOne(fetch = FetchType.EAGER)
    private Pedido pedido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;
    private String observacao;
    @Enumerated (EnumType.STRING)
    private StatusDoPedido status;

    public int getIdHistorico() {
        return idHistorico;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public String getObservacao() {
        return observacao;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }
    
    
    
}
