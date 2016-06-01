/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.CurrentUser;
import Enums.Role;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable
{
    @Inject CurrentUser user;

    public CurrentUser getUser()
    {
        return user;
    }

    public void setUser(CurrentUser user)
    {
        this.user = user;
    }
    
    @PostConstruct
    public void onLoad()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false); 
        user =(CurrentUser) session.getAttribute("loggedAs");       
    }
    
    public String getRole()
    {
        return user.getRole().toString();
    }
     
    public String redirectToLogin() 
    {
        return "/GestionExamen_V1.01//Login.xhtml?faces-redirect=true";
    }
    
    public String redirectToWelcome() 
    {
        return "/GestionExamen_V1.01/Views/"+getRole()+"/Home"+getRole()+".xhtml";
    }
    
    public String toProfile()
    {
        return "/GestionExamen_V1.01/Views/"+getRole()+"/Profile.xhtml";
    }
    
    public boolean hasMods()
    {
        if(user.getRole()!=Role.Etudiant)
            return true;
        else
            return false;
    }
    
    public boolean isAdmin()
    {
        if(user.getRole() == Role.Admin)
            return true;
        else
            return false;
    }
    
    public boolean isProf()
    {
        if(user.getRole() == Role.Professeur)
            return true;
        else
            return false;
    }
    
    public String toUsers()
    {
        return "/GestionExamen_V1.01/Views/"+getRole()+"/Users.xhtml";
    }
    
    public String toEditProfile()
    {
        return "/GestionExamen_V1.01/Views/"+getRole()+"/editProfile.xhtml";
    }
    
    public String sendMail()
    {
        return "/GestionExamen_V1.01/Views/Common/Message.xhtml";
    }

    public String toGestionFiliere()
    {
        return "/GestionExamen_V1.01/Views/Admin/GestionFilieres.xhtml";
    }
    
    public String toExamsEtudiant()
    {
        return "/GestionExamen_V1.01/Views/"+getRole()+"/ListExams.xhtml";
    }
    
    public String toAjoutExam()
    {
        return "/GestionExamen_V1.01/Views/"+getRole()+"/AjoutExamen.xhtml";
    }
}
