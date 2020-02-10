/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.dto;

import java.util.ArrayList;

/**
 *
 * @author samundra-sage
 */
public class ExamDto {

    ArrayList<QuestionDto> question = new ArrayList<>();

    public ArrayList<QuestionDto> getQuestion() {
        return question;
    }

}
