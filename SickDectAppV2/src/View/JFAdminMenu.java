package View;

import Controller.AdminController;
import Controller.ClientController;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author SickDectTeam
 */
public class JFAdminMenu extends javax.swing.JFrame {

    public JFAdminMenu() {
        initComponents();
        this.setTitle("Menu de administrador");
        this.setLocationRelativeTo(null);
        this.cajon.setVisible(false);
        this.cajon1.setVisible(false);
        this.cajon2.setVisible(false);
        this.cajon3.setVisible(false);
        this.btnStatics.setVisible(false);
        this.btnExit.setVisible(false);
        this.btnManagementAdmins.setVisible(false);
        this.btnManagementUsers.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnManagementAdmins = new javax.swing.JButton();
        btnManagementUsers = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnStatics = new javax.swing.JButton();
        auxCajon = new javax.swing.JLabel();
        auxCajon1 = new javax.swing.JLabel();
        auxCajon2 = new javax.swing.JLabel();
        auxCajon3 = new javax.swing.JLabel();
        cajon = new javax.swing.JLabel();
        cajon1 = new javax.swing.JLabel();
        cajon2 = new javax.swing.JLabel();
        cajon3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setAutoscrolls(true);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        lbTitle.setText("SICK DECT");
        jPanel1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("BIENVENIDO ADMINISTRADOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btnManagementAdmins.setText("GESTIONAR ADMINISTRADORES");
        btnManagementAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementAdminsActionPerformed(evt);
            }
        });
        jPanel1.add(btnManagementAdmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        btnManagementUsers.setText("GESTIONAR USUARIOS");
        btnManagementUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagementUsersActionPerformed(evt);
            }
        });
        jPanel1.add(btnManagementUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 191, -1));

        btnExit.setText("SALIR");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 191, -1));

        btnStatics.setText("ESTADISTICAS DE USUARIO");
        btnStatics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaticsActionPerformed(evt);
            }
        });
        jPanel1.add(btnStatics, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 191, -1));

        auxCajon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                auxCajonMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                auxCajonMouseMoved(evt);
            }
        });
        jPanel1.add(auxCajon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 330, 60));

        auxCajon1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                auxCajon1MouseMoved(evt);
            }
        });
        jPanel1.add(auxCajon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 330, 60));

        auxCajon2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                auxCajon2MouseMoved(evt);
            }
        });
        jPanel1.add(auxCajon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 330, 60));

        auxCajon3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                auxCajon3MouseMoved(evt);
            }
        });
        jPanel1.add(auxCajon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 330, 60));

        cajon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cajon.png"))); // NOI18N
        jPanel1.add(cajon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 220));

        cajon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cajon.png"))); // NOI18N
        jPanel1.add(cajon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 220));

        cajon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cajon.png"))); // NOI18N
        cajon2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cajon2MouseMoved(evt);
            }
        });
        jPanel1.add(cajon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, 160));

        cajon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cajon.png"))); // NOI18N
        jPanel1.add(cajon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/armario.jpg"))); // NOI18N
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        JFExitState exit = new JFExitState();
        exit.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnManagementAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementAdminsActionPerformed
        this.setVisible(false);
        JFAdminManagementMenu objVista = new JFAdminManagementMenu();
        AdminController controller = new AdminController(objVista);
        objVista.setVisible(true);
    }//GEN-LAST:event_btnManagementAdminsActionPerformed

    private void btnManagementUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagementUsersActionPerformed
        this.setVisible(false);
        JFClientManagementMenu objVista = new JFClientManagementMenu();
        ClientController controller = new ClientController(objVista);
        objVista.setVisible(true);
    }//GEN-LAST:event_btnManagementUsersActionPerformed

    private void btnStaticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaticsActionPerformed
        this.setVisible(false);
        JFStatics statics = new JFStatics();
        statics.setVisible(true);
    }//GEN-LAST:event_btnStaticsActionPerformed

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        // TODO add your handling code here:
        this.cajon.setVisible(false);
        this.cajon1.setVisible(false);
        this.cajon2.setVisible(false);
        this.cajon3.setVisible(false);
        this.btnExit.setVisible(false);
        this.btnManagementAdmins.setVisible(false);
        this.btnManagementUsers.setVisible(false);
        this.btnStatics.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseMoved

    private void cajon2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajon2MouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cajon2MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        System.out.println("hola");
    }//GEN-LAST:event_jPanel1MouseMoved

    private void auxCajon3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auxCajon3MouseMoved
        // TODO add your handling code here:
        this.cajon3.setVisible(true);
        this.btnExit.setVisible(true);

        this.cajon.setVisible(false);
        this.cajon1.setVisible(false);
        this.cajon2.setVisible(false);
        this.btnStatics.setVisible(false);
        this.btnManagementAdmins.setVisible(false);
        this.btnManagementUsers.setVisible(false);

    }//GEN-LAST:event_auxCajon3MouseMoved

    private void auxCajon2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auxCajon2MouseMoved
        // TODO add your handling code here:
        this.cajon2.setVisible(true);
        this.btnStatics.setVisible(true);

        this.cajon.setVisible(false);
        this.cajon1.setVisible(false);
        this.cajon3.setVisible(false);
        this.btnExit.setVisible(false);
        this.btnManagementAdmins.setVisible(false);
        this.btnManagementUsers.setVisible(false);
    }//GEN-LAST:event_auxCajon2MouseMoved

    private void auxCajon1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auxCajon1MouseMoved
        // TODO add your handling code here:
        this.cajon1.setVisible(true);
        this.btnManagementUsers.setVisible(true);

        this.cajon.setVisible(false);
        this.cajon2.setVisible(false);
        this.cajon3.setVisible(false);
        this.btnExit.setVisible(false);
        this.btnManagementAdmins.setVisible(false);
        this.btnStatics.setVisible(false);
    }//GEN-LAST:event_auxCajon1MouseMoved

    private void auxCajonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auxCajonMouseMoved
        // TODO add your handling code here:
        //this.cajon.setVisible(true);
        this.cajon.setVisible(true);
        this.btnManagementAdmins.setVisible(true);

        this.cajon1.setVisible(false);
        this.cajon2.setVisible(false);
        this.cajon3.setVisible(false);
        this.btnExit.setVisible(false);
        this.btnManagementUsers.setVisible(false);
        this.btnStatics.setVisible(false);
    }//GEN-LAST:event_auxCajonMouseMoved

    private void auxCajonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auxCajonMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_auxCajonMouseDragged

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
            java.util.logging.Logger.getLogger(JFAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFAdminMenu().setVisible(true);
        });
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("resources/iconSystem.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel auxCajon;
    private javax.swing.JLabel auxCajon1;
    private javax.swing.JLabel auxCajon2;
    private javax.swing.JLabel auxCajon3;
    private javax.swing.JButton btnExit;
    public javax.swing.JButton btnManagementAdmins;
    public javax.swing.JButton btnManagementUsers;
    public javax.swing.JButton btnStatics;
    private javax.swing.JLabel cajon;
    private javax.swing.JLabel cajon1;
    private javax.swing.JLabel cajon2;
    private javax.swing.JLabel cajon3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
