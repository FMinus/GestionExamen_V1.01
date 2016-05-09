/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionMongo;

import Metier.EtudiantMetier;
import DAO.DAOEtudiant;
import Entities.EtudiantEntity;
import java.util.List;

public class ConnectionEtudiant
{
    public void registerEtudiant(EtudiantMetier etudiant)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        daoEtudiant.insertEtudiant(etudiant.toEtudiantEntity());
    }
    
     public boolean loginEtudiant(String email,String password)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        List<EtudiantEntity> listEtu = daoEtudiant.loginEtudiant(email, password);
        
        if(listEtu.isEmpty())
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
