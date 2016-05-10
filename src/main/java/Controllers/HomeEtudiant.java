/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.EtudiantEntity;
import Metier.EtudiantMetier;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class HomeEtudiant implements Serializable
{
    
    
    @Inject
    EtudiantMetier etudiant;
    
    private String recherche;
    
    private final String avatarRoot = "D:/Etude/JavaEE/WorkSpace/GestionExamen_V1.01/uploads/";

    public String getRecherche()
    {
        return recherche;
    }

    public void setRecherche(String recherche)
    {
        this.recherche = recherche;
    }
    
    
    
    public HomeEtudiant()
    {
       HttpServletRequest request = getHttpServletRequest();
            
       etudiant = (EtudiantMetier) request.getSession().getAttribute("userEtudiant");
        
    }
    
    
    public EtudiantMetier getEtudiant()
    {
        return etudiant;
    }

    public void setEtudiant(EtudiantMetier etudiant)
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
        
        HttpServletRequest request = getHttpServletRequest();
            
        etudiant = (EtudiantMetier) request.getSession().getAttribute("userEtudiant");
        
        //if(etudiant != null)
        //   System.out.println("constructor Home Etudiant : "+etudiant.toString());
        
        return etudiant.toString();
    }
    
    public EtudiantMetier getSessionEtudiant()
    {
        
        HttpServletRequest request = getHttpServletRequest();
            
        etudiant = (EtudiantMetier) request.getSession().getAttribute("userEtudiant");
        
        //if(etudiant != null)
        //   System.out.println("constructor Home Etudiant : "+etudiant.toString());
        
        return etudiant;
    }
    
    public String rechercheInfo()
    {
        return "";
    }
    
    public String AvatarGetter()
    {
        return avatarRoot+getSessionEtudiant().getUrlAvatar();
    }
    
    
}
