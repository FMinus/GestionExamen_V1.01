/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionMongo;

import Metier.Etudiant;

import DAO.MongoDao.EtudiantDAO;
import Entities.EtudiantEntity;
import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.Datastore;

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
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        EtudiantDAO daoEtudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
        
        daoEtudiantDAO.save(etudiant.toEtudiantEntity());
      
       
    }
    
     public boolean loginEtudiant(String email,String password)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        EtudiantDAO daoEtudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
        
        etudiant = daoEtudiantDAO.loginEtudiant(email, password);
         
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
     
    
    
    
}
