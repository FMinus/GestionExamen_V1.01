/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.mongodb.morphia.annotations.*;


/**
 *
 * @author AbdelMajid
 */
@Entity(value = "examen" ,noClassnameStored = true)
public class ExamenEntity extends BaseEntity
{
    @Temporal(value = TemporalType.DATE)
    private Date date;
    
    @Reference
    private ModuleEntity modules;
    
    public ExamenEntity() 
    {        
    }
    public Date getDate() 
    {
        return date;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }
    public ExamenEntity(Date t,ModuleEntity m) 
    {
        this.modules=m;
        this.date=t;
    }
   
    
     
     
    
}
