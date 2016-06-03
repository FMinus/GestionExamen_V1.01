/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Professor;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.ModuleDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.ExamenEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import Metier.Professor;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class EditProfessor implements Serializable
{
    @Inject
    private ExamenEntity exam;

    public ExamenEntity getExam()
    {
        return exam;
    }

    public void setExam(ExamenEntity exam)
    {
        this.exam = exam;
    }
    
    
    
    public static void editProfessor(Professor p)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ProfessorDAO profDao = new ProfessorDAO(ProfessorEntity.class, ds);
        
        //TODO : fix toProfessorEntity
        profDao.updateProfessor(p.toProfessorEntity());
    }
    
    public void ajoutExamen()
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ModuleDAO mdao = new ModuleDAO(ModuleEntity.class, ds);
        
        
    }
    
    public void test()
    {
        System.out.println("ajout edit");
        //System.out.println("date debut : "+exam.getDateDebut());
    }
}
