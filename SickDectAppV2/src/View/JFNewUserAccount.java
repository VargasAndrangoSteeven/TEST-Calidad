package View;

import Model.ClientDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ArchiveManager;
import Model.ClientVO;
import java.awt.Cursor;

/**
 *
 * @author SickDectTeam
 */
public class JFNewUserAccount extends javax.swing.JFrame {

    public JFNewUserAccount() {
        initComponents();
        this.setTitle("Creacion de nuevo usuario");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewAccountPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbUserN = new javax.swing.JLabel();
        txtUserN = new javax.swing.JTextField();
        lbPasswordN = new javax.swing.JLabel();
        pwfPasswordN = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnGoBackN = new javax.swing.JButton();
        lbInstructions = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(835, 533));
        setMinimumSize(new java.awt.Dimension(835, 533));

        NewAccountPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NewAccountPanel.setPreferredSize(new java.awt.Dimension(835, 533));
        NewAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        NewAccountPanel.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        lbUserN.setText("USUARIO");
        NewAccountPanel.add(lbUserN, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));
        NewAccountPanel.add(txtUserN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 190, -1));

        lbPasswordN.setText("CONTRASEÑA");
        NewAccountPanel.add(lbPasswordN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        pwfPasswordN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwfPasswordNActionPerformed(evt);
            }
        });
        NewAccountPanel.add(pwfPasswordN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 190, -1));

        btnRegister.setText("REGISTRAR");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        NewAccountPanel.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, -1));

        btnGoBackN.setText("REGRESAR");
        btnGoBackN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackNActionPerformed(evt);
            }
        });
        NewAccountPanel.add(btnGoBackN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 20));

        lbInstructions.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        lbInstructions.setText("INGRESAR USUARIO Y CONTRASEÑA:");
        NewAccountPanel.add(lbInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FondoRegistroFinal.jpg"))); // NOI18N
        jLabel1.setText("\n");
        NewAccountPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NewAccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NewAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackNActionPerformed

        this.setVisible(false);
        JFUserLogin userState = new JFUserLogin();
        userState.setVisible(true);
    }//GEN-LAST:event_btnGoBackNActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            this.btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            ClientVO aux = new ClientVO();
            ClientDAO auxDAO = new ClientDAO();
            aux.setUser(txtUserN.getText());
            aux.setPassword(pwfPasswordN.getText());

            ArchiveManager am = new ArchiveManager();

            if (this.txtUserN.getText().length() == 0 || this.pwfPasswordN.getText().length() == 0) {
                JFUtilBadMessage msg = new JFUtilBadMessage();
                msg.setMessage("CAMPOS VACÍOS, POR FAVOR COMPLETE");
                msg.setVisible(true);
            } else {
                if (am.verifyClientExistant(aux)) {
                    auxDAO.insertClient(aux);
                    emptyField();
                    JFPersonalDataCollection personalData = new JFPersonalDataCollection();
                    personalData.setVisible(true);
                    this.setVisible(false);
                } else {
                    JFUtilBadMessage bmessage = new JFUtilBadMessage();
                    bmessage.setMessage("INGRESE USUARIO NO REGISTRADO");
                    bmessage.setVisible(true);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(JFNewUserAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void pwfPasswordNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwfPasswordNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwfPasswordNActionPerformed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/iconNewAccount.png"));
        return retValue;
    }

    public void emptyField() {
        txtUserN.setText("");
        pwfPasswordN.setText("");
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
            java.util.logging.Logger.getLogger(JFNewUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFNewUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFNewUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFNewUserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFNewUserAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NewAccountPanel;
    private javax.swing.JButton btnGoBackN;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbInstructions;
    private javax.swing.JLabel lbPasswordN;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUserN;
    private javax.swing.JPasswordField pwfPasswordN;
    private javax.swing.JTextField txtUserN;
    // End of variables declaration//GEN-END:variables
}
