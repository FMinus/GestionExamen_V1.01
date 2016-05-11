package Beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBean
{
     public static HttpSession getSession() 
     {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
     }
     
     public static HttpServletRequest getRequest() 
     {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
     }
     
      public static Object getCurrentUser() 
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false); 
        return session.getAttribute("currentUser");
        
      }
      
      public static Object getIsLoggedIn() 
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false); 
        return session.getAttribute("loggedAs");
        
      }
}


