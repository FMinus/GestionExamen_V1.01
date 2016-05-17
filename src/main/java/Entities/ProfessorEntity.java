/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import Metier.Module;
import Metier.Professor;
import java.util.*;
import org.mongodb.morphia.annotations.*;



@Entity("professor")
public class ProfessorEntity extends UserEntity 
{
    
    
    @Reference(lazy = true)
    public List<ModuleEntity> modules=new ArrayList<>();
    
    
    public ProfessorEntity() 
    {
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) 
    {
        this.modules = modules;
    }
    
    public Professor toProfessor()
    {
        //public Professor(String firstName, String lastName, Date dateOfBirth, String email, String urlAvatar, String password,List<Module> modules)
        List<Module> listModule = new ArrayList<>();
        for(ModuleEntity mod : this.getModules())
        {
            listModule.add(mod.toModule());
        }
        return new Professor(this.getFirstName(),this.getLastame(),this.getDateOfBirth(),this.getEmail(),this.getUrlAvatar(),this.getPassword(),listModule);
    }

    
 
    
    
    

    
}
