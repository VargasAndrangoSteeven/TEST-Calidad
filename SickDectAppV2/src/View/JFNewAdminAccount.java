package View;

import View.JFPersonalAdminDataCollection;
import Model.AdminVO;
import Model.AdministratorDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.AdministratorVO;
import Model.ArchiveManager;
import java.awt.Cursor;

/**
 *
 * @author SickDectTeam
 */
public class JFNewAdminAccount extends javax.swing.JFrame {

    public JFNewAdminAccount() {
        initComponents();
        this.setTitle("Creacion de nuevo administrador");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbTechiniques = new javax.swing.JLabel();
        lbUserN = new javax.swing.JLabel();
        lbPasswordN = new javax.swing.JLabel();
        txtUserN = new javax.swing.JTextField();
        pwfPasswordN = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnGoBackN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pwfSecret = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        jPanel1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        lbTechiniques.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        lbTechiniques.setText("INGRESAR NUEVO USUARIO Y CONTRASEÑA DE ADMINISTRADOR:");
        jPanel1.add(lbTechiniques, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        lbUserN.setText("USUARIO");
        jPanel1.add(lbUserN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        lbPasswordN.setText("CONTRASEÑA");
        jPanel1.add(lbPasswordN, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));
        jPanel1.add(txtUserN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 190, -1));
        jPanel1.add(pwfPasswordN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 190, -1));

        btnRegister.setText("REGISTRAR");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, -1, -1));

        btnGoBackN.setText("REGRESAR");
        btnGoBackN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackNActionPerformed(evt);
            }
        });
        jPanel1.add(btnGoBackN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel1.setText("CLAVE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));

        pwfSecret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwfSecretActionPerformed(evt);
            }
        });
        jPanel1.add(pwfSecret, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 190, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FondoRegistroFinal.jpg"))); // NOI18N
        jLabel2.setText("\n");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            this.btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String secretPassword = "12345";
            AdministratorVO auxVO = new AdministratorVO();
            AdministratorDAO auxDAO = new AdministratorDAO();

            if (this.txtUserN.getText().length() == 0 || this.pwfPasswordN.getText().length() == 0
                    || this.pwfSecret.getText().length() == 0) {
                JFUtilBadMessage msg = new JFUtilBadMessage();
                msg.setMessage("CAMPOS VACÍOS, POR FAVOR COMPLETE");
                msg.setVisible(true);

            } else {
                auxVO.setUser(txtUserN.getText());
                auxVO.setPassword(pwfPasswordN.getText());

                ArchiveManager am = new ArchiveManager();

                if (pwfSecret.getText().equals(secretPassword) && am.verifyAdminExistant(auxVO) == true) {
                    auxDAO.insertAdministrator(auxVO);
                    emptyField();
                    this.setVisible(false);

                    JFPersonalAdminDataCollection newAdmin = new JFPersonalAdminDataCollection();
                    newAdmin.setVisible(true);
                } else {
                    JFUtilBadMessage UBmessage = new JFUtilBadMessage();
                    UBmessage.setMessage("INGRESE ADMINISTRADOR NO REGISTRADO");
                    UBmessage.setVisible(true);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(JFNewUserAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnGoBackNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackNActionPerformed

        this.setVisible(false);
        JFUserLogin userState = new JFUserLogin();
        userState.setVisible(true);
    }//GEN-LAST:event_btnGoBackNActionPerformed

    private void pwfSecretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwfSecretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwfSecretActionPerformed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/iconNewAccount.png"));
        return retValue;
    }

    public void emptyField() {
        txtUserN.setText("");
        pwfPasswordN.setText("");
        pwfSecret.setText("");
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
            java.util.logging.Logger.getLogger(JFNewAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFNewAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFNewAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFNewAdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFNewAdminAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBackN;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPasswordN;
    private javax.swing.JLabel lbTechiniques;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUserN;
    private javax.swing.JPasswordField pwfPasswordN;
    private javax.swing.JPasswordField pwfSecret;
    private javax.swing.JTextField txtUserN;
    // End of variables declaration//GEN-END:variables
}
