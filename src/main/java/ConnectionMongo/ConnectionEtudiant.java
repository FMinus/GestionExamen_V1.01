/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionMongo;

import Metier.Etudiant;
import DAO.DAOEtudiant;
import Entities.EtudiantEntity;
import java.util.ArrayList;
import java.util.List;

public class ConnectionEtudiant
{
    private EtudiantEntity etudiant;

    public EtudiantEntity getEtudiant()
    {
        return etudiant;
    }

    public void setEtudiant(EtudiantEntity etudiant)
    {
        this.etudiant = etudiant;
    }

    
    
    
    
    public void registerEtudiant(Etudiant etudiant)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        daoEtudiant.insertEtudiant(etudiant.toEtudiantEntity());
    }
    
     public boolean loginEtudiant(String email,String password)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        etudiant = daoEtudiant.loginEtudiant(email, password);
        
        if(etudiant == null)
        {
            System.out.println("ConnectionEtudiant : no such user");
            return false;
        }
        else
        {
            System.out.println("ConnectionEtudiant : logged in");
            
            return true;
        }
            
    }
     
    public List<Etudiant> getAllEtudiants()
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);    
        
        List<EtudiantEntity> etudiantList;
        
        etudiantList = daoEtudiant.getAllEtudiants("lastname" , "ayoub");
        
        List<Etudiant> list = new ArrayList<>();
        
        for(EtudiantEntity etu : etudiantList)
        {
            list.add(etu.toEtudiant());
        }
        return list;
    }
    
    
}
