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
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;


public class ExamenDAO extends BasicDAO<ExamenEntity, String>
{
    
    public ExamenDAO(Class<ExamenEntity> entityClass, MongoClient mongoClient, Morphia morphia, String dbName)
    {
        super(entityClass, mongoClient, morphia, dbName);
    }
    
    public ExamenEntity findByModule(ModuleEntity module)
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
}
