package allshoes.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ListaDeDesejo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idListaDeDesejo;
    
    /*@OneToMany
    private Produto[] produto;*/
}
