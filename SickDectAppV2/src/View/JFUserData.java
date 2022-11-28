package View;

import Model.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SickDectTeam
 */
public class JFUserData extends javax.swing.JFrame {

    public JFUserData() {
        initComponents();
        this.setTitle("Salida del Sistema");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExitStatePanel = new javax.swing.JPanel();
        lbQuestion = new javax.swing.JLabel();
        btnGoBackS = new javax.swing.JButton();
        lbQuestion1 = new javax.swing.JLabel();
        lbQuestion2 = new javax.swing.JLabel();
        lbQuestion3 = new javax.swing.JLabel();
        lbQuestion4 = new javax.swing.JLabel();
        lbQuestion5 = new javax.swing.JLabel();
        lbQuestion6 = new javax.swing.JLabel();
        lbQuestion7 = new javax.swing.JLabel();
        lbQuestion8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        txtTexture = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        btnConsult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        ExitStatePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 0), null, null));

        lbQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion.setText("Datos");

        btnGoBackS.setText("REGRESAR");
        btnGoBackS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackSActionPerformed(evt);
            }
        });

        lbQuestion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion1.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion1.setText("Nombre:");

        lbQuestion2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion2.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion2.setText("Apellido");

        lbQuestion3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion3.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion3.setText("Edad");

        lbQuestion4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion4.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion4.setText("Genero");

        lbQuestion5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion5.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion5.setText("Peso");

        lbQuestion6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion6.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion6.setText("Contextura");

        lbQuestion7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion7.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion7.setText("Altura");

        lbQuestion8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuestion8.setForeground(new java.awt.Color(255, 0, 0));
        lbQuestion8.setText("Ubicacion");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnConsult.setText("CONSULTAR");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExitStatePanelLayout = new javax.swing.GroupLayout(ExitStatePanel);
        ExitStatePanel.setLayout(ExitStatePanelLayout);
        ExitStatePanelLayout.setHorizontalGroup(
            ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitStatePanelLayout.createSequentialGroup()
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExitStatePanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExitStatePanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbQuestion6))
                            .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbQuestion8)
                                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbQuestion2)
                                    .addComponent(lbQuestion1)
                                    .addComponent(lbQuestion3)
                                    .addComponent(lbQuestion4)
                                    .addComponent(lbQuestion5))
                                .addComponent(lbQuestion7, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(ExitStatePanelLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbQuestion)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTexture, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitStatePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConsult)
                .addGap(64, 64, 64)
                .addComponent(btnGoBackS)
                .addGap(116, 116, 116))
        );
        ExitStatePanelLayout.setVerticalGroup(
            ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitStatePanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbQuestion)
                .addGap(29, 29, 29)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion2)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion3)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion4)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion5)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion6)
                    .addComponent(txtTexture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion7)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuestion8)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(ExitStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBackS)
                    .addComponent(btnConsult))
                .addGap(24, 24, 24))
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

    private void btnGoBackSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackSActionPerformed

        // TODO add your handling code here:
        this.setVisible(false);
        try {
            JFMainSymptom back = new JFMainSymptom();
            back.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JFUserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGoBackSActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
        try {
            // TODO add your handling code here:
            Conexion objConexion = new Conexion();

            String temp = "";

            Connection acceso = objConexion.obtenerConexion();
            String sql1 = "SELECT user from temp";
            PreparedStatement pa1 = acceso.prepareStatement(sql1);
            ResultSet rsl = pa1.executeQuery();
            while (rsl.next()) {
                temp = rsl.getString(1);
            }

            String name = "select name from client where user = ?";
            String cname = "";
            PreparedStatement pa = acceso.prepareStatement(name);
            pa.setString(1, temp);
            ResultSet rs1 = pa.executeQuery();
            while (rs1.next()) {
                cname = rs1.getString(1);
            }

            this.txtName.setText(cname);

            String lastname = "select lastName from client where user = ?";
            String clastname = "";
            PreparedStatement pa0 = acceso.prepareStatement(lastname);
            pa0.setString(1, temp);
            ResultSet rs0 = pa0.executeQuery();
            while (rs0.next()) {
                clastname = rs0.getString(1);
            }

            this.txtLastName.setText(clastname);

            String age = "select age from client where user = ?";

            String cage = "";
            PreparedStatement pa2 = acceso.prepareStatement(age);
            pa2.setString(1, temp);
            ResultSet rs2 = pa2.executeQuery();
            while (rs2.next()) {
                cage = rs2.getString(1);
            }
            this.txtAge.setText(cage);

            String gender = "select gender from client where user = ?";
            String cgender = "";
            PreparedStatement pa3 = acceso.prepareStatement(gender);
            pa3.setString(1, temp);
            ResultSet rs3 = pa3.executeQuery();
            while (rs3.next()) {
                cgender = rs3.getString(1);
            }
            this.txtGender.setText(cgender);

            String weight = "select weight from client where user = ?";
            String cweight = "";
            PreparedStatement pa4 = acceso.prepareStatement(weight);
            pa4.setString(1, temp);
            ResultSet rs4 = pa4.executeQuery();
            while (rs4.next()) {
                cweight = rs4.getString(1);
            }
            this.txtWeight.setText(cweight);

            String texture = "select texture from client where user = ?";
            String ctexture = "";
            PreparedStatement pa5 = acceso.prepareStatement(texture);
            pa5.setString(1, temp);
            ResultSet rs5 = pa5.executeQuery();
            while (rs5.next()) {
                ctexture = rs5.getString(1);
            }
            this.txtTexture.setText(ctexture);

            String height = "select height from client where user = ?";
            String cheight = "";
            PreparedStatement pa6 = acceso.prepareStatement(height);
            pa6.setString(1, temp);
            ResultSet rs6 = pa6.executeQuery();
            while (rs6.next()) {
                cheight = rs6.getString(1);
            }
            this.txtHeight.setText(cheight);

            String location = "select location from client where user = ?";
            String clocation = "";
            PreparedStatement pa7 = acceso.prepareStatement(location);
            pa7.setString(1, temp);
            ResultSet rs7 = pa7.executeQuery();
            while (rs7.next()) {
                clocation = rs7.getString(1);
            }
            this.txtLocation.setText(clocation);

            String drop = "DROP TABLE temp";
            PreparedStatement dropPS = acceso.prepareStatement(drop);

            dropPS.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JFUserData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnConsultActionPerformed

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
            java.util.logging.Logger.getLogger(JFUserData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUserData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUserData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUserData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFUserData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExitStatePanel;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnGoBackS;
    private javax.swing.JLabel lbQuestion;
    private javax.swing.JLabel lbQuestion1;
    private javax.swing.JLabel lbQuestion2;
    private javax.swing.JLabel lbQuestion3;
    private javax.swing.JLabel lbQuestion4;
    private javax.swing.JLabel lbQuestion5;
    private javax.swing.JLabel lbQuestion6;
    private javax.swing.JLabel lbQuestion7;
    private javax.swing.JLabel lbQuestion8;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTexture;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
