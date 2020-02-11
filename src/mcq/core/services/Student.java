/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import mcq.core.Strings;
import mcq.core.dto.StudentDashboardDto;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.QuestionRepo;
import mcq.core.repositories.StudentRepo;
import mcq.core.repositories.UserRepo;

/**
 *
 * @author samundra-sage
 */
public class Student {

    StudentRepo repo;

    public Student() {
        this.repo = new StudentRepo();
    }

    public ArrayList<HashMap<String, String>> getDashContents(int userId) throws SQLException {
        ResultSet rs = this.repo.getAssignedQuestionSets(userId);
        ArrayList<StudentDashboardDto> sdto = new ArrayList<StudentDashboardDto>();
        ArrayList<HashMap<String, String>> dash = new ArrayList<HashMap<String, String>>();

        while (rs.next()) {
            HashMap<String, String> hm = new HashMap<>();
            Question qr = new Question();
            ResultSet noOfQuestions = qr.getQuestionCountById(rs.getInt("question_set_id"));
            hm.put(Strings.QUESTION_SET_ID, rs.getString("question_set_id"));
            hm.put(Strings.EXAM_SET_NAME, rs.getString("description"));
            hm.put(Strings.FULL_MARKS, rs.getString("full_marks"));
            hm.put(Strings.NO_OF_QUESTIONS, noOfQuestions.getString("noOfQuestion"));
            hm.put(Strings.QUESTION_ATTEMPTED, this.getAnswersAttempted(rs.getString("question_set_id"), userId) + "");
            dash.add(hm);
        }
        return dash;
    }

    public int getAnswersAttempted(String questionId, int userId) throws SQLException {
        ResultSet rs = this.repo.raw("select count(answers.id) as answersCount from question_set "
                + "left join questions on questions.question_set_id = question_set.id\n"
                + "left join answers on answers.question_id = questions.id where question_set.id = " + questionId + " and answers.user_id = " + userId);

        rs.next();
        return rs.getInt("answersCount");
    }

    public String getAnswerer(String questionId) throws SQLException {
        ResultSet rs = this.repo.raw("select   CONCAT(users.first_name, ' ', users.last_name) as answerer  from question_set \n"
                + "left join questions on questions.question_set_id = question_set.id\n"
                + "left join answers on answers.question_id = questions.id \n"
                + "left join users on answers.user_id= users.id\n"
                + "where question_set.id = " + questionId);

        rs.next();
        return rs.getString("answerer");
    }

    public ArrayList<HashMap<String, String>> getDashContentsForAdmin() throws SQLException {
        ResultSet rs = this.repo.getQuestionSets();
        ArrayList<StudentDashboardDto> sdto = new ArrayList<StudentDashboardDto>();
        ArrayList<HashMap<String, String>> dash = new ArrayList<HashMap<String, String>>();

        while (rs.next()) {
            HashMap<String, String> hm = new HashMap<>();
            Question qr = new Question();
            ResultSet noOfQuestions = qr.getQuestionCountById(rs.getInt("question_set_id"));
            hm.put(Strings.QUESTION_SET_ID, rs.getString("question_set_id"));
            hm.put(Strings.EXAM_SET_NAME, rs.getString("description"));
            hm.put(Strings.FULL_MARKS, rs.getString("full_marks"));
            hm.put(Strings.NO_OF_QUESTIONS, noOfQuestions.getString("noOfQuestion"));
            hm.put(Strings.STUDENT_NAME, this.getAnswerer(rs.getString("question_set_id")) + "");
            dash.add(hm);
        }
        return dash;
    }

}
