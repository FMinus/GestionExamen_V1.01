/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import ConnectionMongo.MongoConnectionManager;
import Controllers.NavigationBean;
import DAO.MongoDao.AdminDAO;
import DAO.MongoDao.EtudiantDAO;
import DAO.MongoDao.ModuleDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.AdminEntity;
import Entities.EtudiantEntity;
import Entities.FiliereEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */

@ManagedBean(name = "search")
@RequestScoped
public class SearchBean implements Serializable
{
    private String term;
    private List<ProfessorEntity> listProfessors = new ArrayList<>();
    private List<EtudiantEntity> listEtudiants = new ArrayList<>();
    private List<AdminEntity> listAdmins = new ArrayList<>();
    private List<ModuleEntity> listModules = new ArrayList<>();
    private List<FiliereEntity> listFilieres = new ArrayList<>();
    
    
    
    
    public String search()
    {
        NavigationBean nav = new NavigationBean();
        this.listAdmins = searchForAdmin(this.term);
        this.listEtudiants = searchForEtudiant(this.term);
        this.listProfessors = searchForProf(this.term);
        this.listModules = searchForModule(this.term);
        
        testRecherche();
        //System.out.println("path to page : "+nav.toSearchResults());
        //TODO : fix search navigation
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getContextName();
        System.out.println("context : "+contextPath);
        
        return "/GestionExamen_V1.01/Views/Common/SearchResults.xhtml";
    }
    
    public  List<ProfessorEntity> searchForProf(String term)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ProfessorDAO profDao = new ProfessorDAO(ProfessorEntity.class, ds);
        
        return profDao.lookFor(term);
    }
    
    public List<AdminEntity> searchForAdmin(String term)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        AdminDAO admindao = new AdminDAO(AdminEntity.class, ds);
        
        return admindao.lookFor(term);
    }
    
    public List<EtudiantEntity> searchForEtudiant(String term)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
        
        return etudiantDAO.lookFor(term);
    }
    
    public List<ModuleEntity> searchForModule(String term)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        ModuleDAO moduleDAO = new ModuleDAO(ModuleEntity.class, ds);
        
        return moduleDAO.lookFor(term);
    }
    
    public void testRecherche()
    {
        System.out.println("profs : "+searchForProf(term));
        System.out.println("Admins : "+searchForAdmin(term));
        System.out.println("Etudiants : "+searchForEtudiant(term));
                
    }
    
    public boolean listAdminEmpty()
    {
        return listAdmins.isEmpty();
    }
    
    public boolean listEtudiantsEmpty()
    {
        return listEtudiants.isEmpty();
    }
    
    public boolean listProfessorsEmpty()
    {
        return listProfessors.isEmpty();
    }
    
    public boolean listModulesEmpty()
    {
        return listModules.isEmpty();
    }
    
    public SearchBean()
    {
    }

    public String getTerm()
    {
        return term;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    public List<ProfessorEntity> getListProfessors()
    {
        return listProfessors;
    }

    public void setListProfessors(List<ProfessorEntity> listProfessors)
    {
        this.listProfessors = listProfessors;
    }

    public List<EtudiantEntity> getListEtudiants()
    {
        return listEtudiants;
    }

    public void setListEtudiants(List<EtudiantEntity> listEtudiants)
    {
        this.listEtudiants = listEtudiants;
    }

    public List<AdminEntity> getListAdmins()
    {
        return listAdmins;
    }

    public void setListAdmins(List<AdminEntity> listAdmins)
    {
        this.listAdmins = listAdmins;
    }

    public List<ModuleEntity> getListModules()
    {
        return listModules;
    }

    public void setListModules(List<ModuleEntity> listModules)
    {
        this.listModules = listModules;
    }

    public List<FiliereEntity> getListFilieres()
    {
        return listFilieres;
    }

    public void setListFilieres(List<FiliereEntity> listFilieres)
    {
        this.listFilieres = listFilieres;
    }
    
    
    
}
