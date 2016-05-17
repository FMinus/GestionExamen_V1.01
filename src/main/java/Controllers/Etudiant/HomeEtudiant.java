/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import Beans.CurrentUser;
import Beans.SessionBean;
import ConnectionMongo.ConnectionEtudiant;
import ConnectionMongo.MongoConnectionManager;
import Controllers.Login;
import DAO.MongoDao.EtudiantDAO;
import Entities.EtudiantEntity;
import Enums.Role;
import Metier.Etudiant;
import Metier.Professor;
import Metier.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class HomeEtudiant implements Serializable
{
    
    User user;
    
    @Inject 
    CurrentUser currentUser;
    
    
    
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
    
    
    
    @PostConstruct
    public void onLoad()
    {
        currentUser = (CurrentUser) SessionBean.getIsLoggedIn();
        
        if(currentUser.getRole()==Role.Etudiant)
            user = (Etudiant) SessionBean.getCurrentUser();
        else if(currentUser.getRole()==Role.Professeur)
            user = (Professor) SessionBean.getCurrentUser();
            
        
    }
    
    public String toProfile()
    {
        return "/GestionExamen_V1.01/Views/Etudiant/Profile.xhtml";
    }
    
    public HomeEtudiant()
    {
        
    }
    
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
    
    public String avatarGetter()
    {
        if(this.user== null || !this.user.getUrlAvatar().contains("jpg") || !this.user.getUrlAvatar().contains("png") || !this.user.getUrlAvatar().contains("jpeg") || !this.user.getUrlAvatar().contains("gif"))
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+user.getUrlAvatar();
        
    }
    
    public String userAvatarGetter(EtudiantEntity e)
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
    
    
}
