/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.dto;

/**
 *
 * @author samundra-sage
 */
public class ExamDto {
    
    QuestionDto question;

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }
    
}
