/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.controladorDatos;
import controller.ed.lista.ListaEnlazada;
import javax.swing.JOptionPane;
import vista.modeloTabla.modeloTablaAle;

/**
 *
 * @author Kevin
 */
public class FrmAleatorio extends javax.swing.JDialog {

    private controladorDatos valores = new controladorDatos();

    private modeloTablaAle aleatorio = new modeloTablaAle();
    private Integer ASCENDENTE = 0;
    private Integer DESCENDENTE = 1;

    /**
     * Creates new form FrmAleatorio
     */
    public FrmAleatorio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();

    }

    private void cargarTabla() {
        aleatorio.setDatos(valores.getValor());
        tblTabla.setModel(aleatorio);
        tblTabla.updateUI();
    }
    private void ordenarMerge(){
    int criterio = cbxOrden.getSelectedIndex();

    long startTime = System.currentTimeMillis();
    controladorDatos datos = new controladorDatos();
    ListaEnlazada<Integer> lista = datos.getValor();
    aleatorio.setDatos(valores.ordenarMerge(lista, criterio));
    tblTabla.setModel(aleatorio);
    tblTabla.updateUI();
    long finalTime = System.currentTimeMillis() - startTime;
    JOptionPane.showMessageDialog(null, "Tiempo de ejecución en Merge es: " + finalTime + " milisegundos", "OK", JOptionPane.INFORMATION_MESSAGE);
    
    }    

////    private void ordenarMerge() {
////        String criterio = cbxOrden.getSelectedItem().toString();
////        if (criterio.equalsIgnoreCase("Ascendente")) {
////            try {
////                long startTime = System.currentTimeMillis();
////                aleatorio.setDatos(valores.mergeSort(valores.getValor(), ASCENDENTE));
////                tblTabla.setModel(aleatorio);
////                tblTabla.updateUI();
////                long finalTime = System.currentTimeMillis() - startTime;
////                JOptionPane.showMessageDialog(null, "El tiempo de ejecución del MergeSort en forma ascendente es de: " + finalTime+ " milisegundos", "OK", JOptionPane.INFORMATION_MESSAGE);
////            } catch (Exception e) {
////            }
////        }
////        if (criterio.equalsIgnoreCase("Descendente")) {
////            try {
////                long startTime = System.currentTimeMillis();
////                aleatorio.setDatos(valores.mergeSort(valores.getValor(), DESCENDENTE));
////                tblTabla.setModel(aleatorio);
////                tblTabla.updateUI();
////                long finalTime = System.currentTimeMillis() - startTime;
////                JOptionPane.showMessageDialog(null, "Tiempo de ejecución en Merge es: " + finalTime+ " milisegundos", "OK", JOptionPane.INFORMATION_MESSAGE);
////            } catch (Exception e) {
////            }
////        }
////    }

    private void ordenarQuick() {

        int criterio = cbxOrden.getSelectedIndex();
        
            long startTime = System.currentTimeMillis(); // Manejar la excepción apropiadamente
            controladorDatos datos = new controladorDatos();
            ListaEnlazada<Integer> lista = datos.getValor();
            //ListaEnlazada<Valor> listaOrdenada = datos.quickSort(lista, ASCENDENTE);
            // Actualizar la tabla con la lista ordenada
            aleatorio.setDatos(valores.ordenar(lista, criterio));
            tblTabla.setModel(aleatorio);
            tblTabla.updateUI();
            long finalTime = System.currentTimeMillis() - startTime;
            JOptionPane.showMessageDialog(null, "Tiempo de ejecución en Quick es: " + finalTime+ " milisegundos", "OK", JOptionPane.INFORMATION_MESSAGE);
  
//        if (criterio.equalsIgnoreCase("Descendente")) {
//            try {
//                long startTime = System.currentTimeMillis();
//                controladorDatos datos = new controladorDatos();
//                ListaEnlazada<Valor> lista = datos.getValor();
//                ListaEnlazada<Valor> listaOrdenada = datos.quickSort(lista, DESCENDENTE);
//
//                // Actualizar la tabla con la lista ordenada
//                aleatorio.setDatos(listaOrdenada);
//                tblTabla.setModel(aleatorio);
//                tblTabla.updateUI();
//                long finalTime = System.currentTimeMillis() - startTime;
//                JOptionPane.showMessageDialog(null, "Tiempo de ejecución en Quick es: " + finalTime+ " milisegundos", "OK", JOptionPane.INFORMATION_MESSAGE);
//
//            } catch (EmptyException | PositionException e) {
//                // Manejar la excepción apropiadamente
//            }
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMerge = new javax.swing.JButton();
        btnQuick = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxOrden = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenacion"));

        jLabel1.setText("Ordenación por Mergesort");

        jLabel2.setText("Ordenacion Quicksort");

        btnMerge.setText("MERGE");
        btnMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeActionPerformed(evt);
            }
        });

        btnQuick.setText("QUICK");
        btnQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de ordenacion");

        cbxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        cbxOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addComponent(btnMerge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMerge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuick, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeActionPerformed
        ordenarMerge();
    }//GEN-LAST:event_btnMergeActionPerformed

    private void btnQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickActionPerformed
        ordenarQuick();
    }//GEN-LAST:event_btnQuickActionPerformed

    private void cbxOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrdenActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAleatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAleatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAleatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAleatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAleatorio dialog = new FrmAleatorio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMerge;
    private javax.swing.JButton btnQuick;
    private javax.swing.JComboBox<String> cbxOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}
