/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.dto.NewQuestionDto;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.QuestionRepo;

/**
 *
 * @author samundra-sage
 */
public class Question {

    Repository repo;

    public Question() {
        this.repo = new QuestionRepo();
    }

    public int create(String question, int questionSetId, String rightAnswer, int mark) throws SQLException {
        return this.repo.create(new String[][]{{"question", question}, {"correct_answer", rightAnswer}, {"mark", mark + ""}, {"question_set_id", questionSetId + ""}});
    }

    public ResultSet getQuestionID(String id) throws SQLException {
        ResultSet rs = this.repo.findOne(new String[][]{{"description", "=", id + ""}});
        return rs;
    }

    public int createNewQuestion(NewQuestionDto newQuestion) throws SQLException {
        ResultSet questionSetRs = new QuestionSet().getsetIdByName(newQuestion.getQuestionSet());
        questionSetRs.next();
        int questionSetId = questionSetRs.getInt("id");
        this.create(newQuestion.getQuestion(), questionSetId, newQuestion.getRightAnswer(), newQuestion.getMarks());

        ResultSet rs = this.repo.findOne(new String[][]{{"question", "=", newQuestion.getQuestion()}, {"correct_answer", "=", newQuestion.getRightAnswer()}});
        rs.next();
        int questionId = rs.getInt("id");
        for (String option : newQuestion.getOptions()) {
            new QuestionOptions().create(option, questionId);
        }

        System.out.println(questionSetId);

        return -1;
    }
}
