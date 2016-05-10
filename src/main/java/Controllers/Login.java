package Controllers;

import ConnectionMongo.ConnectionEtudiant;
import Enums.Role;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class Login implements Serializable
{
    private String email;
    private String password;
    private boolean isLoggedIn = false;
    private Role role;

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
        System.out.println(role);
    }
      
    public boolean isIsLoggedIn()
    {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn)
    {
        this.isLoggedIn = isLoggedIn;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public HttpServletRequest getHttpServletRequest()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        return request;
    }
    
    public String loginEtudiant()
    {
        ConnectionEtudiant conn = new ConnectionEtudiant();
        
        if(conn.loginEtudiant(this.email, this.password))
        {
            isLoggedIn=true;
            role=Role.Etudiant;
            //TODO
            //retrieve the user's cridentials :       
            
            
            HttpServletRequest request = getHttpServletRequest();
            
            request.getSession().setAttribute("userEtudiant", conn.getEtudiant().toEtudiantMetier());
            
            
            
            if(conn.getEtudiant() != null)
                System.out.println("Login Etudiant : "+conn.getEtudiant());
            
            System.out.println("Login bean : logged in");
            return "Views/Etudiant/HomeEtudiant.xhtml?faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "Login.xhtml";
        }
            
    }
    
    public String loginProfesseur()
    {
        //TODO 
        
        ConnectionEtudiant conn = new ConnectionEtudiant();
        
        if(conn.loginEtudiant(this.email, this.password))
        {
            System.out.println("metier : logged in");
            return "Home.xhtml?faces-redirect=true";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "Login.xhtml";
        }
            
    }
    
    public String logout()
    {
        isLoggedIn = false;
        return "Login.xhtml?faces-redirect=true";
    }
}
