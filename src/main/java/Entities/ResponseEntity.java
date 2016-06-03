/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 *
 * @author AbdelMajid
 */

public class ResponseEntity implements Serializable{
    private int Id;
    private String reponse;
    private boolean bool;

    public boolean isBool() {
        return bool;
    }
    @XmlAttribute(name = "isTrue",required = true)
    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public ResponseEntity() {
    }
   @XmlAttribute(name = "id",required = false)
    public int getId() {
        return Id;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getReponse() {
        return reponse;
    }
    
    public void setReponse(String laReponse) {
        this.reponse = laReponse;
    }
    
    
}
