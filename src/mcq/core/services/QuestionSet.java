/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samundra-sage
 */
public class QuestionSet extends DBConnected {

    public int add(String subject, String questionSetName, String marks) throws SQLException {
        ResultSet subjectRs = new Subject().getSubjectIdByName(Integer.parseInt(subject));
//        QueryBuilder qb = new QueryBuilder();
//        qb.insert("question_set", new String[][]{{"full_marks", marks}, {"subject_id", "1"}, {"description", questionSetName}, {"user_id", "" + Session.getInstance().user.getId()}});
//        System.out.println(qb.getQuery());

        return 1;
    }
}
