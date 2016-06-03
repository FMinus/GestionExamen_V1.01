package Controllers.Professor;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.ModuleDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.ExamenEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import Enums.TypeExamen;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class AjoutExamen implements Serializable
{
    private Date dateDebut;
    private Date dateFin;
    private String module;
    private int duree;
    
    private int phase = 0;
    
    private int nombreQuestions;
    private TypeExamen typeExamen;
    
    private List<String> Questions = new ArrayList<>();

    public List<String> getQuestions()
    {
        return Questions;
    }

    public void setQuestions(List<String> Questions)
    {
        this.Questions = Questions;
    }
    
    
    
    public TypeExamen getTypeExamen()
    {
        return typeExamen;
    }

    public void setTypeExamen(TypeExamen typeExamen)
    {
        this.typeExamen = typeExamen;
    }
    
    public int getNombreQuestions()
    {
        return nombreQuestions;
    }

    public void setNombreQuestions(int nombreQuestions)
    {
        this.nombreQuestions = nombreQuestions;
    }
    
    public int getPhase()
    {
        return phase;
    }

    public void setPhase(int phase)
    {
        this.phase = phase;
    }
    
    public int getDuree()
    {
        return duree;
    }

    public void setDuree(int duree)
    {
        this.duree = duree;
    }
    
    public Date getDateDebut()
    {
        return dateDebut;
    }
    
    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }
    
    public Date getDateFin()
    {
        return dateFin;
    }
    
    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
    }
    
    public String getModule()
    {
        return module;
    }
    
    public void setModule(String module)
    {
        this.module = module;
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
    
    public void ajoutExam()
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ModuleDAO moduleDAO = new ModuleDAO(ModuleEntity.class, ds);
        ModuleEntity moduleEntity = moduleDAO.findByName(this.module);
        
        //TODO : hash and store file
        String nomFichier = "";
        
        ExamenEntity examenEntity = new ExamenEntity(dateDebut, dateFin, moduleEntity, nomFichier);
        
        moduleDAO.addExam(moduleEntity, examenEntity);
        
    }
    
   
    
    public void dateset()
    {
        //System.out.println("yes : "+module);
        long minute=60000;
        long hour = minute * 60;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateDebut);
        
        long temp = cal.getTimeInMillis();
        
        dateFin = new Date(temp + 2*hour);
        
        System.out.println("yes : "+dateDebut+" - "+dateFin + " - Module : "+module);
        
        phase++;
        System.out.println("phase : "+phase);
    }
    
    public void confExam()
    {
        System.out.println(" nombre de questions : "+nombreQuestions+" - type : "+typeExamen.name());
        
        for(int i = 0; i < nombreQuestions; i++)
        {
            Questions.add("Question N°"+i);
        }
        phase++;
        
        System.out.println("phase : "+phase);
    }
    
    public void saisieQuestions()
    {
        System.out.println("questions saisies : "+Questions);
        
        phase = 0;
    }
}
