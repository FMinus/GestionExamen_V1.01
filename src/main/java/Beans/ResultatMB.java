/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import Entities.ExamenEntity;
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
@ManagedBean
@SessionScoped
public class ResultatMB  implements Serializable{
    private  ExamenEntity exam;
    private List<String> note ;
    
    public void setNote(List<String> note) {
        this.note = note;
    }
    private List<String> noteS;
    
    public void setNoteS(List<String> noteS) {
        this.noteS = noteS;
    }
    
    public List<String> getNoteS() {
        return noteS;
    }
    
    @PostConstruct
    public void init()
    {
        note=new ArrayList<>();
        note.add("12");
        note.add("11");
        note.add("14");
        
    }
    public void submit(){
        System.out.println("Selectted" +noteS);
    }
    
    public ExamenEntity getExam() {
        return exam;
    }
    
    public void setExam(ExamenEntity exam) {
        this.exam = exam;
    }
    
    public List<String> getNote() {
        return note;
    }
    
    
    
}
