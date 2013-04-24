package allshoes.jpa;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Filial implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFilial;
    
    private String nome;
    private int cod_filial;
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private Estoque estoque;
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private Endereco endereco;

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_filial() {
        return cod_filial;
    }

    public void setCod_filial(int cod_filial) {
        this.cod_filial = cod_filial;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
