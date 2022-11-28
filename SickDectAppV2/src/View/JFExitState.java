package View;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author SickDectTeam
 */
public class JFExitState extends javax.swing.JFrame {

    public JFExitState() {
        initComponents();
        this.setTitle("Salida del Sistema");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExitStatePanel = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        btnExitS = new javax.swing.JButton();
        btnGoBackS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        ExitStatePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 0), null, null));

        lbQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion.setText("ESTA SEGURO DE QUE DESEA SALIR DEL SISTEMA?");

        btnExitS.setText("SALIR");
        btnExitS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitSActionPerformed(evt);
            }
        });

        btnGoBackS.setText("REGRESAR");
        btnGoBackS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExitStatePanelLayout = new javax.swing.GroupLayout(ExitStatePanel);
        ExitStatePanel.setLayout(ExitStatePanelLayout);
        ExitStatePanelLayout.setHorizontalGroup(
            ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitStatePanelLayout.createSequentialGroup()
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExitStatePanelLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnExitS)
                        .addGap(66, 66, 66)
                        .addComponent(btnGoBackS))
                    .addGroup(ExitStatePanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lbQuestion)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        ExitStatePanelLayout.setVerticalGroup(
            ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitStatePanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbQuestion)
                .addGap(27, 27, 27)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExitS)
                    .addComponent(btnGoBackS))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExitStatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExitStatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitSActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitSActionPerformed

    private void btnGoBackSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackSActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackSActionPerformed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
            getImage(ClassLoader.getSystemResource("resources/iconExitState.png"));
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
            java.util.logging.Logger.getLogger(JFExitState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFExitState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFExitState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFExitState.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFExitState().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExitStatePanel;
    private javax.swing.JButton btnExitS;
    private javax.swing.JButton btnGoBackS;
    private javax.swing.JLabel lbQuestion;
    // End of variables declaration//GEN-END:variables
}
