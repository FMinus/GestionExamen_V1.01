/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.ExamenEntity;
import Entities.ModuleEntity;
import Entities.QuestionEntity;
import Entities.ResponseEntity;
import Metier.MetierImpl.ExamMetierI;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AbdelMajid
 */
@ManagedBean
@SessionScoped
public class SaisieExamB {
    private QuestionEntity question;
    private List<QuestionEntity> questions;
    private List<ResponseEntity> responses;
    private ResponseEntity response;
    private ExamMetierI metierI;
    private ExamenEntity exam;
    private ModuleEntity module;

    public QuestionEntity getQuestion() {
        return question;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public List<ResponseEntity> getResponses() {
        return responses;
    }

    public ResponseEntity getResponse() {
        return response;
    }

    public ExamMetierI getMetierI() {
        return metierI;
    }

    public ExamenEntity getExam() {
        return exam;
    }

    public ModuleEntity getModule() {
        return module;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public void setResponses(List<ResponseEntity> responses) {
        this.responses = responses;
    }

    public void setResponse(ResponseEntity response) {
        this.response = response;
    }

    public void setExam(ExamenEntity exam) {
        this.exam = exam;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
    }

    
    
    
}
