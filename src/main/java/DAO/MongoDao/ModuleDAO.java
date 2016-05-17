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
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

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
}
