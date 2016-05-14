/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IDAO.DAO;

import DAO.IDAO.IDAO;
import Entities.ProfessorEntity;
import Controllers.Morphia.ServiceMorphia;
import com.mongodb.DBCollection;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 *
 * @author AbdelMajid
 */
public class ProfessorDAO extends BasicDAO<ProfessorEntity, ObjectId> implements IDAO<ProfessorEntity>{

    public ProfessorDAO(Class<ProfessorEntity> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
    @Override
    public ProfessorEntity getByName(String champ, String name) {
        
        Query<ProfessorEntity> query=createQuery().field(champ).equal(name);
        return query.get();
    }

    @Override
    public List<ProfessorEntity> getList() {
        Query<ProfessorEntity> query=createQuery();
       return query.asList();
    }

    @Override
    public List<ProfessorEntity> getXSupA(float note) {
        
       return new ArrayList<>();
       
    }

    @Override
    public void deleteBy(String champ, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateXby(String champ, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addX(ProfessorEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    
}
