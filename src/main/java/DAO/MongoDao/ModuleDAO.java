/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MongoDao;

import Entities.ExamenEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
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
    
    
    public List<ExamenEntity> getAllExams(ModuleEntity module)
    {
        Query<ModuleEntity> query=createQuery().field("ModuleName").equal(module.getModuleName());
        return query.get().examens;
    }
    
    
    public void updateProfessor(ProfessorEntity prof) 
    {
        Query<ModuleEntity> query=createQuery().field("profOwner").equal(prof);    
        UpdateOperations<ModuleEntity> ops = ds.createUpdateOperations(entityClazz).set("profOwner", prof);           
        ds.update(query, ops);       
    }
    
    public void updateName(String oldname,String newName) 
    {
        Query<ModuleEntity> query=createQuery().field("ModuleName").equal(oldname);    
        UpdateOperations<ModuleEntity> ops = ds.createUpdateOperations(entityClazz).set("ModuleName", newName);           
        ds.update(query, ops);       
    }
    
    public void addExam(ModuleEntity module , ExamenEntity exam)
    {
        Query<ModuleEntity> query=createQuery().field("ModuleName").equal(module.getModuleName());
        
        exam.setModule(module);
        Key<ExamenEntity> ExamKey = ds.save(exam);
        
        UpdateOperations<ModuleEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .add("examens", ExamKey);
                
        ds.update(query, ops);   
        
    }
    
    //TODO : list<DBRef>
    /*
    public void updateExamen(ModuleEntity module,List<ExamenEntity> exams) 
    {
        Query<ModuleEntity> query=createQuery().field("ModuleName").equal(module.getModuleName());    
        //UpdateOperations<ModuleEntity> ops = ds.createUpdateOperations(entityClazz).set("profOwner", );           
        ds.update(query, ops);       
    }
    */
}
