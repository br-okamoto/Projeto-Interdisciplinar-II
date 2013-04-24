/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa.facade;

import allshoes.jpa.Marca;
import allshoes.jpa.Departamento;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface DepartamentoFacadeRemote {
    
    void create(Departamento departamento);

    void edit(Departamento departamento);

    void remove(Departamento departamento);

    Departamento find(Object id);
    
    Departamento find(String nome);

    List<Departamento> findAll();

    List<Departamento> findRange(int[] range);

    int count();
    
}
