package Metier;

import Entities.EtudiantEntity;
import Enums.Filiere;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class Etudiant extends User implements Serializable
{
    private Filiere filiere;
    
    public Etudiant()
    {
        super();
    }
    
    public Etudiant(String firstName, String lastName,Filiere filiere , String email, Date dateOfBirth, String password ,String urlAvatar )
    {
        super(firstName, lastName, dateOfBirth, email, urlAvatar, password);
        this.filiere = filiere;
    }
  
    public Filiere getFiliere()
    {
        return filiere;
    }
    
    public void setFiliere(Filiere filiere)
    {
        this.filiere = filiere;
    }
    
    public EtudiantEntity toEtudiantEntity()
    {
        return new EtudiantEntity(getFirstName(),getLastName(),getEmail(),getPassword(),getFiliere(),getDateOfBirth(),getUrlAvatar());
    }
    
    
}
