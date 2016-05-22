/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ConnectionMongo;

import DAO.MongoDao.AdminDAO;
import Entities.AdminEntity;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
public class ConnectionAdmin
{
    private AdminEntity admin;
    
    public AdminEntity getAdmin()
    {
        return admin;
    }
    
    public void setAdmin(AdminEntity admin)
    {
        this.admin = admin;
    }
    
    public void registerAdmin(AdminEntity prof)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        AdminDAO daoProfessor = new AdminDAO(AdminEntity.class, ds);
        
        daoProfessor.save(prof);
        
    }
    
    public boolean loginAdmin(String email,String password)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        AdminDAO daoProfessor = new AdminDAO(AdminEntity.class, ds);
        
        admin = daoProfessor.loginAdmin(email, password);
        
        if(admin == null)
        {
            System.out.println("ConnectionAdmin : no such user");
            return false;
        }
        else
        {
            System.out.println("ConnectionAdmin : logged in");
            return true;
        }
        
    }
    
    
}
