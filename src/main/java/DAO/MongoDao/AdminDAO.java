/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DAO.MongoDao;

import Entities.AdminEntity;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

public class AdminDAO extends BasicDAO<AdminEntity, String>
{
    public AdminDAO(Class<AdminEntity> entityClass, Datastore ds)
    {
        super(entityClass, ds);
    }
    
    public AdminEntity findByEmail(String email)
    {
        return createQuery().field("email").equal(email).get();        
    }
    
    public List<AdminEntity> findAllAdmins()
    {
        Query<AdminEntity> query=createQuery();
        return query.asList();
    }
    
    public AdminEntity loginAdmin(String email,String password)
    {
        Query<AdminEntity> query = createQuery();   
        query.and
        (
            query.criteria("email").equal(email),
            query.criteria("password").equal(password)
        );
        
        return (AdminEntity) query.get();
    }
    
    public boolean emailExist(String email)
    {
        Query<AdminEntity> query=createQuery().field("email").equal(email);       
        return query.get() != null;
    }
    
    public void registerAdmin(AdminEntity t)
    {
        ds.save(t);
    }
}
