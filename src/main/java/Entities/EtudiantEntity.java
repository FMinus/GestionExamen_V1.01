package Entities;

import Enums.Filiere;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import Metier.Etudiant;

@Entity
public class EtudiantEntity extends UserEntity
{
    
    private Filiere filiere;
    
    public EtudiantEntity()
    {     
    }

    public EtudiantEntity(String firstName , String lastName , String email, String password , Filiere filiere,Date dateOfBirth,String urlAvatar)
    {
        //public UserEntity(String firstName, String lastName, String email, String password, Date dateOfBirth, String urlAvatar)
        super(firstName,lastName,email,password,dateOfBirth,urlAvatar);
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
