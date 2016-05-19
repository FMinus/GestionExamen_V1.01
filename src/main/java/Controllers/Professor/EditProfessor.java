/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Professor;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.ProfessorDAO;
import Entities.ProfessorEntity;
import Metier.Professor;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
public class EditProfessor
{
    public static void editProfessor(Professor p)
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();           
       
       ProfessorDAO profDao = new ProfessorDAO(ProfessorEntity.class, ds);
       
       //TODO : fix toProfessorEntity
       profDao.updateProfessor(p.toProfessorEntity());
    }
}
