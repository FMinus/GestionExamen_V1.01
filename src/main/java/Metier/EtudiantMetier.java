package Metier;

import Entities.EtudiantEntity;
import Enums.Filiere;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import Connection.ConnectionEtudiant;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EtudiantMetier implements Serializable
{
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Filiere filiere;
    private Date dateOfBirth;
    private String urlAvatar;
    
    public EtudiantMetier(String firstName, String lastName, String email, String password, Filiere filiere, Date dateOfBirth, String urlAvatar)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.filiere = filiere;
        this.dateOfBirth = dateOfBirth;
        this.urlAvatar = urlAvatar;
    }
    
    public EtudiantMetier()
    {
        super();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
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

    public void setLastName(String lastame)
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

    @Override
    public int hashCode()
    {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final EtudiantMetier other = (EtudiantMetier) obj;
        if ( ! Objects.equals(this.firstName, other.firstName))
        {
            return false;
        }
        if ( ! Objects.equals(this.lastName, other.lastName))
        {
            return false;
        }
        if ( ! Objects.equals(this.email, other.email))
        {
            return false;
        }
        return true;
    }
    
    
    public EtudiantEntity toEtudiantEntity()
    {
        return new EtudiantEntity(this.firstName,this.lastName,this.email,this.password,this.filiere.toString(),this.dateOfBirth.toString(),this.urlAvatar);
    }
    
    public void Register()
    {
        ConnectionEtudiant conn= new ConnectionEtudiant();
        //r.registerEtudiant(new EtudiantMetier(this.firstName,this.lastName,this.email,this.password,this.filiere,this.dateOfBirth,this.urlAvatar));
        conn.registerEtudiant(this);
        /*
        System.out.println("first name : "+this.firstName);
        System.out.println("last name : "+this.lastName);
        System.out.println(this.dateOfBirth);
        System.out.println("filiere : "+this.filiere);
        System.out.println("email : "+this.email);
        System.out.println("avatar url : "+this.urlAvatar);
        System.out.println("password : "+this.password);
        */
    }
    
    
    
    
    
    
    
    
    
}
