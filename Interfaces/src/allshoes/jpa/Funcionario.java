/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author 31145507
 */
@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Funcionario extends Usuario {
    
    private int funcional;
    private LocalDeTrabalho localDeTrabalho;
    
}
