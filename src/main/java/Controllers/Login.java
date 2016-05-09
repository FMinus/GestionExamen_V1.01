package Controllers;

import Connection.ConnectionEtudiant;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Login implements Serializable
{
    private String email;
    private String password;

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
    
    public String loginEtudiant()
    {
        ConnectionEtudiant conn = new ConnectionEtudiant();
        
        if(conn.loginEtudiant(this.email, this.password))
        {
            System.out.println("metier : logged in");
            return "Home";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "Login";
        }
            
    }
    
    public String loginProfesseur()
    {
        //TODO 
        
        ConnectionEtudiant conn = new ConnectionEtudiant();
        
        if(conn.loginEtudiant(this.email, this.password))
        {
            System.out.println("metier : logged in");
            return "Home";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "Login";
        }
            
    }
}
