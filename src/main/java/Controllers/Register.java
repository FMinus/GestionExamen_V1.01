/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Metier.EtudiantMetier;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class Register implements Serializable
{
    @Inject 
    EtudiantMetier etudiant;
    
    
    
    
    
    
}
