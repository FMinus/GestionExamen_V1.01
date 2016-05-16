/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionMongo;

import DAO.MongoDao.ProfessorDAO;
import Entities.ProfessorEntity;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
public class ConnectionProfesseur
{
    private ProfessorEntity prof;

    public ProfessorEntity getProf()
    {
        return prof;
    }

    public void setProf(ProfessorEntity prof)
    {
        this.prof = prof;
    }
    
     public void registerProfessor(ProfessorEntity prof)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        ProfessorDAO daoProfessor = new ProfessorDAO(ProfessorEntity.class, ds);
        
        daoProfessor.save(prof);
       
    }
    
    public boolean loginProf(String email,String password)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        ProfessorDAO daoProfessor = new ProfessorDAO(ProfessorEntity.class, ds);
        
        prof = daoProfessor.loginProfessor(email, password);
         
        if(prof == null)
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
