/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 *
 * @author AbdelMajid
 */
public class QuestionEntity 
{
    
    private int Id;
    private String question;
    private  List<ResponseEntity> responses;


    
    public List<ResponseEntity> getResponses() {
        return responses;
    }
    @XmlElement
    public void setResponses(List<ResponseEntity> responses) {
        this.responses = responses;
    }

    public QuestionEntity(int Id, String question, List<ResponseEntity> responses)
    {
        this.Id = Id;
        this.question = question;
        this.responses = responses;
    }
    
    
    public QuestionEntity() 
    {
        responses=new ArrayList<>();
    }

    public int getId() 
    {
        return Id;
    }
    
    @XmlAttribute
    public void setId(int Id) 
    {
        this.Id = Id;
    }
    
    public String getQuestion() 
    {
        return question;
    }
   
    public void setQuestion(String énoncé) 
    {
        this.question = énoncé;
    }

    @Override
    public String toString()
    {
        return "Question{" + "Id=" + Id + ", question=" + question + ", responses=" + responses + '}';
    }
    
    
}
