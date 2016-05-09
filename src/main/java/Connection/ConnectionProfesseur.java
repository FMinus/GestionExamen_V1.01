/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import DAO.DAOEtudiant;
import Entities.EtudiantEntity;
import Metier.EtudiantMetier;
import java.util.List;

/**
 *
 * @author Ayoub
 */
public class ConnectionProfesseur
{
    //TODO
    
    public void registerProfesseur(EtudiantMetier etudiant)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        daoEtudiant.insertEtudiant(etudiant.toEtudiantEntity());
    }
    
     public boolean loginEtudiant(String email,String password)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        List<EtudiantEntity> listEtu = daoEtudiant.loginEtudiant(email, password);
        
        if(listEtu.size()==0)
        {
            System.out.println("no such user");
            return false;
        }
        else
        {
            System.out.println("logged in");
            return true;
        }
            
    }
    
    
}
