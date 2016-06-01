
package Controllers.Etudiant;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.EtudiantDAO;
import DAO.MongoDao.ExamenDAO;
import DAO.MongoDao.FiliereDAO;
import DAO.MongoDao.ModuleDAO;
import Entities.EtudiantEntity;
import Entities.ExamenEntity;
import Entities.FiliereEntity;
import Entities.ModuleEntity;
import Enums.FiliereEnum;
import Metier.Etudiant;
import Metier.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class OpEtudiant implements Serializable
{
   //TODO : is null
    User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
    
    
    
    public static void editEtudiant(Etudiant e)
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();           
       EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
            
       etudiantDAO.updateEtudiant(e.toEtudiantEntity());
    }
    
    public static List<ModuleEntity> getModules(FiliereEnum filiere)
    {
        List<ModuleEntity> listModules;
        
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        FiliereDAO filiereDAO = new FiliereDAO(FiliereEntity.class, ds);
        
        listModules = filiereDAO.getList(filiere);         
        return listModules;
    }
    
    public List<ExamenEntity> getExams()
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ModuleDAO moduleDAO = new ModuleDAO(ModuleEntity.class, ds);
        
        List<ExamenEntity> listExams = new ArrayList<>();
        
        //Etudiant etudiant = (Etudiant) user;
        
        //System.out.println("user : "+user);
        //System.out.println("sa filiere : "+etudiant.getFiliere());
        
        
        List<ModuleEntity> listModules = getModules(FiliereEnum.GI);
        
        for(ModuleEntity mod : listModules)
        {
            listExams.addAll(moduleDAO.getAllExams(mod));
            System.out.println("module : "+mod);
            System.out.println("exams : "+mod.examens);
            
        }
        
        //System.out.println("examens : "+listExams);
        
        return listExams;
    }
    
    
    
    


}
