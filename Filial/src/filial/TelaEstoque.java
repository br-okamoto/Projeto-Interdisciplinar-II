package Filial;

import Validacao.IntegerDocument;
import Validacao.teclasPermitidas;
import allshoes.jpa.Estoque;
import allshoes.jpa.Estoque_Produto;
import allshoes.jpa.Filial;
import allshoes.jpa.Produto;
import controller.estoqueController;
import controller.filialController;
import controller.produtoController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaEstoque extends javax.swing.JFrame {

    public TelaEstoque() {
        initComponents();

        //Campo aceita apenas letras
        jTextField2.setDocument(new teclasPermitidas());
        //Campo aceita apenas números com 4 dígitos
        jTextField1.setDocument(new IntegerDocument(4));
        campoCodigo.setDocument(new IntegerDocument(4));
        campoQuantidade.setDocument(new IntegerDocument(2));

        filialController controlaFilial = null;
        
        try {
            controlaFilial = new filialController();
            List<Filial> filiais = controlaFilial.findAll();
            for (Filial f : filiais) {
                jComboBox1.addItem(f.getIdFilial() + " - " + f.getNome());
                
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        campoCodigo = new javax.swing.JTextField();
        campoQuantidade = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        campoProduto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Estoque");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(307, 307, 307))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição", "Preco", "Quant. Estoque", "Filial"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Recebimento"));

        jLabel4.setText("Filial");

        jLabel5.setText("Produto:");

        jLabel6.setText("Quantidade:");

        jLabel2.setText("Código:");

        jButton2.setText("Entrada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Saída");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a Filial" }));

        campoProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(campoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(campoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        jLabel7.setText("Código:");

        jLabel8.setText("Produto:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    //Pesquisa no Estoque
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            produtoController controlaProduto = new produtoController();
            estoqueController controlaEstoque = new estoqueController();
            filialController controlaFilial = new filialController();

            DefaultTableModel dtm = new DefaultTableModel();
            Object[] tableColumnNames = new Object[6];
            tableColumnNames[0] = "Código";
            tableColumnNames[1] = "Nome";
            tableColumnNames[2] = "Descricao";
            tableColumnNames[3] = "Preco";
            tableColumnNames[4] = "Quantidade";
            tableColumnNames[5] = "Filial";
            dtm.setColumnIdentifiers(tableColumnNames);

            //Pesquisa por nome
            if (jTextField1.getText().isEmpty()) {
                String prod = jTextField2.getText();
                List<Produto> produtos = controlaProduto.findName(prod);
                List<Estoque_Produto> e = controlaEstoque.findAll();
    
                Object[] objects = new Object[6];
                for (Estoque_Produto est : e) {
                    if (prod.equalsIgnoreCase(est.getProduto().getNome())) {
                        objects[0] = est.getProduto().getCod_produto();
                        objects[1] = est.getProduto().getNome();
                        objects[2] = est.getProduto().getDescricao();
                        objects[3] = est.getProduto().getPreco();
                        objects[4] = est.getQuantidade();
                        objects[5] = "Filial";
       
                         List<Filial> fil = controlaFilial.findAll();
                        for(Filial f : fil){
                            if(f.getIdFilial() == est.getEstoque().getIdEstoque()){
                                objects[5] = f.getNome();
                            }
                        }
                        dtm.addRow(objects);
                    }
                }
                
            //Pesquisa pelo código
            } else {
                int codigo = Integer.parseInt(jTextField1.getText());
                Produto produtos = controlaProduto.find(codigo);
                List<Estoque_Produto> p = controlaEstoque.findAll();
                List<Filial> fil = controlaFilial.findAll();
                
                int qtd = 0;
                String filial = null;
                
                for (Estoque_Produto ep : p) {
                    if (ep.getProduto().getIdProduto() == produtos.getIdProduto()) {
                        qtd = ep.getQuantidade();
                    }
                    for(Filial f : fil){
                    if(ep.getEstoque().getIdEstoque() == f.getIdFilial()){
                        filial = f.getNome();
                    }
                }
                }
                Object[] objects = new Object[6];
                objects[0] = produtos.getCod_produto();
                objects[1] = produtos.getNome();
                objects[2] = produtos.getDescricao();
                objects[3] = produtos.getPreco();
                objects[4] = qtd;
                objects[5] = filial;
                
                /*objects[0] = produtos.getCod_produto();
                objects[1] = produtos.getNome();
                objects[2] = produtos.getDescricao();
                objects[3] = produtos.getPreco();
                objects[4] = qtd;
                objects[5] = filial;
     */
                dtm.addRow(objects);    
            }
            
            jTable1.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro!\n\n Produto não encontrado! \n "
                    + "Tente pesquisar pelo código ou pelo nome do produto");
            Logger.getLogger(TelaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    // Saída de Produtos do Estoque
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int codigo = Integer.parseInt(campoCodigo.getText());
        int quantidade = Integer.parseInt(campoQuantidade.getText());

        try {
            Produto prod = new Produto();
            Estoque_Produto ep = new Estoque_Produto();
            Estoque estoque = new Estoque();
            Filial filial = new Filial();
            estoqueController controlaEstoque = new estoqueController();

            estoque.setIdEstoque(1);
            prod.setIdProduto(13);

            ep.setIdEstoque_Produto(1);
            ep.setQuantidade(quantidade);
            ep.setEstoque(estoque);
            ep.setProduto(prod);

            int novaQuantidade = ep.getQuantidade();

            controlaEstoque.edit(ep);
            listaTabela();
            JOptionPane.showMessageDialog(null, "Saida de Produtos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: ");
            Logger.getLogger(TelaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // entrada de produtos no estoque
        int codigo = Integer.parseInt(campoCodigo.getText());
        int quantidade = Integer.parseInt(campoQuantidade.getText());

        try {
            Produto prod = new Produto();
            Estoque_Produto ep = new Estoque_Produto();
            Estoque estoque = new Estoque();
            Filial filial = new Filial();
            estoqueController controlaEstoque = new estoqueController();
            produtoController controlaProduto = new produtoController();
            filialController controlaFilial = new filialController();

            Produto produtos = controlaProduto.find(codigo);
                      
            campoProduto.setText(produtos.getNome());
            
            String nomeFilial = (String) jComboBox1.getSelectedItem();
            char letra = nomeFilial.charAt(0); 
            int idFilial = Integer.parseInt(String.valueOf(letra));
            int idProduto = produtos.getIdProduto();
     
            int idEstoqueProduto = 0;
            int quantidadeEstoque = 0;
            
            List<Estoque_Produto> estoqueProduto = controlaEstoque.findAll();
            for (Estoque_Produto e : estoqueProduto) {
                if ((e.getProduto().getIdProduto() == idProduto) && (e.getEstoque().getIdEstoque() == idFilial)) {
                    idEstoqueProduto = e.getIdEstoque_Produto();
                    quantidadeEstoque = e.getQuantidade();
                }
            }   
            
            produtos.setIdProduto(idProduto);
            estoque.setIdEstoque(idFilial);
            
            
            ep.setIdEstoque_Produto(idEstoqueProduto);
            ep.setQuantidade(quantidadeEstoque + quantidade);
            ep.setEstoque(estoque);
            ep.setProduto(produtos);

            controlaEstoque.edit(ep);
     
            listaTabela();

            JOptionPane.showMessageDialog(null, "Estoque alterado");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: ");
            Logger.getLogger(TelaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public void listaTabela() {
        try {
            produtoController controlaProduto = new produtoController();
            estoqueController controlaEstoque = new estoqueController();
            filialController controlaFilial = new filialController();
            
            List<Produto> produtos = controlaProduto.findAll();
            List<Estoque_Produto> e = controlaEstoque.findAll();
            
            
            
            if (!produtos.isEmpty()) {
                DefaultTableModel dtm = new DefaultTableModel();
                Object[] tableColumnNames = new Object[6];
                tableColumnNames[0] = "Código";
                tableColumnNames[1] = "Nome";
                tableColumnNames[2] = "Descricao";
                tableColumnNames[3] = "Preco";
                tableColumnNames[4] = "Quantidade";
                tableColumnNames[5] = "Filial";
                dtm.setColumnIdentifiers(tableColumnNames);

                Object[] objects = new Object[6];

                
                for(Estoque_Produto ep : e){
                    objects[0] = ep.getProduto().getCod_produto();
                    objects[1] = ep.getProduto().getNome();
                    objects[2] = ep.getProduto().getDescricao();
                    objects[3] = ep.getProduto().getPreco();
                    objects[4] = 0;
                    objects[5] = "Filial";
                    
                    for(Produto p : produtos){
                        if (ep.getProduto().getCod_produto() == p.getCod_produto()) {
                            objects[4] = ep.getQuantidade();
                        }
                        List<Filial> fil = controlaFilial.findAll();
                        for(Filial f : fil){
                            if(f.getIdFilial() == ep.getEstoque().getIdEstoque()){
                                objects[5] = f.getNome();
                            }}
                    }
            dtm.addRow(objects);
            }
             
                jTable1.setModel(dtm);
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
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
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEstoque().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JLabel campoProduto;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
