/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.SQLException;
import mcq.core.interfaces.Repository;

/**
 *
 * @author samundra-sage
 */
public class QuestionOptions {

    Repository repo;

    public QuestionOptions() {
        this.repo = new mcq.core.repositories.QuestionOptions();
    }

    public int create(String label, int questionId, int isCorrect) throws SQLException {
        return this.repo.create(new String[][]{{"label", label}, {"is_correct", isCorrect + ""}, {"question_id", questionId + ""}});
    }
}
