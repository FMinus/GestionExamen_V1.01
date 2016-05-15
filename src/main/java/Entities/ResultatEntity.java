/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.*;

/**
 *
 * @author AbdelMajid
 */
@Entity(value = "resultat" ,noClassnameStored = true)
public class ResultatEntity extends BaseEntity
{
    
    @Reference 
    public ExamenEntity exam;    
    
    public  int note;
    

    public ResultatEntity() 
    {
    }

    public ExamenEntity getExam() {
        return exam;
    }

    public void setExam(ExamenEntity exam) {
        this.exam = exam;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
}