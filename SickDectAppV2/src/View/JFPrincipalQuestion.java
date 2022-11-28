package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
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
public class JFPrincipalQuestion extends javax.swing.JFrame {

    public JFPrincipalQuestion() {
        try {
            initComponents();
            this.setTitle("Validacion de enfermedad");
            this.setLocationRelativeTo(null);
            jtaPrincipalQuestion.setEditable(false);
            jtaPrincipalQuestion.setLineWrap(true);
            jtaPrincipalQuestion.setWrapStyleWord(true);
            
            setPrincipalQuestionText();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaPrincipalQuestion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        jPanel1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("RESPONDER LA AFIRMACION SEGUN SUS SINTOMAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        btnYes.setText("SI");
        btnYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });
        jPanel1.add(btnYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        btnNo.setText("NO");
        btnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        jtaPrincipalQuestion.setColumns(20);
        jtaPrincipalQuestion.setRows(5);
        jScrollPane1.setViewportView(jtaPrincipalQuestion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 250, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MMolestia.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed
        try {
            this.btnYes.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            ArchiveManager am = new ArchiveManager();
            am.createAuxQuestions(true);
            
            this.setVisible(false);
            JFQuestions next = new JFQuestions();
            next.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnYesActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        try {
            this.btnNo.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            ArchiveManager am = new ArchiveManager();
            am.createAuxQuestions(false);
            
            this.setVisible(false);
            JFQuestions next = new JFQuestions();
            next.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNoActionPerformed

    /**
     * @return 
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
            getImage(ClassLoader.getSystemResource("resources/iconSystem.png"));
    return retValue;
    }
    
    public void setPrincipalQuestionText() throws IOException{
        ArchiveManager am = new ArchiveManager();
        String mainSymptom = am.readMainSymptomArchive();

        ArrayList<String> arrFiles = am.listSymptoms();
        for(String aux : arrFiles){
            if(mainSymptom.equals(aux)){
                FileReader fr = new FileReader(am.getFile(aux));
                try (BufferedReader br = new BufferedReader(fr)) {
                    String symptom = br.readLine();
                    jtaPrincipalQuestion.setText(br.readLine());
                    am.createQuestionsPathArchive(aux);
                    br.close();
                }    
            }
        }
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
            java.util.logging.Logger.getLogger(JFPrincipalQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFPrincipalQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnYes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaPrincipalQuestion;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
