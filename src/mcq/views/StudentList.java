/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import mcq.core.services.Subject;
import mcq.core.services.User;

/**
 *
 * @author samundra-sage
 */
public class StudentList extends javax.swing.JFrame {

    /**
     * Creates new form StudentList
     */
    public StudentList() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        loadStudents();
    }

    public void loadStudents() {
        try {
            sutdents.removeAll();
            DefaultTableModel dtm = (DefaultTableModel) sutdents.getModel();
            dtm.setRowCount(0);

            TableColumn col = new TableColumn();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("username");
            dtm.addColumn("password");
            this.feedTable();

        } catch (Exception ex) {
            Logger.getLogger(SubjectList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void feedTable() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) sutdents.getModel();
            dtm.setRowCount(0);

            ResultSet rs = new User().all();
            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("first_name") + " " + rs.getString("last_name"));
                v.add(rs.getString("username"));
                v.add(rs.getString("password"));
                dtm.addRow(v);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sutdents = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        questionSetBtn = new javax.swing.JButton();
        createUserBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sutdents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(sutdents);

        jLabel1.setText("Actions");

        questionSetBtn.setText("Assign a QuestionSet");
        questionSetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionSetBtnActionPerformed(evt);
            }
        });

        createUserBtn.setText("Create Username/Password");
        createUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Reload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(451, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionSetBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createUserBtn)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(questionSetBtn)
                    .addComponent(createUserBtn)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void questionSetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionSetBtnActionPerformed
        // TODO add your handling code here:
        int row = sutdents.getSelectedRow();
        if (row < -1) {
            return;
        }
        int id = (int) sutdents.getModel().getValueAt(row, 0);

        new StudentQuestionAssign(id).show();
    }//GEN-LAST:event_questionSetBtnActionPerformed

    private void createUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserBtnActionPerformed
        // TODO add your handling code here:
        int row = sutdents.getSelectedRow();
        if (row < -1) {
            return;
        }
        int id = (int) sutdents.getModel().getValueAt(row, 0);

        new CreateUser(id).show();
    }//GEN-LAST:event_createUserBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.feedTable();;

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createUserBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton questionSetBtn;
    private javax.swing.JTable sutdents;
    // End of variables declaration//GEN-END:variables
}
