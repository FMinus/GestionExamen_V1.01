/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import Entities.ExamenEntity;
import Entities.QuestionEntity;
import Entities.ResponseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Ayoub
 */
@ManagedBean
@SessionScoped
public class PasserExamen implements Serializable
{
    ExamenEntity examen;
    
    public ExamenEntity getExamen()
    {
        return examen;
    }
    
    public void setExamen(ExamenEntity examen)
    {
        this.examen = examen;
    }
    
    public PasserExamen(ExamenEntity examen)
    {
        this.examen = examen;
    }
    
    public PasserExamen()
    {
    }
    
    public void testExam()
    {
        this.examen = new ExamenEntity(null, null, null, null);
        examen.setQuestions(initQuestions(3, 3));
    }
    
    
    public ExamenEntity getTestExamen()
    {
        testExam();
        return this.examen;
    }
    
    public List<ResponseEntity> init3Rep(int numR)
    {
        List<ResponseEntity> listRep = new ArrayList<>();
        for(int i=1;i<numR+1;i++)
        {
            listRep.add(new ResponseEntity(i, "rep : "+i, false));
        }
        
        return listRep;
    }
    
    public List<QuestionEntity> initQuestions(int numQ,int numR)
    {
        List<QuestionEntity> listQuestions = new ArrayList<>();
        for(int i=1;i<numQ+1;i++)
        {
            listQuestions.add(new QuestionEntity(i,"quest : "+i, init3Rep(numR)));
        }
        
        return listQuestions;
    }
    
    public void printExam()
    {
        int i = 1;
        
        for(QuestionEntity q : examen.getQuestions())
        {
            System.out.print("Question "+i+" - "+q.getQuestion());
            System.out.println("\t : "+q.getResponses());
        }
    }
    
    public void examenGetter()
    {
        
    }
    
    public void startExamen()
    {
        if(examen != null && examen.getDateDebut() != null && examen.getDateFin() != null)
        {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() 
            {
                @Override
                public void run() 
                {
                    //TODO
                    //if examen dateFin > now : exit
                    if(examen.getDateFin().after(new Date()))
                    {
                        
                    }
                }
            }, 2*60*1000);
        }
    }
}
