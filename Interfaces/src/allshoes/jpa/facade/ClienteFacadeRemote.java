/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa.facade;

import allshoes.jpa.Cliente;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface ClienteFacadeRemote {
    
    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);
    
    Cliente find(String username);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    int count();
    
}
