package Filial;

import Validacao.IntegerDocument;
import Validacao.teclasPermitidas;
import allshoes.jpa.Estoque;
import allshoes.jpa.Estoque_Produto;
import controller.filialController;
import controller.funcionarioController;
import allshoes.jpa.Filial;
import allshoes.jpa.Funcionario;
import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import allshoes.jpa.Pedido;
import allshoes.jpa.Produto;
import allshoes.jpa.StatusDoPedido;
import controller.estoqueController;
import controller.historicoDoPedidoController;
import controller.itemDoPedidoController;
import controller.pedidoController;
import controller.produtoController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaVenda extends javax.swing.JFrame {

    static double valorTotal;

    public TelaVenda() {
        initComponents();
        filialController controlaFilial = null;
        funcionarioController controlaFuncionario = null;
        estoqueController controlaEstoque = null;
        pedidoController controlaPedido = null;

        //Campo aceita apenas números com 4 dígitos
        jTextField1.setDocument(new IntegerDocument(4));

        try {
            controlaFilial = new filialController();
            List<Filial> filiais = controlaFilial.findAll();
            for (Filial f : filiais) {
                jComboBox1.addItem(f.getIdFilial() + " - " + f.getNome());
            }
            controlaFuncionario = new funcionarioController();
            List<Funcionario> funcionario = controlaFuncionario.findAll();
            for (Funcionario func : funcionario) {
                jComboBox2.addItem(func.getNome());
            }

            //Campo número da venda
            controlaPedido = new pedidoController();
            List<Pedido> p = controlaPedido.findAll();

        } catch (Exception ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Cor", "Tamanho", "Quantidade", "Preço Unit.", "Preço Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Venda de Balcao");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel2)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setText("Loja:");

        jLabel6.setText("Vendedor:");

        jLabel9.setText("Quantidade:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a Loja" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Vendedor" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 63, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        jLabel1.setText("Código do Produto:");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Finalizar Compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Qtd", "1", "2", "3", "4", "5" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Preço Total: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    //Botão Adicionar Compras
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            produtoController controlaProduto = new produtoController();
            int codigo = Integer.parseInt(jTextField1.getText());
            Produto prod = controlaProduto.find(codigo);

            //checa loja
            if (jComboBox1.getSelectedItem().equals("Selecione a Loja")) {
                JOptionPane.showMessageDialog(null, "Selecione a Loja");
            }
            //checa vendedor
            if (jComboBox2.getSelectedItem().equals("Selecione o Vendedor")) {
                JOptionPane.showMessageDialog(null, "Selecione o Vendedor");
            }

            //checa quantidade
            if (jComboBox3.getSelectedItem().equals("Qtd")) {
                JOptionPane.showMessageDialog(null, "Selecione a Quantidade");
            }

            double subTotal = 0;
            double total = prod.getPreco();
            int qtd = Integer.valueOf((String) jComboBox3.getSelectedItem());
            subTotal = total * qtd;
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            Object[] objects = new Object[7];
            objects[0] = prod.getCod_produto();
            objects[1] = prod.getNome();
            objects[2] = prod.getCor();
            objects[3] = prod.getTamanho();
            objects[4] = jComboBox3.getSelectedItem();
            objects[5] = prod.getPreco();
            objects[6] = subTotal;
            dtm.addRow(objects);
            jTable1.setModel(dtm);

            valorTotal = valorTotal + subTotal;
            jLabel7.setText(String.valueOf(valorTotal));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: Produto não localizado");
            Logger.getLogger(TelaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    //Finaliza Compras
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            pedidoController controlaPedido = new pedidoController();
            produtoController controlaProduto = new produtoController();
            itemDoPedidoController controlaItemDoPedido = new itemDoPedidoController();
            historicoDoPedidoController controlaHistoricoDoPedido = new historicoDoPedidoController();
            estoqueController controlaEstoque = new estoqueController();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            Pedido pedidos = new Pedido();
            Filial filial = new Filial();
            Produto produtos = new Produto();
            ItemDoPedido item = new ItemDoPedido();
            HistoricoDoPedido historico = new HistoricoDoPedido();
            Estoque estoques = new Estoque();
            Estoque_Produto estoqueProduto = new Estoque_Produto();
            Date data = new Date();
            //String dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(data);

            //Pega id da Filial no jComboBox
            String nomeFilial = (String) jComboBox1.getSelectedItem();
            char letra = nomeFilial.charAt(0);
            int idFilial = Integer.parseInt(String.valueOf(letra));

            int totalLinhas = jTable1.getModel().getRowCount();
            Object[] objects = new Object[7];

             //Adiciona dados na tabela Pedido
             filial.setIdFilial(idFilial);
             pedidos.setDataPedido(data);
             pedidos.setPagamentoRealizado(true);
             pedidos.setStatus(StatusDoPedido.Finalizado);
             pedidos.setFilial(filial);
             controlaPedido.create(pedidos);

            //IdPedido
            List<Pedido> ped = controlaPedido.findAll();
            int idPedido = 0;
            for (Pedido p : ped) {
                if (idPedido < p.getIdPedido()) {
                    idPedido = p.getIdPedido();
                }
            }

            //Adiciona dados na tabela Historico do Pedido
            pedidos.setIdPedido(idPedido);
            historico.setDataPedido(data);
            historico.setObservacao(null);
            historico.setStatus(StatusDoPedido.Finalizado);
            historico.setPedido(pedidos);
            controlaHistoricoDoPedido.create(historico);
      
            for (int linha = 0; linha < totalLinhas; linha++) {
                objects[0] = jTable1.getValueAt(linha, 0); //codigo do Produto
                objects[1] = jTable1.getValueAt(linha, 1); //nome
                objects[2] = jTable1.getValueAt(linha, 2); //cor
                objects[3] = jTable1.getValueAt(linha, 3); //tamanho
                objects[4] = jTable1.getValueAt(linha, 4); //quantidade
                objects[5] = jTable1.getValueAt(linha, 5); //preço
                objects[6] = jTable1.getValueAt(linha, 6); //subTotal

                //Codigo do produto
                int codigoProduto = (Integer) objects[0];
                //quantidade
                String qtd = (String) objects[4];
                int quantidade = Integer.parseInt(qtd);
                //SubTotal
                double subTotal = (Double) objects[6];

                //Adiciona na tabela Item do Pedido
                pedidos.setIdPedido(idPedido);
                produtos.setIdProduto(codigoProduto);
                item.setQuantidade(quantidade);
                item.setSubTotal(subTotal);
                item.setPedido(pedidos);
                item.setProduto(produtos);
                controlaItemDoPedido.create(item);
      
                diminuiEstoque(quantidade, idFilial, codigoProduto);
            }
       
            String nome = (String) objects[1];
            String cor = (String) objects[2];
            int tamanho = (Integer) objects[3];
            double preco = (Double) objects[5];

            JOptionPane.showMessageDialog(null, "Compra Finalizada");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: Não foi possível finalizar a compra");
            Logger.getLogger(TelaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void diminuiEstoque(int quantidade, int idFilial, int codigoProduto) throws Exception{
        estoqueController controlaEstoque = new estoqueController();
        produtoController controlaProduto = new produtoController();
        Produto produto = new Produto();
        Filial filial = new Filial();
        Estoque_Produto estoqueProduto = new Estoque_Produto();
        Estoque estoque = new Estoque();
        
        Produto produtos = controlaProduto.find(codigoProduto);
        int idProduto = produtos.getIdProduto();
        
        int idEstoqueProduto = 0;
            int quantidadeEstoque = 0;
            List<Estoque_Produto> eProduto = controlaEstoque.findAll();
            for(Estoque_Produto estoques : eProduto){
            if((estoques.getProduto().getIdProduto() == idProduto) && (estoques.getEstoque().getIdEstoque() == idFilial)){
                idEstoqueProduto = estoques.getIdEstoque_Produto();
                quantidadeEstoque = estoques.getQuantidade();
            }
        }
                        
        //idFilial = idEstoque
        estoque.setIdEstoque(idFilial);
        produto.setIdProduto(idProduto);
        
        estoqueProduto.setIdEstoque_Produto(idEstoqueProduto);
        estoqueProduto.setQuantidade(estoqueProduto.getQuantidade() - quantidade);
        estoqueProduto.setEstoque(estoque);
        estoqueProduto.setProduto(produto);
        controlaEstoque.edit(estoqueProduto);
        JOptionPane.showMessageDialog(null, "Qtd alterado");
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);


            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
