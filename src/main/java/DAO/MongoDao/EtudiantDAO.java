/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DAO.MongoDao;

import DAO.MongoDao.IDAO;
import Entities.EtudiantEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author AbdelMajid
 */
public class EtudiantDAO extends BasicDAO<EtudiantEntity, String>
{
    
    public EtudiantDAO(Class<EtudiantEntity> entityClass, Datastore ds)
    {
        super(entityClass, ds);
    }
    
    public EtudiantEntity findByEmail(String email)
    {
        return createQuery().field("email").equal(email).get();
        
    }
    
    public List<EtudiantEntity> findAllEtudiants()
    {
        Query<EtudiantEntity> query=createQuery();
        return query.asList();
    }
    
    public EtudiantEntity loginEtudiant(String email,String password)
    {
        Query<EtudiantEntity> query = createQuery();
        EtudiantEntity etudiant;
        
        query.and
        (
            query.criteria("email").equal(email),
            query.criteria("password").equal(password)
        );
        
       return (EtudiantEntity) query.get();
    }
    
    public boolean emailExist(String email)
    {
        Query<EtudiantEntity> query=createQuery().field("email").equal(email);
        
        return query.get() != null;
    }
    
    
    public void registerEtudiant(EtudiantEntity t) 
    {
        ds.save(t);
    }
    
    /*
    public List<ModuleEntity> getModules(Etu)
    {
        
    }
*/
}