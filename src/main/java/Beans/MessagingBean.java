/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Metier.Etudiant;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class MessagingBean implements Serializable
{
    @Inject 
    Etudiant etudiant;
    
    public void attrListener(ActionEvent event)
    {
	etudiant = (Etudiant) event.getComponent().getAttributes().get("action");
           
    }

    public Etudiant getEtudiant()
    {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant)
    {
        this.etudiant = etudiant;
    }
    
    public void someAction()
    {
        System.out.println("Test Action : ");
                
        System.out.println(etudiant.toString());
    }
}
