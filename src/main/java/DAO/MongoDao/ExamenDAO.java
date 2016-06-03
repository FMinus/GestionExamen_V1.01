/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MongoDao;

import Entities.ExamenEntity;
import Entities.ModuleEntity;
import com.mongodb.MongoClient;
import java.util.Date;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;


public class ExamenDAO extends BasicDAO<ExamenEntity, String>
{
    
    public ExamenDAO(Class<ExamenEntity> entityClass, Datastore ds)
    {
        super(entityClass, ds);
    }
    
    public ExamenEntity findByModule(ModuleEntity module)
    {
        return createQuery().field("module").equal(module).get();       
    }
    
    public ExamenEntity findByModuleName(String module)
    {
        return createQuery().field("module").equal(module).get();       
    }
    
    public List<ExamenEntity> findAllExams()
    {
        Query<ExamenEntity> query=createQuery();
        return query.asList();
    }
    
    public ExamenEntity findByDate(Date t)
    {
        return createQuery().field("date").equal(t).get();
    }
    
    public List<ExamenEntity> findByModule(String module)
    {
        return createQuery().field("module").equal(module).asList();
    }
    
    public ExamenEntity examAfter(Date t)
    {
        return createQuery().field("dateDebut").greaterThan(t).get();
    }
    
    public List<ExamenEntity> examenAPasser(Date t)
    {
        return createQuery().field("dateFin").lessThan(t).asList();
    }
    
    public ExamenEntity examEnCours()
    {
        Query<ExamenEntity> query = createQuery();
        Date t = new Date();
        
        query.and
        (
            query.criteria("dateDebut").greaterThan(t),
            query.criteria("dateFin").lessThan(t)
            
        );
        
       return query.get();
    }
    
    public void updateDateExamenByModuleName(Date dateDebut,Date dateFin,String module)
    {
         Query<ExamenEntity> query=createQuery().field("module").equal(module);
        
        UpdateOperations<ExamenEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .set("dateDebut", dateDebut)
                        .set("dateFin", dateFin)
                ;
        
        ds.update(query, ops);
    }
    
    public void updateDateExamen(Date dateDebut,Date dateFin,ModuleEntity module)
    {
         Query<ExamenEntity> query=createQuery().field("module").equal(module);
        
        UpdateOperations<ExamenEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .set("dateDebut", dateDebut)
                        .set("dateFin", dateFin)
                ;
        
        ds.update(query, ops);
    }
    
    
}
