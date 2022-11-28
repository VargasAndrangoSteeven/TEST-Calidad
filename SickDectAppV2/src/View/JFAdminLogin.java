package View;

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
public class JFAdminLogin extends javax.swing.JFrame {

    public JFAdminLogin() {
        initComponents();
        this.setTitle("Ingreso al Sistema como Administrador");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminLoginPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbInstruct = new javax.swing.JLabel();
        lbUserA = new javax.swing.JLabel();
        lbPasswordA = new javax.swing.JLabel();
        txtUserA = new javax.swing.JTextField();
        pwfPasswordA = new javax.swing.JPasswordField();
        btnAdminLogin = new javax.swing.JButton();
        btnExitA = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        lbNewAdmin = new javax.swing.JLabel();
        btnNewAdmin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        AdminLoginPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AdminLoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        AdminLoginPanel.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        lbInstruct.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        lbInstruct.setText("INGRESAR USUARIO Y CONTRASEÑA DE ADMINISTRADOR:");
        AdminLoginPanel.add(lbInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        lbUserA.setText("USUARIO");
        AdminLoginPanel.add(lbUserA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        lbPasswordA.setText("CONTRASEÑA");
        AdminLoginPanel.add(lbPasswordA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));
        AdminLoginPanel.add(txtUserA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 190, -1));
        AdminLoginPanel.add(pwfPasswordA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 190, -1));

        btnAdminLogin.setText("INGRESAR");
        btnAdminLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });
        AdminLoginPanel.add(btnAdminLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        btnExitA.setText("SALIR");
        btnExitA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitAActionPerformed(evt);
            }
        });
        AdminLoginPanel.add(btnExitA, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, -1, -1));

        btnGoBack.setText("REGRESAR");
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        AdminLoginPanel.add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        lbNewAdmin.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        lbNewAdmin.setText("CREAR NUEVO ADMINISTRADOR:");
        AdminLoginPanel.add(lbNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        btnNewAdmin.setText("CREAR NUEVO");
        btnNewAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAdminActionPerformed(evt);
            }
        });
        AdminLoginPanel.add(btnNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MenuFondoFinal.jpg"))); // NOI18N
        AdminLoginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        jLabel2.setText("jLabel2");
        AdminLoginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 148, 144));

        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        jLabel4.setText("¡Tu Medico En Casa!");
        AdminLoginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 184, -1));
        AdminLoginPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        this.setVisible(false);
        JFUserLogin userState = new JFUserLogin();
        userState.setVisible(true);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnExitAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitAActionPerformed
        JFExitState exitMessage = new JFExitState();
        exitMessage.setVisible(true);
    }//GEN-LAST:event_btnExitAActionPerformed

    private void btnNewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAdminActionPerformed
        this.setVisible(false);
        JFNewAdminAccount adminAcc = new JFNewAdminAccount();
        adminAcc.setVisible(true);
        this.btnNewAdmin.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
    }//GEN-LAST:event_btnNewAdminActionPerformed

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed
        try {
            this.btnAdminLogin.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            AdministratorVO auxAdmin = new AdministratorVO();
            auxAdmin.setUser(txtUserA.getText());
            auxAdmin.setPassword(pwfPasswordA.getText());
            
            ArchiveManager am = new ArchiveManager();
            if(am.verifyAdmin(auxAdmin)){
                emptyField();

                //Interfaz
                JFAdminMenu JFAM = new JFAdminMenu();
                this.setVisible(false);
                JFAM.setVisible(true);
                JFUtilMessage entering = new JFUtilMessage();
                entering.setVisible(true);
            }
            else{
                JFUtilBadMessage reentering = new JFUtilBadMessage();
                reentering.setMessage("INGRESE UN USUARIO VALIDO");
                reentering.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(JFAdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnAdminLoginActionPerformed
    
    public void emptyField(){
        txtUserA.setText("");
        pwfPasswordA.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(JFAdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminLoginPanel;
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JButton btnExitA;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnNewAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbInstruct;
    private javax.swing.JLabel lbNewAdmin;
    private javax.swing.JLabel lbPasswordA;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUserA;
    private javax.swing.JPasswordField pwfPasswordA;
    private javax.swing.JTextField txtUserA;
    // End of variables declaration//GEN-END:variables
}
