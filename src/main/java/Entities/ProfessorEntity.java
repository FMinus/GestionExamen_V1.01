/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.util.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;



@Entity("professor")
public class ProfessorEntity extends UserEntity {
    @Reference(lazy = true)
    public List<ModuleEntity> modules=new ArrayList<>();
    

    
    public ProfessorEntity() {
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }
    


    
 
    
    
    

    
}
