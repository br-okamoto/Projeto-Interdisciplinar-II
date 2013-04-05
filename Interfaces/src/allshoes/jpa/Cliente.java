/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author 31145507
 */
@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Cliente extends Usuario {
    @OneToOne
    private Endereco enderecoPrincipal;
    @OneToOne
    private ListaDeDesejo listaDeDesejo;
}
