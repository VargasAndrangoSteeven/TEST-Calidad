package View;

import View.JFUserLogin;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ArchiveManager;
import java.awt.Cursor;

/**
 *
 * @author SickDectTeam
 */
public class JFResults extends javax.swing.JFrame {

    public JFResults() throws FileNotFoundException, IOException {
        initComponents();
        this.setTitle("Resultados");
        this.setLocationRelativeTo(null);
        jtaDescription.setEditable(false);
        jtaDescription.setLineWrap(true);
        jtaDescription.setWrapStyleWord(true);
        jtaTreatment.setEditable(false);
        jtaTreatment.setLineWrap(true);
        jtaTreatment.setWrapStyleWord(true);
        
        setResultsFormat();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSickness = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescription = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaTreatment = new javax.swing.JTextArea();
        btnSaveNExit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        jPanel1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("RESULTADOS DEL SISTEMA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("ENFERMEDAD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("DESCRIPCION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setText("TRATAMIENTO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        lbSickness.setText("sickness");
        jPanel1.add(lbSickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 300, -1));

        jtaDescription.setColumns(20);
        jtaDescription.setRows(5);
        jScrollPane1.setViewportView(jtaDescription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 270, 120));

        jtaTreatment.setColumns(20);
        jtaTreatment.setRows(5);
        jScrollPane2.setViewportView(jtaTreatment);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 270, 120));

        btnSaveNExit.setText("GUARDAR Y SALIR");
        btnSaveNExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveNExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveNExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Sin título-1.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveNExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNExitActionPerformed
        try {
            this.btnSaveNExit.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            ArchiveManager am = new ArchiveManager();
            am.createResultFile();
            this.setVisible(false);
            
            JFUserLogin backtoback = new JFUserLogin();
            backtoback.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JFResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSaveNExitActionPerformed

    /**
     * @return 
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
            getImage(ClassLoader.getSystemResource("resources/iconSystem.png"));
    return retValue;
    }
    
    public void setResultsFormat() throws FileNotFoundException, IOException{
        File results = new File("Archives/auxResults.txt");
        FileReader fr = new FileReader(results);
        BufferedReader br = new BufferedReader(fr);
        
        String user = br.readLine();
        lbSickness.setText(br.readLine());
        jtaDescription.setText(br.readLine());
        jtaTreatment.setText(br.readLine());
        br.close();
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
            java.util.logging.Logger.getLogger(JFResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFResults().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JFResults.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveNExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtaDescription;
    private javax.swing.JTextArea jtaTreatment;
    private javax.swing.JLabel lbSickness;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
