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
import org.mongodb.morphia.query.UpdateOperations;

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
    
    public List<AdminEntity> lookFor(String term)
    {
        Query<AdminEntity> query = createQuery();    
        query.or
        (
            query.criteria("email").equal(term),
            query.criteria("firstName").equal(term),
            query.criteria("lastName").equal(term)
        );
        
       return query.asList();
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
    
    public void updateAdmin(AdminEntity admin) 
    {
        Query<AdminEntity> query=createQuery().field("email").equal(admin.getEmail());
        
        UpdateOperations<AdminEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .set("firstName", admin.getFirstName())
                        .set("lastName", admin.getLastame())
                        .set("email", admin.getEmail())
                        .set("password", admin.getPassword())
                        .set("dateOfBirth", admin.getDateOfBirth())
                        .set("urlAvatar", admin.getUrlAvatar())
                ;
        
        ds.update(query, ops);
    }
}
