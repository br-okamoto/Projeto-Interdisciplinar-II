package Hibernate;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface contatoRemoto {
    
    void salvar(ContatoAnnotations contato);

    void atualizar(ContatoAnnotations contato);

    void excluir(ContatoAnnotations contato);

    List listar();

    ContatoAnnotations buscar();

   
}
