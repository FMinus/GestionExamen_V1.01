/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.ExamenEntity;
import Entities.QuestionEntity;
import Entities.ResponseEntity;
import Metier.MetierImpl.ExamMetierI;
import Metier.MetierImpl.ExamMetierImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AbdelMajid
 */

@ManagedBean(name = "exambm")
@SessionScoped
public class ExamenMB implements Serializable{    
    private ExamMetierI metier;
    private ExamenEntity examenEntity;
    private List<QuestionEntity> questions;
    
    
    
    private List<ResponseEntity> reponseselectionne;

    public List<ResponseEntity> getReponseselectionne() {
        return reponseselectionne;
    }
    @PostConstruct
    public void init(){
           reponseselectionne=new ArrayList<>();
    }
    public void submit(){
        System.out.println("Selected Item"+reponseselectionne.size());
    }
            
   // private List<HashMap<String,Boolean>> listDesResultats=new ArrayList<>();
    

 /*   public List<HashMap<String, Boolean>> getListDesResultats() {
        return listDesResultats;
    }

    public void setListDesResultats(List<HashMap<String, Boolean>> listDesResultats) {
        this.listDesResultats = listDesResultats;
    }
*/


   
    

   

    
    
   
    public List<ResponseEntity> rs(QuestionEntity q){
       if(responses!=null) responses.clear();
   return responses=q.getResponses();
    }
     
     
    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }
    
    private String fileName;
    private List<ResponseEntity> responses;

    public List<ResponseEntity> getResponses() {
        return responses;
    }

    public void setResponses(List<ResponseEntity> responses) {
        this.responses = responses;
    }

    public ExamenEntity getExamenEntity() {
        return examenEntity;
    }

    public void setExamenEntity(ExamenEntity examenEntity) {
        this.examenEntity = examenEntity;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void monEntitie(){
        metier=new ExamMetierImpl();  
      examenEntity=  metier.getExam(fileName);
      if(examenEntity!=null){
      questions=examenEntity.getQuestions();
      }
    }
   
    public void getXmL(ExamenEntity e){
      metier.sendExam(e);
    }
    public void parcourir_xml(ExamenEntity e){
    metier.parcourir_xml(e);
    }
   /* public HashMap<String,Boolean> toResultat(QuestionEntity q){
       map.clear();
       for(ResponseEntity r:q.getResponses()){
          map.put(r.getReponse(), r.isBool());
       }
        listDesResultats.add(map);
        
        return map;
      
                          }*/
    
    public ExamenMB() {
        
        fileName="";
        examenEntity=null;
        questions=null;
        responses=null;
        
        
    }
    
    
}
