/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import mcq.core.dto.ExamDto;
import mcq.core.dto.NewQuestionDto;
import mcq.core.dto.OptionDto;
import mcq.core.dto.OptionsDto;
import mcq.core.dto.QuestionDto;
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

    public ResultSet getsetIdByName(String id) throws SQLException {
        ResultSet rs = this.repo.findOne(new String[][]{{"description", "=", id + ""}});
        return rs;
    }

    public ResultSet all() throws SQLException {
        return this.repo.all();
    }

    public ExamDto getQuestionWithOptionsById(int questionSetId) throws SQLException {
        ExamDto exam = new ExamDto();
        ResultSet rs = this.repo.raw("select * from questions left join question_set on questions.question_set_id = question_set.id where question_set.id = " + questionSetId);
        while (rs.next()) {
            int questionId = rs.getInt("questions.id");
            QuestionDto questionDto = new QuestionDto();
            questionDto.setId(rs.getInt("questions.id"));
            questionDto.setMark(rs.getInt("mark"));
            questionDto.setQuestion(rs.getString("questions.question"));
            questionDto.setRightAnswer(rs.getString("questions.correct_answer"));
            ResultSet optionsResultSet = this.repo.raw("select * from question_options left join questions on questions.id = question_options.question_id where questions.id =" + questionId);
            OptionsDto optionsDto = new OptionsDto();
            while (optionsResultSet.next()) {
                OptionDto optionDto = new OptionDto();
                optionDto.setId(optionsResultSet.getInt("question_options.id"));
                optionDto.setLabel(optionsResultSet.getString("question_options.label"));
                optionsDto.getOptions().add(optionDto);
            }
            questionDto.setOptions(optionsDto);
            exam.getQuestion().add(questionDto);
        }
        return exam;
    }
}
