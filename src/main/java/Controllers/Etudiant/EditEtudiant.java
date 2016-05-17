/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import Beans.SessionBean;
import Metier.Etudiant;
import Metier.User;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class EditEtudiant implements Serializable
{
    User user;
    
    public EditEtudiant()
    {}
    
    @PostConstruct
    public void onLoad()
    {       
        user = (Etudiant) SessionBean.getCurrentUser();
        
        if(user!=null)
            System.out.println("user not null"+user);
    }
    
    


}
