package Metier;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class User implements Serializable
{
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String urlAvatar;
    private String password;

    public User(String firstName, String lastName, Date dateOfBirth, String email, String urlAvatar, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.urlAvatar = urlAvatar;
        this.password = password;
    }

    public User()
    {
    }
    
    
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUrlAvatar()
    {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar)
    {
        this.urlAvatar = urlAvatar;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", urlAvatar=" + urlAvatar + ", password=" + password + '}';
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
        final User other = (User) obj;
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
        if ( ! Objects.equals(this.urlAvatar, other.urlAvatar))
        {
            return false;
        }
        if ( ! Objects.equals(this.password, other.password))
        {
            return false;
        }
        if ( ! Objects.equals(this.dateOfBirth, other.dateOfBirth))
        {
            return false;
        }
        return true;
    }
    
    
    
}
