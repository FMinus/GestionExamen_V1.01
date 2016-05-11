/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers.Etudiant;

import Beans.SessionBean;
import Metier.Etudiant;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class HomeEtudiant implements Serializable
{
    
    @Inject Etudiant etudiant;
    
    public Etudiant getEtudiant()
    {
        return etudiant;
    }
    
    public void setEtudiant(Etudiant etudiant)
    {
        this.etudiant = etudiant;
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
        etudiant = (Etudiant) SessionBean.getCurrentUser();
       
    }
    
    
    
    public HomeEtudiant()
    {
        //HttpServletRequest request = getHttpServletRequest();
        
        //etudiant = (Etudiant) request.getSession().getAttribute("currentUser");
        
    }

   
    
    
    
    public String getInfoEtudiant()
    {
        if(etudiant!=null)
            System.out.println(" HomeEtudiant :  "+etudiant);
        
        return etudiant == null ? etudiant.toString() : "-------------------- bean resolve fail! ------------------";
    }
    
    
    
    public String rechercheInfo()
    {
        return "";
    }
    
    public String avatarGetter()
    {
        if(this.etudiant== null || !this.etudiant.getUrlAvatar().contains("jpg") || !this.etudiant.getUrlAvatar().contains("png") || !this.etudiant.getUrlAvatar().contains("jpeg") || !this.etudiant.getUrlAvatar().contains("gif"))
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+etudiant.getUrlAvatar();
        
    }
    
    public String avatarSessionGetter()
    {
          
        if(this.etudiant== null)
            return "/resources/images/avatars/nophoto.png";
        else
            return "/resources/images/avatars/"+etudiant.getUrlAvatar();
    }
    
    
}
