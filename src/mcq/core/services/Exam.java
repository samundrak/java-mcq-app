package mcq.core.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import mcq.core.dto.ExamDto;
import mcq.core.dto.QuestionDto;
import mcq.core.dto.ReportDto;
import mcq.core.dto.ReportFormat;
import mcq.core.interfaces.Repository;
import mcq.core.repositories.AnswersRepo;

/**
 *
 * @author samundra-sage
 */
public class Exam {

    Repository repo = new AnswersRepo();
    private int questionIndex = 0;

    public ExamDto getAllQuestionsBySet(int id) throws SQLException {
        QuestionSet qs = new QuestionSet();
        ExamDto rs = qs.getQuestionWithOptionsById(id);

        return rs;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public void submitAnswer(ExamDto examDto, int userId) throws SQLException {
        Iterator it = examDto.getQuestion().iterator();
        Answers answer = new Answers();
        while (it.hasNext()) {
            QuestionDto dto = (QuestionDto) it.next();
            answer.addAnswerOfQuestionId(userId, dto.getId(), Integer.parseInt(dto.getSelectedAnswer()));
        }
    }

    public ReportDto getResultByQuestionSet(int questionSet) throws SQLException {
        System.out.println(questionSet);
        ResultSet rs = this.repo.raw("select questions.question, questions.mark, question_options.label as rightAnswer, qs.label as userAnswer, qs.is_correct as isCorrect from questions \n"
                + "left join question_set on questions.question_set_id = question_set.id \n"
                + "left join question_options on question_options.question_id = questions.id\n"
                + "left join answers on answers.question_id =questions.id\n"
                + "left join question_options as qs on qs.id = answers.answer_id\n"
                + "where questions.question_set_id  =  " + questionSet + "\n"
                + "and question_options.is_correct = 1");
        ReportDto reportDto = new ReportDto();

        while (rs.next()) {
            ReportFormat reportFormat = new ReportFormat();
            System.out.println(rs.getString("question"));
            reportFormat.setQuestion(rs.getString("question"));
            reportFormat.setRightAnswer(rs.getString("rightAnswer"));
            reportFormat.setSelectedAnswer(rs.getString("userAnswer"));
            reportFormat.setMarksObtained(rs.getInt("isCorrect") == 1 ? rs.getInt("mark") : 0);
            reportDto.report.add(reportFormat);
        }

        return reportDto;
    }
}
