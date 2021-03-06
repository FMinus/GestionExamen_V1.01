package Controllers;

import Beans.CurrentUser;
import ConnectionMongo.ConnectionAdmin;
import ConnectionMongo.ConnectionEtudiant;
import ConnectionMongo.ConnectionProfesseur;
import Enums.Role;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Login implements Serializable
{
    private String email="admin@mail.com";
    private String password="admin";
    private boolean isLoggedIn = false;
    private Role role;
    
    @Inject
            CurrentUser user;
    
    public Login(String email, String password, boolean isLoggedIn, Role role)
    {
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
        this.role = role;
    }
    
    public Login()
    {
        
    }
    
    
    @PostConstruct
    public void onLoad()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        user =(CurrentUser) session.getAttribute("loggedAs");
        
    }
    
    public Role getRole()
    {
        return role;
    }
    
    public void setRole(Role role)
    {
        this.role = role;
        
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
    
    public String loginInfo()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Login log = (Login) context.getExternalContext().getSessionMap().get("loggedAs");
        
        if(log == null)
            return "------- no login info -----------";
        
        return log.toString();
    }
    
    public String currentLoginInfo()
    {
        if(user==null)
            return "no info";
        else
            return user.toString();
    }
    
    public String login() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        if(this.getRole() != null)
        {
            switch (this.getRole())
            {
                case Etudiant:
                {                  
                    return loginEtudiant();
                }
                case Professeur:
                {
                    return loginProfesseur();
                }
                default:
                {
                   return loginAdmin();
                }
            }
        }
        return "Login.xhtml?faces-redirect=true";
    }
    
     
    public String loginEtudiant() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        FacesContext context = FacesContext.getCurrentInstance();
        ConnectionEtudiant conn = new ConnectionEtudiant();
        if(conn.loginEtudiant(this.email,this.password))
        {
            role=Role.Etudiant;
            this.isLoggedIn=true;
            
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            user = this.toCurrentUser();
            
            request.getSession().setAttribute("loggedAs",user);
            
            context.getExternalContext().getSessionMap().put("currentUser", conn.getEtudiant().toEtudiant());
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
    
    public String loginProfesseur() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        FacesContext context = FacesContext.getCurrentInstance();
        ConnectionProfesseur conn = new ConnectionProfesseur();
        if(conn.loginProf(this.email,this.password))
        {
            
            role=Role.Professeur;
            this.isLoggedIn=true;
            
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            user = this.toCurrentUser();
            
            request.getSession().setAttribute("loggedAs",user);
            context.getExternalContext().getSessionMap().put("currentUser", conn.getProf().toProfessor());
            
            System.out.println("Login bean : logged in");
            
            return "Views/Professeur/HomeProfesseur.xhtml?faces-redirect=true";
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
    
    public String loginAdmin() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        
        FacesContext context = FacesContext.getCurrentInstance();
        ConnectionAdmin conn = new ConnectionAdmin();
        
        if(conn.loginAdmin(this.email,this.password))
        {
            
            role=Role.Admin;
            this.isLoggedIn=true;
            
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            
            user = this.toCurrentUser();
            
            request.getSession().setAttribute("loggedAs",user);
            context.getExternalContext().getSessionMap().put("currentUser", conn.getAdmin().toAdmin());
            
            System.out.println("Login bean : logged in");
            
            return "Views/Admin/HomeAdmin.xhtml?faces-redirect=true";
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
        
        HttpServletRequest request = getHttpServletRequest();
        //HttpSession session = request.getSession();
        //session.invalidate();
       request.getSession().removeAttribute("currentUser");
        request.getSession().removeAttribute("loggedAs");
        
        //HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //s.invalidate();
        return "Logout.xhtml";
    }
    
    
    
    public byte [] hashGenerator(String message) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        byte[] bytesOfMessage = message.getBytes("UTF-8");
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        return thedigest;
    }
    
    @Override
    public String toString()
    {
        return "Login{" + "email=" + email + ", password=" + password + ", isLoggedIn=" + isLoggedIn + ", role=" + role + '}';
    }
    
    public CurrentUser toCurrentUser()
    {
        return new CurrentUser(this.email,this.password,this.isLoggedIn,this.role);
    }
    
}
