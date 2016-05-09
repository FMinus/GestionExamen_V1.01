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

@Stateful
@LocalBean
@ManagedBean
@SessionScoped
public class HomeEtudiant
{
    public HomeEtudiant()
    {
        
    }
    
    @Inject
    EtudiantMetier etudiant;

    public EtudiantMetier getEtudiant()
    {
        return etudiant;
    }

    public void setEtudiant(EtudiantMetier etudiant)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            
        etudiant = (EtudiantMetier) request.getAttribute("userEtudiant");
    }
    
    
    
}
