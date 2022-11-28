package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ArchiveManager;
import Model.ClientVO;
import Model.Conexion;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SickDectTeam
 */
public class JFUserLogin extends javax.swing.JFrame {

    public JFUserLogin() {
        initComponents();
        this.setTitle("Ingreso al Sistema");
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SickDectScrollPane = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        UserLoginPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbInstructions = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        pwfPassword = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNewAccount = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lbAdminLogin = new javax.swing.JLabel();
        btnAdministrator = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        SickDectScrollPane.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        UserLoginPanel.setBackground(new java.awt.Color(204, 255, 204));
        UserLoginPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UserLoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        UserLoginPanel.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        lbInstructions.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        lbInstructions.setText("INGRESAR USUARIO Y CONTRASEÑA:");
        UserLoginPanel.add(lbInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 122, -1, -1));

        lbUser.setBackground(new java.awt.Color(51, 255, 204));
        lbUser.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lbUser.setText("USUARIO");
        lbUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        UserLoginPanel.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 171, -1, -1));

        lbPassword.setBackground(new java.awt.Color(51, 255, 204));
        lbPassword.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lbPassword.setText("CONTRASEÑA");
        lbPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        UserLoginPanel.add(lbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 210, -1, -1));
        UserLoginPanel.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 171, 190, -1));
        UserLoginPanel.add(pwfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 211, 190, -1));

        btnEnter.setBackground(new java.awt.Color(51, 255, 204));
        btnEnter.setText("INGRESAR");
        btnEnter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        UserLoginPanel.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 267, 102, 30));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jLabel1.setText("¿Eres Nuevo?");
        UserLoginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        btnNewAccount.setBackground(new java.awt.Color(0, 255, 204));
        btnNewAccount.setText("CREAR CUENTA");
        btnNewAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNewAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAccountActionPerformed(evt);
            }
        });
        UserLoginPanel.add(btnNewAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 118, 32));

        btnExit.setBackground(new java.awt.Color(0, 255, 204));
        btnExit.setText("SALIR");
        btnExit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        UserLoginPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 120, 40));

        lbAdminLogin.setFont(new java.awt.Font("Berlin Sans FB", 1, 14)); // NOI18N
        lbAdminLogin.setText("INGRESAR COMO ADMINISTRADOR:");
        UserLoginPanel.add(lbAdminLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        btnAdministrator.setBackground(new java.awt.Color(0, 255, 204));
        btnAdministrator.setText("ADMINISTRADOR");
        btnAdministrator.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAdministrator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministratorActionPerformed(evt);
            }
        });
        UserLoginPanel.add(btnAdministrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 124, 34));
        UserLoginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 91, -1));

        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        jLabel4.setText("¡Tu Medico En Casa!");
        UserLoginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 184, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/GoodMessageFinal.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        UserLoginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 120, 150));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MenuFondoFinal.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        UserLoginPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(UserLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(UserLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministratorActionPerformed
        this.setVisible(false);
        JFAdminLogin adminState = new JFAdminLogin();
        adminState.setVisible(true);
    }//GEN-LAST:event_btnAdministratorActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        JFExitState exitMessage = new JFExitState();
        exitMessage.setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAccountActionPerformed
        this.setVisible(false);
        JFNewUserAccount newUser = new JFNewUserAccount();
        newUser.setVisible(true);
    }//GEN-LAST:event_btnNewAccountActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        try {
            this.btnEnter.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            
            ClientVO auxClient = new ClientVO();
            auxClient.setUser(txtUser.getText());
            auxClient.setPassword(pwfPassword.getText());

            ArchiveManager am = new ArchiveManager();
            if(am.verifyUser(auxClient)){
                am.saveInAuxResults(auxClient.getUser());
                this.setVisible(false);
                JFMainSymptom userSystem = new JFMainSymptom();
                
            Conexion objConexion = new Conexion();   
            Connection acceso = objConexion.obtenerConexion();
           
            String temp = "CREATE TABLE temp (user VARCHAR(32))";
            PreparedStatement patemp = acceso.prepareStatement(temp);
            String sqltemp = "INSERT INTO temp (user) VALUES(?)";
            PreparedStatement patempUser = acceso.prepareStatement(sqltemp);
            patempUser.setString(1, auxClient.getUser());
            
            patemp.executeUpdate();
            patempUser.executeUpdate();
            
            
            userSystem.setVisible(true);
            }
            else{
                JFUtilBadMessage reentering = new JFUtilBadMessage();
                reentering.setMessage("INGRESE UN USUARIO VALIDO");
                reentering.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(JFUserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JFUserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnterActionPerformed
    
    public void emptyField(){
        txtUser.setText("");
        pwfPassword.setText("");
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
            java.util.logging.Logger.getLogger(JFUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFUserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SickDectScrollPane;
    private javax.swing.JPanel UserLoginPanel;
    private javax.swing.JButton btnAdministrator;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNewAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbAdminLogin;
    private javax.swing.JLabel lbInstructions;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPasswordField pwfPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
