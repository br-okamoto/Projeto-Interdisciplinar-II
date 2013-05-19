/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.facade;

import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Produto;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;

/**
 *
 * @author Bruno
 */
@Stateful (mappedName="ejb/CartBean")
public class CartBean implements CartBeanRemote{
    
    private ArrayList<ItemDoPedido> itensDoPedido;

    @PostConstruct
    public void initialize() {
        itensDoPedido = new ArrayList();
    }
    
    @Override
    public void addItem(Produto item) {
        boolean existe = false;
        int index = 0;
        for (ItemDoPedido i : itensDoPedido) {
            if (i.getProduto().getIdProduto() == item.getIdProduto()) {
                existe = true;
                index = itensDoPedido.indexOf(i);
            }
        }
        if (existe) {
            int novaQuantidade = itensDoPedido.get(index).getQuantidade()+1;
            itensDoPedido.get(index).setQuantidade(novaQuantidade);
            itensDoPedido.get(index).setSubTotal(itensDoPedido.get(index).getProduto().getPreco() * novaQuantidade);
        } else {
            ItemDoPedido itemDoPedido = new ItemDoPedido();
            itemDoPedido.setProduto(item);
            itemDoPedido.setQuantidade(1);
            itemDoPedido.setSubTotal(itemDoPedido.getProduto().getPreco());
            itensDoPedido.add(itemDoPedido);
        }
        
    }

    @Override
    public void removeItem(Produto item) {
        int quantidade = 0;
        int index = 0;
        for (ItemDoPedido i : itensDoPedido) {
            if (i.getProduto().getIdProduto() == item.getIdProduto()) {
                quantidade = i.getQuantidade();
                index = itensDoPedido.indexOf(i);
            }
        }
        if (quantidade == 1) {   
            removeItemDoPedido(itensDoPedido.get(index));
        } else {
            itensDoPedido.get(index).setQuantidade(quantidade - 1);
            itensDoPedido.get(index).setSubTotal(itensDoPedido.get(index).getQuantidade() * itensDoPedido.get(index).getProduto().getPreco());
        }
    }
    
    @Override
    public void removeItemDoPedido(ItemDoPedido itemDoPedido) {
        itensDoPedido.remove(itemDoPedido);
    }

    @Override
    public Collection getItems() {
        return itensDoPedido;
    }

}
