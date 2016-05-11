package Entities;

import Enums.Filiere;
import java.io.Serializable;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import Metier.Etudiant;
import java.util.Calendar;

@Entity
public class EtudiantEntity extends BaseEntity
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Filiere filiere;
    private Date dateOfBirth;
    private String urlAvatar;
    
    public EtudiantEntity(String firstName, String lastName, String email, String password, Filiere filiere, Date dateOfBirth, String urlAvatar)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.filiere = filiere;
        this.dateOfBirth = dateOfBirth;
        this.urlAvatar = urlAvatar;
    }
    
    public EtudiantEntity()
    {
        super();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastame()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public Filiere getFiliere()
    {
        return filiere;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String getUrlAvatar()
    {
        return urlAvatar;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastame(String lastame)
    {
        this.lastName = lastame;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setFiliere(Filiere filiere)
    {
        this.filiere = filiere;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUrlAvatar(String urlAvatar)
    {
        this.urlAvatar = urlAvatar;
    }

    @Override
    public String toString()
    {
        return "Etudiant{" + "firstName=" + firstName + ", lastame=" + lastName + ", email=" + email + ", password=" + password + ", filiere=" + filiere + ", dateOfBirth=" + dateOfBirth + ", urlAvatar=" + urlAvatar + '}';
    }

    
    public Etudiant toEtudiant()
    {  
        return new Etudiant(this.firstName,this.lastName,this.filiere,this.email,this.dateOfBirth,this.password,this.urlAvatar);
    }
    
    
}
