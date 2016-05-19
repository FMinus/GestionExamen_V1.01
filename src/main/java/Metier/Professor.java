/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Ayoub
 */
@ManagedBean
@SessionScoped
public class Professor extends User implements Serializable
{
    private List<Module> modules=new ArrayList<>();

    public List<Module> getModules()
    {
        return modules;
    }

    public void setModules(List<Module> modules)
    {
        this.modules = modules;
    }

    public Professor()
    {
    }

    public Professor(String firstName, String lastName, Date dateOfBirth, String email, String urlAvatar, String password,List<Module> modules)
    {
        super(firstName, lastName, dateOfBirth, email, urlAvatar, password);
        this.modules=modules;
    }
    
    public ProfessorEntity toProfessorEntity()
    {
        /*
        List<ModuleEntity> listModules;
        
        for(Module m : this.getModules())
        {
            listModules.add(m.to)
        }
        */
        
        return new ProfessorEntity();
    }

    
    
    
    
    
    
   
    
    
    
}
