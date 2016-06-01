package Controllers.Professor;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.ProfessorDAO;
import Entities.ExamenEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
@ManagedBean
@SessionScoped
public class AjoutExamen implements Serializable
{
    ExamenEntity exam;

    public ExamenEntity getExam()
    {
        return exam;
    }

    public void setExam(ExamenEntity exam)
    {
        this.exam = exam;
    }
    
    public List<ModuleEntity> getModules(String emailProf)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ProfessorDAO profDao = new ProfessorDAO(ProfessorEntity.class, ds);
        
        return profDao.getByEmail(emailProf).modules;
        
    }
    
    
    public AjoutExamen()
    {
        
    }
    
    public void ajouterExam()
    {
        System.out.println("ajout examen ");
        System.out.println("l'exam commence: "+exam.getDateDebut());
    }
    
}
