/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samundra-sage
 */
public class StudentRepo extends UserRepo {

    public ResultSet getAssignedQuestionSets(int userId) throws SQLException {
        String query = "select * from question_set, users, student_question \n"
                + "where student_question.student_id = users.id \n"
                + "and question_set.id =  student_question.question_set_id\n"
                + "and student_question.student_id = " + userId;

        return this.dbq.execQuery(query);
    }

}
