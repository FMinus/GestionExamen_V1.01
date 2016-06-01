/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DAO.MongoDao;

import Entities.FiliereEntity;
import Entities.ModuleEntity;
import Enums.FiliereEnum;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

public class FiliereDAO extends BasicDAO<FiliereEntity, String>{
    
    public FiliereDAO(Class<FiliereEntity> entityClass, Datastore ds) 
    {
        super(entityClass, ds);
    }
    
    public void addModule(FiliereEntity filiere,ModuleEntity module)
    {
        Query<FiliereEntity> query=createQuery().field("filiere").equal(filiere.getFiliere());
        
        
        Key<ModuleEntity> moduleKey = ds.save(module);
        
        UpdateOperations<FiliereEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .add("listModule", moduleKey);
                
        ds.update(query, ops);  
    }
    
    public List<ModuleEntity> getList(FiliereEnum f)
    {
        List<ModuleEntity> maListe=createQuery().field("filiere").equal(f.toString()).get().getListModule();
        return maListe;
    }
    
    public FiliereEntity getFiliereByname(FiliereEnum f)
    {
        return createQuery().field("filiere").equal(f).get();
    }
    
    public List<ModuleEntity> getListModulesByFiliere(FiliereEnum f)
    {
        return createQuery().field("filiere").equal(f).get().getListModule();
    }
    
    public List<FiliereEntity> findAllFilieres()
    {
        Query<FiliereEntity> query=createQuery();
        return query.asList();
    }
    
    
    
    
}
