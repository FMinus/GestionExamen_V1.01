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
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author AbdelMajid
 */
public class EtudiantDAO extends BasicDAO<EtudiantEntity, String> implements UpdateOperations<EtudiantEntity>
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
    
    public List<EtudiantEntity> findAllEtudiantsButSelf(String email)
    {
        Query<EtudiantEntity> query=createQuery().field("email").notEqual(email);
        return query.asList();
    }
    
    public EtudiantEntity loginEtudiant(String email,String password)
    {
        Query<EtudiantEntity> query = createQuery();    
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
    
    public void updateEtudiant(EtudiantEntity etudiant) 
    {
        Query<EtudiantEntity> query=createQuery().field("email").equal(etudiant.getEmail());
        
        UpdateOperations<EtudiantEntity> ops = 
                ds.createUpdateOperations(entityClazz)
                        .set("firstName", etudiant.getFirstName())
                        .set("lastName", etudiant.getLastame())
                        .set("email", etudiant.getEmail())
                        .set("password", etudiant.getPassword())
                        .set("filiere", etudiant.getFiliere())
                        .set("dateOfBirth", etudiant.getDateOfBirth())
                ;
        
        ds.update(query, ops);
        //ds.findAndModify(createQuery().field("email").equal(etudiant.getEmail()), up)
    }
    
     public void deleteByEmail(String email) 
     {
         Query<EtudiantEntity> query=createQuery().field("email").equal(email);   
         ds.findAndDelete(query);  
     }
    
    
    /*
    public List<ModuleEntity> getModules(Etu)
    {
        
    }
*/

    @Override
    public UpdateOperations<EtudiantEntity> add(String arg0, Object arg1)
    {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public UpdateOperations<EtudiantEntity> add(String arg0, Object arg1, boolean arg2)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> addAll(String arg0, List<?> arg1, boolean arg2)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> dec(String field)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> disableValidation()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> enableValidation()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> inc(String field)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> inc(String arg0, Number arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> isolated()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> max(String arg0, Number arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> min(String arg0, Number arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> removeAll(String arg0, Object arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> removeAll(String arg0, List<?> arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> removeFirst(String field)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> removeLast(String field)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> set(String arg0, Object arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> setOnInsert(String arg0, Object arg1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UpdateOperations<EtudiantEntity> unset(String field)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}