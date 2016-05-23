/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers;

import Beans.CurrentUser;
import Beans.SessionBean;
import ConnectionMongo.MongoConnectionManager;
import Controllers.Etudiant.OpEtudiant;
import DAO.MongoDao.AdminDAO;
import DAO.MongoDao.EtudiantDAO;
import DAO.MongoDao.FiliereDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.AdminEntity;
import Entities.EtudiantEntity;
import Entities.FiliereEntity;
import Entities.MessageEntity;
import Entities.ModuleEntity;
import Entities.ProfessorEntity;
import Enums.FiliereEnum;
import Metier.Admin;
import Metier.Etudiant;
import Metier.Professor;
import Metier.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class Home implements Serializable
{
    
    User user;
    
    @Inject 
    CurrentUser currentUser;
    
    @PostConstruct
    public void onLoad()
    {
        currentUser = (CurrentUser) SessionBean.getIsLoggedIn();
        
        if(null!=currentUser.getRole())
            switch (currentUser.getRole())
        {
            case Etudiant:
                user = (Etudiant) SessionBean.getCurrentUser();
                break;
            case Professeur:
                user = (Professor) SessionBean.getCurrentUser();
                break;
            default:
                user = (Admin) SessionBean.getCurrentUser();
                break;
        }       
        
    }
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    
    private String recherche;
    
    public String getRecherche()
    {
        return recherche;
    }
    
    public void setRecherche(String recherche)
    {
        this.recherche = recherche;
    }
    
    public Home()
    {}
    
    public String getInfoEtudiant()
    {
        if(user!=null)
            System.out.println(" HomeEtudiant :  "+user);
        
        return user == null ? user.toString() : "-------------------- bean resolve fail! ------------------";
    }
    
    
    
    public String rechercheInfo()
    {
        return "";
    }
    
    public String avatarGetter(String ava)
    {
        if(ava == null)
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+ava;
        
    }
    
    public String userAvatarGetter(User e)
    {
        if(e== null || e.getUrlAvatar() == null)
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+e.getUrlAvatar();
        
    }
    
    public String getNoAva()
    {
        return "/resources/images/avatars/nophoto.png";
    }
    
    public String avatarSessionGetter()
    {
        
        if(this.user== null)
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+user.getUrlAvatar();
    }
    
    public static List<EtudiantEntity> getEtudiantList()
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
        List<EtudiantEntity> etu = etudiantDAO.findAllEtudiants();
        
        return etu;
    }
    
    public static List<ProfessorEntity> getProfessorList()
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ProfessorDAO etudiantDAO = new ProfessorDAO(ProfessorEntity.class, ds);
        List<ProfessorEntity> prof = etudiantDAO.FindAllProfs();
        
        return prof;
    }
    
    public static List<AdminEntity> getAdminList()
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        AdminDAO etudiantDAO = new AdminDAO(AdminEntity.class, ds);
        List<AdminEntity> admins = etudiantDAO.findAllAdmins();
        
        return admins;
    }
    
    public void editEtudiant()
    {
        OpEtudiant.editEtudiant((Etudiant) user);
    }
    
    public void editProfessor()
    {
        OpEtudiant.editEtudiant((Etudiant) user);
    }
    
    public List<ModuleEntity> getModules()
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();
       FiliereDAO filieredao = new FiliereDAO(FiliereEntity.class, ds);
       List<ModuleEntity> list = filieredao.getList(FiliereEnum.GI);
       return list;
    }
    
    public List<ModuleEntity> getModulesProf()
    {       
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();
       
       ProfessorDAO professorDAO = new ProfessorDAO(ProfessorEntity.class, ds);
       
       //TODO : change back to : user.getEmail()
       List<ModuleEntity> list = professorDAO.getListModuleByEmail("testProf@mail.com");
       return list;
    }
    
    public boolean aNotification()
    {
        return Services.aMessages(user.getEmail());
    }
    
    public int notifcationCounter()
    {
        return Services.countUnreadMessages(Services.getUnreadMessagesOf(user.getEmail()));
    }
    
    public List<MessageEntity> getMessages()
    {
        return Services.getUnreadMessagesOf(user.getEmail());
    }
    
    public String simpleDateDisplay(Date t)
    {
        return new SimpleDateFormat("MM-dd-yyyy").format(t);
    }
    
    
           
    
    
}
