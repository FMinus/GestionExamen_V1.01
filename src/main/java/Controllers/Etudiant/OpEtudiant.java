/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.EtudiantDAO;
import DAO.MongoDao.FiliereDAO;
import Entities.EtudiantEntity;
import Entities.FiliereEntity;
import Entities.ModuleEntity;
import Enums.FiliereEnum;
import Metier.Etudiant;
import Metier.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class OpEtudiant implements Serializable
{
   
    User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
    
    
    
    public static void editEtudiant(Etudiant e)
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();           
       EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
            
       etudiantDAO.updateEtudiant(e.toEtudiantEntity());
    }
    
    public static List<ModuleEntity> getModules(FiliereEnum filiere)
    {
        List<ModuleEntity> listModules;
        
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        FiliereDAO filiereDAO = new FiliereDAO(FiliereEntity.class, ds);
        
        listModules = filiereDAO.getList(filiere);         
        return listModules;
    }
    
    
    


}
