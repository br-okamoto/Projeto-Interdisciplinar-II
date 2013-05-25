package allshoes.jpa.facade;

import allshoes.jpa.Cliente;
import allshoes.jpa.ListaDeDesejo;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ListaDeDesejoFacadeRemote {
    
    void create(ListaDeDesejo listaDesejo);

    void edit(ListaDeDesejo listaDesejo);

    void remove(ListaDeDesejo listaDesejo);

    ListaDeDesejo find(Object id);

    List<ListaDeDesejo> findAll();

    List<ListaDeDesejo> findRange(int[] range);

    int count();
    
}