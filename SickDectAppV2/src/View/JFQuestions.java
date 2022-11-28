package View;

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
public class JFQuestions extends javax.swing.JFrame {

    public JFQuestions() throws IOException{
        initComponents();
        this.setTitle("Preguntas de sintomas para confirmacion");
        this.setLocationRelativeTo(null);
        jtaQuestion.setEditable(false);
        jtaQuestion.setLineWrap(true);
        jtaQuestion.setWrapStyleWord(true);
        
        setJTAText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaQuestion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        lbTitle.setText("SICK DECT");
        jPanel1.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setText("RESPONDER LA PREGUNTA SEGUN SUS SINTOMAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        btnYes.setText("SI");
        btnYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });
        jPanel1.add(btnYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 75, -1));

        btnNo.setText("NO");
        btnNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 75, -1));

        jtaQuestion.setColumns(20);
        jtaQuestion.setRows(5);
        jScrollPane2.setViewportView(jtaQuestion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 270, 170));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MMolestia.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed
        try {
            this.btnYes.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            
            ArchiveManager am = new ArchiveManager();
            String sickness = am.getSicknessReferingQuestion(jtaQuestion.getText());
            String [] contact = sickness.split("%");
            am.saveInAuxResults(contact[0]);
            am.saveInAuxResults(contact[1]);
            am.saveInAuxResults(contact[2]);
            
            this.setVisible(false);
            JFResults next = new JFResults();
            next.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JFQuestions.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnYesActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        try {
            this.btnNo.setCursor(Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR));
            ArchiveManager am = new ArchiveManager();
            am.recreateAuxQuestions();
            
            if(getpass()){
                this.setVisible(false);
                JFQuestions newQuestion = new JFQuestions();
                newQuestion.setVisible(true);
            }
            else{
                File archiveOne = new File("Archives/auxQuestions.txt");
                File archiveTwo = new File("Archives/auxResults.txt");               
                if(!archiveOne.delete()){
                    System.out.println("No se puede eliminar auxQuestions");
                }
                if(!archiveTwo.delete()){
                    System.out.println("No se puede eliminar auxResults");
                }
                
                this.setVisible(false);
                JFMainSymptom back = new JFMainSymptom();
                back.setVisible(true);
                JFUtilBadMessage bm = new JFUtilBadMessage();
                bm.setMessage("NO SE PUEDE IDENTIFICAR LA ENFERMEDAD");
                bm.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(JFQuestions.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void setJTAText() throws FileNotFoundException, IOException{
        File questions = new File("Archives/auxQuestions.txt");
        FileReader fr = new FileReader(questions);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String [] contact = line.split("%");
        jtaQuestion.setText(contact[0]);
        br.close();
    }    
    
    public boolean getpass() throws FileNotFoundException, IOException{
        File archive = new File("Archives/auxQuestions.txt");
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        boolean tool = true;
        
        String [] contact = line.split("%");
        if(contact[0].equals("END")){
            tool = false;
        }
        br.close();
        return tool;
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
            java.util.logging.Logger.getLogger(JFQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFQuestions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFQuestions().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JFQuestions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnYes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtaQuestion;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
