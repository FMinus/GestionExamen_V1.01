/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.IDAO.DAO;

import DAO.IDAO.IDAO;
import Entities.EtudiantEntity;
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
public class EtudiantDAO extends BasicDAO<EtudiantEntity, ObjectId> implements IDAO<EtudiantEntity>{

    public EtudiantDAO(Class<EtudiantEntity> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    @Override
    public EtudiantEntity getByName(String champ, String name) {
        
        Query<EtudiantEntity> query=createQuery().field(champ).equal(name);
        return query.get();
    }

    @Override
    public List<EtudiantEntity> getList() {
       return createQuery().asList();
    }

    @Override
    public List<EtudiantEntity> getXSupA(float note) {
      //  return createQuery().filter("note >=",note ).asList();
      return createQuery().disableValidation().asList();
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
    public void addX(EtudiantEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}