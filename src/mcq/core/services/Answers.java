/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.AnswersRepo;

/**
 *
 * @author samundra-sage
 */
public class Answers {

    Repository repo;

    public Answers() {
        this.repo = new AnswersRepo();
    }

    public ResultSet getAnswersOfQuestionSet(int questionId, int userId) throws SQLException {
        ResultSet rs = this.repo.find(new String[][]{{}});
        return rs;
    }
}
