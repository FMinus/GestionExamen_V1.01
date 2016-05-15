/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Ayoub
 */
public class UserEntity extends BaseEntity
{
    private String firstName;
    private String lastName;
    private String email;
    private String password; 
    private Date dateOfBirth;
    private String urlAvatar;

    public UserEntity(String firstName, String lastName, String email, String password, Date dateOfBirth, String urlAvatar)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.urlAvatar = urlAvatar;
    }
    
    
    
    
    public UserEntity()
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
        return "UserEntity{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", urlAvatar=" + urlAvatar + '}';
    }
    
    
    
}
