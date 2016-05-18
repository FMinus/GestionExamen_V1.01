/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import Beans.CurrentUser;
import Beans.SessionBean;
import Metier.Etudiant;
import Metier.User;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class EditEtudiant implements Serializable
{
    User user;
    
    @Inject CurrentUser currentUser;
    
    public EditEtudiant()
    {}
    
    @PostConstruct
    public void onLoad()
    {       
        user = (Etudiant) SessionBean.getCurrentUser();        
        currentUser = (CurrentUser) SessionBean.getIsLoggedIn();
        
        if(user!=null)
            System.out.println("user not null"+user);
        
        if(currentUser != null)
            System.out.println("current user not null - "+currentUser);
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public CurrentUser getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser)
    {
        this.currentUser = currentUser;
    }
    
    
    
    


}
