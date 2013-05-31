package allshoes.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estoque implements Serializable, Cloneable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;
    
    private String observacao;

    public Estoque(){
    
    }
    
    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
    
}
