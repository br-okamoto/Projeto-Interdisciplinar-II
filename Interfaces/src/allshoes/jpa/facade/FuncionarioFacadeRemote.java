/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa.facade;

import allshoes.jpa.Funcionario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface FuncionarioFacadeRemote {
    
    void create(Funcionario funcionario);

    void edit(Funcionario funcionario);

    void remove(Funcionario funcionario);

    Funcionario find(Object id);
    
    Funcionario find(String username);

    List<Funcionario> findAll();

    List<Funcionario> findRange(int[] range);

    int count();
    
}
