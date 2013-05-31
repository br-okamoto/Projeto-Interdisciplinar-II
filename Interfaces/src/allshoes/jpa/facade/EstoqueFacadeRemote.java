
package allshoes.jpa.facade;

import allshoes.jpa.Estoque;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface EstoqueFacadeRemote {
    
    void create(Estoque estoque);

    void edit(Estoque estoque);

    void remove(Estoque estoque);

    List<Estoque> findAll();

    

    int count();
    
}