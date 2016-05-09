/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ConnectionMongo.ConnectionEtudiant;
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

    public EtudiantMetier getEtudiant()
    {
        return etudiant;
    }

    public void setEtudiant(EtudiantMetier etudiant)
    {
        this.etudiant = etudiant;
    }
    
    public void registerEtudiant()
    {
        ConnectionEtudiant conn= new ConnectionEtudiant();
        //r.registerEtudiant(new EtudiantMetier(this.firstName,this.lastName,this.email,this.password,this.filiere,this.dateOfBirth,this.urlAvatar));
        conn.registerEtudiant(etudiant);
        /*
        System.out.println("first name : "+this.firstName);
        System.out.println("last name : "+this.lastName);
        System.out.println(this.dateOfBirth);
        System.out.println("filiere : "+this.filiere);
        System.out.println("email : "+this.email);
        System.out.println("avatar url : "+this.urlAvatar);
        System.out.println("password : "+this.password);
        */
    }
    
    
    
    
}
