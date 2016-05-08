package Entities;

import Enums.Filiere;
import java.io.Serializable;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import Metier.EtudiantMetier;
import java.util.Calendar;

@Entity
public class EtudiantEntity extends BaseEntity
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String filiere;
    private String dateOfBirth;
    private String urlAvatar;
    
    public EtudiantEntity(String firstName, String lastName, String email, String password, String filiere, String dateOfBirth, String urlAvatar)
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

    public String getFiliere()
    {
        return filiere;
    }

    public String getDateOfBirth()
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

    public void setFiliere(String filiere)
    {
        this.filiere = filiere;
    }

    public void setDateOfBirth(String dateOfBirth)
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

    
    public EtudiantMetier toEtudiantMetier()
    {
        Calendar cal = Calendar.getInstance();
        Date t = cal.getTime();
        return new EtudiantMetier(this.firstName,this.lastName,this.email,this.password,Filiere.valueOf(this.filiere),t,this.urlAvatar);
    }
    
    
}
