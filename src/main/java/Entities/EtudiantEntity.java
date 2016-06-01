package Entities;

import Enums.FiliereEnum;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import Metier.Etudiant;
import javax.persistence.Enumerated;

@Entity
public class EtudiantEntity extends UserEntity
{
    
    private FiliereEnum filiere;
    
    public EtudiantEntity()
    {     
    }

    public EtudiantEntity(String firstName , String lastName , String email, String password , FiliereEnum filiere,Date dateOfBirth,String urlAvatar)
    {
        //public UserEntity(String firstName, String lastName, String email, String password, Date dateOfBirth, String urlAvatar)
        super(firstName,lastName,email,password,dateOfBirth,urlAvatar);
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
    
    public Etudiant toEtudiant()
    {  
        return new Etudiant(getFirstName(),getLastame(),this.filiere,getEmail(),getDateOfBirth(),getPassword(),getUrlAvatar());
    }

    @Override
    public String toString()
    {
        super.toString();
        return "EtudiantEntity{" + "filiere=" + filiere + '}';
    }
    
    
    
    
    
}
