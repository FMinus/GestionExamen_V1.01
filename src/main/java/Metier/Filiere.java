/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Enums.FiliereEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayoub
 */
public class Filiere
{
    
    private FiliereEnum filiere;
   
    List<Module> listModule=new ArrayList<>();

    public Filiere()
    {
    }

    public Filiere(FiliereEnum filiere,List<Module> modules)
    {
        this.filiere = filiere;
        this.listModule = modules;
    }
    
    

    public FiliereEnum getFiliere()
    {
        return filiere;
    }

    public void setFiliere(FiliereEnum filiere)
    {
        this.filiere = filiere;
    }
    
        public List<Module> getListModule() 
    {
        return listModule;
    }

    public void setListModule(List<Module> listModule) 
    {
        this.listModule = listModule;
    }
    
}
