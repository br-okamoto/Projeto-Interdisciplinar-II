/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa.facade;

import allshoes.jpa.Produto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface ProdutoFacadeRemote {
    
    void create(Produto produto);

    void edit(Produto produto);

    void remove(Produto produto);

    Produto find(Object id);
    
    Produto find(String username);

    List<Produto> findAll();

    List<Produto> findRange(int[] range);

    int count();
    
}
