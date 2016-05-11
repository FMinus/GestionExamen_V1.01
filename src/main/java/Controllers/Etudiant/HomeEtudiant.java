/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import Controllers.SessionLoginListener;
import Entities.EtudiantEntity;
import Metier.Etudiant;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class HomeEtudiant extends SessionLoginListener implements Serializable
{
    
    
    @Inject
    Etudiant etudiant;
    
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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            
        etudiant = (Etudiant) request.getSession().getAttribute("userEtudiant");
       
    }
    
    
    
    public HomeEtudiant()
    {
        //HttpServletRequest request = getHttpServletRequest();
        
        //etudiant = (Etudiant) request.getSession().getAttribute("currentUser");
        
    }

    public Etudiant getEtudiant()
    {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant)
    {
        this.etudiant = etudiant;
    }
    
    
    
    
    public HttpServletRequest getHttpServletRequest()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        return request;
    }
    
    public String getInfoEtudiant()
    {
        /*
        HttpServletRequest request = getHttpServletRequest();
        
        etudiant = (Etudiant) request.getSession().getAttribute("currentUser");
        
        if(etudiant != null)
        {
            System.out.println("constructor Home Etudiant : "+etudiant.toString());
            return etudiant.toString();
        }
        return "-------------------- bean resolve fail! ------------------";   
        
        //
        */
        
        return etudiant == null ? etudiant.toString() : "-------------------- bean resolve fail! ------------------";
    }
    
    public Etudiant getSessionEtudiant()
    {
        
        
        HttpServletRequest request = getHttpServletRequest();
        
        etudiant = (Etudiant) request.getSession().getAttribute("currentUser");
        
        
        if(etudiant!=null)
           System.out.println("Session get : "+etudiant);
        
        return etudiant;
    }
    
    public String rechercheInfo()
    {
        return "";
    }
    
    public String avatarGetter()
    {
        /*
        if(getSessionEtudiant().getUrlAvatar() == null)
            return "/resources/images/avatars/nophoto.png";
        else
        {
            System.out.println("/resources/images/avatars/"+getSessionEtudiant().getUrlAvatar());
            return "/resources/images/avatars/"+getSessionEtudiant().getUrlAvatar();
        }*/
        System.out.println("Avatar to get : "+etudiant.getUrlAvatar());
        
        //if(this.etudiant.getUrlAvatar() == null)
        //    return "/resources/images/avatars/nophoto.png";
        //else
        //{
            System.out.println("/resources/images/avatars/"+getSessionEtudiant().getUrlAvatar());
            return "/resources/images/avatars/"+etudiant.getUrlAvatar();
       // }
        
    }
    
    public String avatarSessionGetter()
    {
          
        if(this.etudiant== null)
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+etudiant.getUrlAvatar();
    }
    
    
}
