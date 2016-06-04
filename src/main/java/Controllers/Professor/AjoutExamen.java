package Controllers.Professor;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.ModuleDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.ExamenEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import Entities.QuestionEntity;
import Entities.ResponseEntity;
import Enums.TypeExamen;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
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
    private List<String> Ennoce = new ArrayList<>();
    private List<Boolean> reponses = new ArrayList<>();
    
    @Inject 
    ExamenEntity examen;

    public ExamenEntity getExamen()
    {
        return examen;
    }

    public void setExamen(ExamenEntity examen)
    {
        this.examen = examen;
    }
            
    

    public List<String> getEnnoce()
    {
        return Ennoce;
    }

    public void setEnnoce(List<String> Ennoce)
    {
        this.Ennoce = Ennoce;
    }
    
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
        
        examen.setDateDebut(dateDebut);
        examen.setDateFin(dateFin);
        
        System.out.println("yes : "+dateDebut+" - "+dateFin + " - Module : "+module);
        System.out.println("exam entity : "+examen.getDateDebut()+" - "+examen.getDateFin() + " - Module : "+module);
        
        phase++;
        System.out.println("phase : "+phase);
    }
    
    public void confExam()
    {
        System.out.println(" nombre de questions : "+nombreQuestions+" - type : "+typeExamen.name());
        
        examen.setQuestions(initQuestions(nombreQuestions,3));
        phase++;
        
        System.out.println("phase : "+phase);
    }
    
    public List<ResponseEntity> init3Rep(int numR)
    {
        List<ResponseEntity> listRep = new ArrayList<>();
        for(int i=1;i<numR+1;i++)
        {
            listRep.add(new ResponseEntity(i, "", false));
        }
        return listRep;
    }
    
    public List<QuestionEntity> initQuestions(int numQ,int numR)
    {
        List<QuestionEntity> listQuestions = new ArrayList<>();
        for(int i=1;i<numQ+1;i++)
        {
            listQuestions.add(new QuestionEntity(i,"", init3Rep(numR)));
        }
        
        return listQuestions;
    }
    
    public ResponseEntity getExactReponse(int numQ,int numR)
    {
        return examen.getQuestions().get(numQ).getResponses().get(numR);
    }
    
    public void saisieQuestions()
    {
        //System.out.println("questions saisies : "+Ennoce);
        printExam();
        phase = 0;
    }
    
    public void printExam()
    {
        int i = 1;
        
        for(QuestionEntity q : examen.getQuestions())
        {
            System.out.print("Question "+i+" - "+q.getQuestion());
            System.out.println("\t : "+q.getResponses());
        }
    }
}
