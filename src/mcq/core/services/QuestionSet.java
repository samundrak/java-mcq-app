/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.QuestionSetRepo;

/**
 *
 * @author samundra-sage
 */
public class QuestionSet {

    Repository repo;

    public QuestionSet() {
        this.repo = new QuestionSetRepo();
    }

    public int create(String subject, String questionSetName, String marks) throws SQLException {
        ResultSet subjectRs = new Subject().getSubjectIdByName(subject);
        subjectRs.next();
        int subjectId = subjectRs.getInt("id");
        return this.repo.create(
                new String[][]{{"full_marks", marks}, {"subject_id", subjectId + ""}, {"description", questionSetName}, {"user_id", "" + Session.getInstance().user.getId()}}
        );
    }
}
