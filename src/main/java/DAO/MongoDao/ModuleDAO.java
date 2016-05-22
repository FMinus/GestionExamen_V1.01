/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MongoDao;

import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author Ayoub
 */
public class ModuleDAO extends BasicDAO<ModuleEntity, Object>
{
    
    public ModuleDAO(Class<ModuleEntity> entityClass, Datastore ds)
    {
        super(entityClass, ds);
    }
    
    public ModuleEntity findByName(String module)
    {
        Query<ModuleEntity> query=createQuery().field("ModuleName").equal(module);
        return query.get();
    }
    
    public ModuleEntity findByProf(ProfessorEntity prof)
    {
        Query<ModuleEntity> query=createQuery().field("profOwner").equal(prof);
        return query.get();
    }
    
    /*
    public List<ExamenEntity> getAllExams()
    {
        return createQuery()
    }
    */
    
    public void updateProfessor(ProfessorEntity prof) 
    {
        Query<ModuleEntity> query=createQuery().field("profOwner").equal(prof);    
        UpdateOperations<ModuleEntity> ops = ds.createUpdateOperations(entityClazz).set("profOwner", prof);           
        ds.update(query, ops);       
    }
}
