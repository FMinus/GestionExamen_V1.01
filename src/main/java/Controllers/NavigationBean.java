/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Enums.Role;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable
{
    Role role;
     
    public String redirectToLogin() 
    {
        return "/Login.xhtml?faces-redirect=true";
    }
    
    public String redirectToWelcome() 
    {
        return "/Views/Home"+role.name()+".xhtml?faces-redirect=true";
    }

     

}
