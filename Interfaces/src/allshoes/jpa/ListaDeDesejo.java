package allshoes.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListaDeDesejo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaDeDesejo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    public int getIdListaDeDesejo() {
        return idListaDeDesejo;
    }

    public void setIdListaDeDesejo(int idListaDeDesejo) {
        this.idListaDeDesejo = idListaDeDesejo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
