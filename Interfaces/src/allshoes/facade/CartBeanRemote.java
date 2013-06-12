package allshoes.facade;

import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Produto;
import java.util.Collection;
import javax.ejb.Remote;


@Remote
public interface CartBeanRemote {
    public void addItem(Produto item);
    public void removeItem(Produto item);
    public void removeItemDoPedido (ItemDoPedido itemDoPedido);
    public Collection getItems();
    public void limpar();
}
