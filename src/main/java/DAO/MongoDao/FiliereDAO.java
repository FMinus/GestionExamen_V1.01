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
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

public class FiliereDAO extends BasicDAO<FiliereEntity, String>{
    
    public FiliereDAO(Class<FiliereEntity> entityClass, Datastore ds) 
    {
        super(entityClass, ds);
    }
    
    public void addModule(ModuleEntity module)
    {
        createQuery().disableValidation().get().getListModule().add(module);
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
