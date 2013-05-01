/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa.facade;

import allshoes.jpa.Filial;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface FilialFacadeRemote {
    
    void create(Filial filial);

    void edit(Filial filial);

    void remove(Filial filial);

    Filial find(Object id);
    
    Filial find(String name);

    List<Filial> findAll();

    List<Filial> findRange(int[] range);

    int count();
    
}
