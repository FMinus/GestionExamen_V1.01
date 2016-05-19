/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MongoDao;

import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author AbdelMajid
 */
public class ProfessorDAO extends BasicDAO<ProfessorEntity, ObjectId> implements IDAO<ProfessorEntity>
{
    

    public ProfessorDAO(Class<ProfessorEntity> entityClass, Datastore ds) 
    {
        super(entityClass, ds);
    }
    
    @Override
    public ProfessorEntity getByName(String champ, String name) 
    {
        
        Query<ProfessorEntity> query=createQuery().field(champ).equal(name);
        return query.get();
    }
    
    public ProfessorEntity getByEmail(String email) 
    {       
        return createQuery().field("email").equal(email).get();
    }

   
    public List<ProfessorEntity> FindAllProfs() 
    {
        Query<ProfessorEntity> query=createQuery();
       return query.asList();
    }

    @Override
    public List<ProfessorEntity> getXSupA(float note) 
    {       
       return new ArrayList<>();      
    }

    @Override
    public void deleteBy(String champ, String name) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteByEmail(String email) 
    {
        ds.delete(createQuery().field("email").equal(email).getClass());
    }

    @Override
    public void updateXby(String champ, String name) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addX(ProfessorEntity t) 
    {
        ds.save(t);
    }
    
    public ProfessorEntity loginProfessor(String email,String password)
    {
        Query<ProfessorEntity> query = createQuery();
        
        query.and
        (
            query.criteria("email").equal(email),
            query.criteria("password").equal(password)
        );
        
       return (ProfessorEntity) query.get();
    }

    @Override
    public List<ProfessorEntity> getList()
    {
       Query<ProfessorEntity> query=createQuery();
       return query.asList();
    }
    
    public void updateProfessor(ProfessorEntity prof) 
    {
        Query<ProfessorEntity> query=createQuery().field("email").equal(prof.getEmail());
        
        UpdateOperations<ProfessorEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .set("firstName", prof.getFirstName())
                        .set("lastName", prof.getLastame())
                        .set("email", prof.getEmail())
                        .set("password", prof.getPassword())                
                        .set("dateOfBirth", prof.getDateOfBirth())
                ;
        
        ds.update(query, ops);   
    }
    
    public void updateListModule(List<ModuleEntity> modules) 
    {
        Query<ProfessorEntity> query=createQuery().field("modules").equal(modules);    
        UpdateOperations<ProfessorEntity> ops = ds.createUpdateOperations(entityClazz).set("modules", modules);           
        ds.update(query, ops);       
    }
    
    public List<ModuleEntity> getListModuleByEmail(String email) 
    {
        return createQuery().field("email").equal(email).get().getModules();
    }
    
    public void addModuleTo(ProfessorEntity p,ModuleEntity m)
    {
        Query<ProfessorEntity> query=createQuery().field("email").equal(p.getEmail());       
        List<ModuleEntity> temp = query.get().getModules();
        temp.add(m);
         
        UpdateOperations<ProfessorEntity> ops = ds.createUpdateOperations(entityClazz).set("modules", temp);
        ds.update(query, ops);        
    }

    public boolean emailExist(String email)
    {
        Query<ProfessorEntity> query=createQuery().field("email").equal(email);    
        return query.get() != null;
    }

   
    
}
