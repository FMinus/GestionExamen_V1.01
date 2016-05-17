/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayoub
 */
public class Module
{
    private String ModuleName;
    
   
    public List<Examen> examens=new ArrayList<>();
    
   
    public Professor profOwner; 

    public Module() 
    {
        
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String ModuleName) 
    {
        this.ModuleName = ModuleName;
    }
    

    public Module(String name,Professor p) 
    {
        this.ModuleName=name;
        this.profOwner=p;
    }

    public Module(String ModuleName) 
    {
        this.ModuleName = ModuleName;
    }
    

    
}
