/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controllers.Login;
import Enums.Role;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ManagedBean;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Ayoub
 */
@ManagedBean
@SessionScoped
public class CurrentUser implements Serializable
{
    private String email;
    private String password;
    private boolean isLoggedIn;
    private Role role;
    
    Map<String,String> Data;

    public Map<String, String> getData()
    {
        Data = new HashMap<>();
        
        
        return Data;
    }
    
    
    
    public CurrentUser(String email, String password, boolean isLoggedIn, Role role)
    {
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.role = role;
    }
    
    
    public CurrentUser()
    {
    }

    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isIsLoggedIn()
    {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn)
    {
        this.isLoggedIn = isLoggedIn;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
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
        final CurrentUser other = (CurrentUser) obj;
        if ( ! Objects.equals(this.email, other.email))
        {
            return false;
        }
        if ( ! Objects.equals(this.password, other.password))
        {
            return false;
        }
        if (this.role != other.role)
        {
            return false;
        }
        return true;
    }
    
    public Login toLogin()
    {
        return new Login(this.email,this.password,this.isLoggedIn,this.role);
    }

    @Override
    public String toString()
    {
        return "CurrentUser{" + "email=" + email + ", password=" + password + ", isLoggedIn=" + isLoggedIn + ", role=" + role + '}';
    }
    
    
    
    
    
}
