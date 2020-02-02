/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import mcq.Utils;
import mcq.core.dto.NewQuestionDto;
import mcq.core.services.Question;
import mcq.core.services.QuestionSet;
import mcq.core.services.Subject;

/**
 *
 * @author samundra-sage
 */
public class AddQuestion extends javax.swing.JFrame {

    private String rightAnswer = "";
    private String[] options = new String[]{"A", "B", "C", "D"};
    private JRadioButton[] answerRadios;

    /**
     * Creates new form AddQuestion
     */
    public AddQuestion() {
        initComponents();
        answerRadios = new JRadioButton[]{rightAnswerA, rightAnswerB, rightAnswerC, rightAnswerD};
        this.loadQuestionSet();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void loadQuestionSet() {
        try {
            ArrayList<String[]> rs = Utils.resultSetToCollection(new QuestionSet().all(), "description");

            Iterator it = rs.iterator();
            while (it.hasNext()) {
                String[] val = (String[]) it.next();
                System.out.println(val[1]);
                questionSetCombo.addItem(val[1]);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionSetForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void handleRightAnswer(String selected) {
        for (JRadioButton option : answerRadios) {
            System.out.println(option.getActionCommand());
            if (option.getText() != selected) {
                option.setSelected(false);
            } else {
                rightAnswer = selected;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        questionSetCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionInput = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        marksInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        optionA = new javax.swing.JTextField();
        optionB = new javax.swing.JTextField();
        optionC = new javax.swing.JTextField();
        optionD = new javax.swing.JTextField();
        rightAnswerA = new javax.swing.JRadioButton();
        rightAnswerB = new javax.swing.JRadioButton();
        rightAnswerC = new javax.swing.JRadioButton();
        rightAnswerD = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Question Set");

        jLabel2.setText("Question");

        questionInput.setColumns(20);
        questionInput.setRows(5);
        jScrollPane1.setViewportView(questionInput);

        jLabel3.setText("Mark");

        jLabel4.setText("Options");

        rightAnswerA.setText("A");
        rightAnswerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightAnswerAActionPerformed(evt);
            }
        });

        rightAnswerB.setText("B");
        rightAnswerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightAnswerBActionPerformed(evt);
            }
        });

        rightAnswerC.setText("C");
        rightAnswerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightAnswerCActionPerformed(evt);
            }
        });

        rightAnswerD.setText("D");
        rightAnswerD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightAnswerDActionPerformed(evt);
            }
        });

        jButton1.setText("Create Question");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Enter options");

        jLabel6.setText("Mark Right");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addComponent(questionSetCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(marksInput))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(optionD, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(optionA, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(optionC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(optionB, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rightAnswerA)
                                    .addComponent(rightAnswerB)
                                    .addComponent(rightAnswerC)
                                    .addComponent(rightAnswerD)
                                    .addComponent(jLabel6))))))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(questionSetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(marksInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(optionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightAnswerA)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightAnswerB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightAnswerC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightAnswerD))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rightAnswerAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightAnswerAActionPerformed
        this.handleRightAnswer(evt.getActionCommand());
    }//GEN-LAST:event_rightAnswerAActionPerformed

    private void rightAnswerDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightAnswerDActionPerformed
        this.handleRightAnswer(evt.getActionCommand());
    }//GEN-LAST:event_rightAnswerDActionPerformed

    private void rightAnswerCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightAnswerCActionPerformed
        this.handleRightAnswer(evt.getActionCommand());
    }//GEN-LAST:event_rightAnswerCActionPerformed

    private void rightAnswerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightAnswerBActionPerformed
        this.handleRightAnswer(evt.getActionCommand());
    }//GEN-LAST:event_rightAnswerBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String questionSet = (String) questionSetCombo.getSelectedItem();
            String question = questionInput.getText();
            String[] options = new String[]{optionA.getText(), optionB.getText(), optionC.getText(), optionD.getText()};
            String mark = marksInput.getText();
            if (rightAnswer.isEmpty() || mark.isEmpty() || question.isEmpty()) {
                return;
            }

            NewQuestionDto newQuestionDto = new NewQuestionDto();
            newQuestionDto.setMarks(Integer.parseInt(mark));
            newQuestionDto.setQuestion(question);
            newQuestionDto.setOptions(options);
            newQuestionDto.setRightAnswer(rightAnswer);
            newQuestionDto.setQuestionSet(questionSet);

            new Question().createNewQuestion(newQuestionDto);
            JOptionPane.showMessageDialog(this, "Question saved");
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marksInput;
    private javax.swing.JTextField optionA;
    private javax.swing.JTextField optionB;
    private javax.swing.JTextField optionC;
    private javax.swing.JTextField optionD;
    private javax.swing.JTextArea questionInput;
    private javax.swing.JComboBox questionSetCombo;
    private javax.swing.JRadioButton rightAnswerA;
    private javax.swing.JRadioButton rightAnswerB;
    private javax.swing.JRadioButton rightAnswerC;
    private javax.swing.JRadioButton rightAnswerD;
    // End of variables declaration//GEN-END:variables
}
