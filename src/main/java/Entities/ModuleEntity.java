/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.*;

/**
 *
 * @author AbdelMajid
 */
@Entity(value="module",noClassnameStored = true)
public class ModuleEntity extends BaseEntity{
    
   
    private String ModuleName;
    
    @Reference
    public List<ExamenEntity> examens=new ArrayList<>();
    
    @Reference
    public ProfessorEntity profOwner; 

    public ModuleEntity() 
    {
        
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String ModuleName) 
    {
        this.ModuleName = ModuleName;
    }
    

    public ModuleEntity(String name,ProfessorEntity p) 
    {
        this.ModuleName=name;
        this.profOwner=p;
    }

    public ModuleEntity(String ModuleName) 
    {
        this.ModuleName = ModuleName;
    }
    

    
    
}
