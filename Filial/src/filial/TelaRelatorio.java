/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Filial;

import allshoes.jpa.Filial;
import allshoes.jpa.HistoricoDoPedido;
import allshoes.jpa.ItemDoPedido;
import controller.filialController;
import controller.historicoDoPedidoController;
import controller.itemDoPedidoController;
import controller.pedidoController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaRelatorio extends javax.swing.JFrame {

   
    public TelaRelatorio() {
        initComponents();

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        campoDia = new javax.swing.JComboBox();
        campoMes = new javax.swing.JComboBox();
        campoAno = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Venda Diária");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Produto", "Quantidade", "Preço", "SubTotal", "Filial"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Data:");

        jLabel3.setText("Total Vendido:");

        total.setText("TOTAL");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a Filial" }));

        campoDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        campoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDiaActionPerformed(evt);
            }
        });

        campoMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        campoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMesActionPerformed(evt);
            }
        });

        campoAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano", "2010", "2011", "2012", "2013" }));
        campoAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(campoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(total))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Pesquisa vendas diárias
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            pedidoController controlaPedido = new pedidoController();
            itemDoPedidoController controlaItem = new itemDoPedidoController();
            historicoDoPedidoController controlaHistorico = new historicoDoPedidoController();

            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date(); //data atual
            String dia = (String) campoDia.getSelectedItem();
            String mes = (String) campoMes.getSelectedItem();
            String ano = (String) campoAno.getSelectedItem();

            String d = ano + "-" + mes + "-" + dia;

            //Pega o idFilial 
            String nomeFilial = (String) jComboBox1.getSelectedItem();
            char letra = nomeFilial.charAt(0); 
            int idFilial = Integer.parseInt(String.valueOf(letra));


            List<ItemDoPedido> item = controlaItem.findAll();
            List<HistoricoDoPedido> historico = controlaHistorico.findAll();

            DefaultTableModel dtm = new DefaultTableModel();
            Object[] tableColumnNames = new Object[6];
            tableColumnNames[0] = "Data";
            tableColumnNames[1] = "Produto";
            tableColumnNames[2] = "Quantidade";
            tableColumnNames[3] = "Preco";
            tableColumnNames[4] = "SubTotal";
            tableColumnNames[5] = "Filial";
            dtm.setColumnIdentifiers(tableColumnNames);
            Object[] objects = new Object[6];

            //Verifica a data informada com as datas do banco de dados
            int verificaData;
            int idPedido;
            double subTotal = 0;
            for (HistoricoDoPedido h : historico) {
                if (sd.format(h.getDataPedido()).equalsIgnoreCase(d) == true) {
                    idPedido = h.getPedido().getIdPedido();
                    objects[0] = sd.format(h.getDataPedido());
                    for (ItemDoPedido p : item) {
                        if (idPedido == p.getPedido().getIdPedido()) {
                            objects[1] = p.getProduto().getNome();
                            objects[2] = p.getQuantidade();
                            objects[3] = p.getProduto().getPreco();
                            objects[4] = p.getQuantidade() * p.getProduto().getPreco();
                            subTotal = p.getQuantidade() * p.getProduto().getPreco();
                            objects[5] = p.getPedido().getFilial().getNome();
                            if(p.getPedido().getFilial().getIdFilial() == idFilial){
                            dtm.addRow(objects);
                        }
                        }
                    }
                }

            }

            jTable1.setModel(dtm);
            double valorTotal = 0;
            int totalLinhas = jTable1.getModel().getRowCount();
            for(int linha = 0; linha < totalLinhas; linha++){
                valorTotal = valorTotal + (Double) jTable1.getValueAt(linha, 4); 
            }
   
            total.setText(String.valueOf(valorTotal));

            
            
        } catch (Exception ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }



       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDiaActionPerformed

    private void campoMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMesActionPerformed

    private void campoAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAnoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox campoAno;
    private javax.swing.JComboBox campoDia;
    private javax.swing.JComboBox campoMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
