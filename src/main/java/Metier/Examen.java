/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.Date;

/**
 *
 * @author Ayoub
 */
public class Examen
{
   
    private Date date;
    
    
    private Module modules;
    
    public Examen() 
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
    public Examen(Date t,Module m) 
    {
        this.modules=m;
        this.date=t;
    }
    
}
