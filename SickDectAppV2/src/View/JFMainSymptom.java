package View;

import View.JFUserLogin;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ArchiveManager;
import java.awt.Cursor;

/**
 *
 * @author SickDectTeam
 */
public class JFMainSymptom extends javax.swing.JFrame {

    public JFMainSymptom() throws IOException {
        initComponents();
        this.setTitle("Ingreso de sintoma principal");
        this.setLocationRelativeTo(null);

        ArchiveManager am = new ArchiveManager();
        ArrayList<String> arrFiles = am.listSymptoms();
        arrFiles.forEach((aux) -> {
            jcbMainSymptom.addItem(aux);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcbMainSymptom = new javax.swing.JComboBox<>();
        btnEntry = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        jPanel1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("INGRESAR EL SINTOMA PRINCIPAL (Mayor molestia)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jcbMainSymptom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jcbMainSymptom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMainSymptomActionPerformed(evt);
            }
        });
        jPanel1.add(jcbMainSymptom, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 320, -1));

        btnEntry.setText("INGRESAR");
        btnEntry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntryActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        btnReturn.setText("REGRESAR");
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel1.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jButton1.setText("MIS DATOS");
        jButton1.setName("btnData"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/PPrincipal.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntryActionPerformed
        try {
            this.btnEntry.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ArchiveManager am = new ArchiveManager();
            String mainSymptom = jcbMainSymptom.getItemAt(jcbMainSymptom.getSelectedIndex());
            am.createMainSymptomArchive(mainSymptom);
            this.setVisible(false);

            JFPrincipalQuestion pQuestion = new JFPrincipalQuestion();
            pQuestion.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JFMainSymptom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEntryActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        this.setVisible(false);
        JFUserLogin goBack = new JFUserLogin();
        goBack.setVisible(true);

        ArchiveManager am = new ArchiveManager();
        am.auxArchivesDelet();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void jcbMainSymptomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMainSymptomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMainSymptomActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFUserData user = new JFUserData();
        user.setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @return
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/iconSystem.png"));
        return retValue;
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
            java.util.logging.Logger.getLogger(JFMainSymptom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMainSymptom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMainSymptom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMainSymptom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFMainSymptom().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JFMainSymptom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntry;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbMainSymptom;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
