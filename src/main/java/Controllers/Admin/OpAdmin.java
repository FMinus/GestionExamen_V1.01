/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Admin;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.AdminDAO;
import DAO.MongoDao.EtudiantDAO;
import DAO.MongoDao.FiliereDAO;
import Entities.AdminEntity;
import Entities.EtudiantEntity;
import Entities.FiliereEntity;
import Metier.Admin;
import Metier.Etudiant;
import Metier.Professor;
import Metier.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class OpAdmin implements Serializable
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
    
    public void infoGetter(User u)
    {
        user = u;
        
        System.out.println("user is : "+user); 
    }
    
    public void editAdmin(User u)
    {
        Admin admin = (Admin) u;
        
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();           
       AdminDAO etudiantDAO = new AdminDAO(AdminEntity.class, ds);
            
       etudiantDAO.updateAdmin(admin.toAdminEntity());
    }
    
    public void deleteUser()
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore(); 
       
       if(user instanceof Etudiant)
       {
           Etudiant etudiant = (Etudiant) user;
           EtudiantDAO edao = new EtudiantDAO(EtudiantEntity.class, ds);
           
           //edao.delete(etudiant.toEtudiantEntity());
           edao.deleteByEmail(etudiant.getEmail());
       }
       else if(user instanceof Professor)
       {
           Professor professor = (Professor) user;
       }
        
    }
    
    public List<FiliereEntity> getAllFilieres()
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore(); 
       
       FiliereDAO fdao = new FiliereDAO(FiliereEntity.class, ds);
        
       return fdao.findAllFilieres();
    }
    
}
