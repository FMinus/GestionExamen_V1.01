package Metier;

import Entities.EtudiantEntity;
import Enums.FiliereEnum;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class Etudiant extends User implements Serializable
{
    private FiliereEnum filiere;
    
    public Etudiant()
    {
        super();
    }
    
    public Etudiant(String firstName, String lastName,FiliereEnum filiere , String email, Date dateOfBirth, String password ,String urlAvatar )
    {
        super(firstName, lastName, dateOfBirth, email, urlAvatar, password);
        this.filiere = filiere;
    }
  
    public FiliereEnum getFiliere()
    {
        return filiere;
    }
    
    public void setFiliere(FiliereEnum filiere)
    {
        this.filiere = filiere;
    }
    
    public EtudiantEntity toEtudiantEntity()
    {
        return new EtudiantEntity(getFirstName(),getLastName(),getEmail(),getPassword(),getFiliere(),getDateOfBirth(),getUrlAvatar());
    }

    
    
    
    
}
