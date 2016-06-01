
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
        
        EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
        ExamenDAO examenDAO = new ExamenDAO(ExamenEntity.class, ds);
        ModuleDAO moduleDAO = new ModuleDAO(ModuleEntity.class, ds);
        
        List<ExamenEntity> listExams = new ArrayList<>();
        
        EtudiantEntity etudiantEntity = etudiantDAO.findByEmail(user.getEmail());
        
        Etudiant etudiant = (Etudiant) user;
        
        List<ModuleEntity> listModules = getModules(etudiant.getFiliere());
        
        for(ModuleEntity mod : listModules)
        {
            listExams.addAll(moduleDAO.getAllExams(mod));
        }
        
        
        return listExams;
    }
    
    
    
    


}
