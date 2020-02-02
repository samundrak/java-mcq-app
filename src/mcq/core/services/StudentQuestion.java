/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.StudentQuestionRepo;
import mcq.core.repositories.SubjectRepository;

/**
 *
 * @author samundra-sage
 */
public class StudentQuestion {

    Repository repo;

    public StudentQuestion() {
        this.repo = new StudentQuestionRepo();
    }

    public void create(int userId, String questionSetName) throws SQLException {
        ResultSet questionSetRs = new QuestionSet().getsetIdByName(questionSetName);
        questionSetRs.next();
        int questionSetId = questionSetRs.getInt("id");
        this.repo.create(new String[][]{{"student_id", userId + ""}, {"question_set_id", questionSetId + ""}});
    }
}
