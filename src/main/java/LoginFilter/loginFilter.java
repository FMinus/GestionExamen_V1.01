/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginFilter;
import Beans.CurrentUser;
import Beans.SessionBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controllers.Login;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.Facelet;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Ayoub
 */
public class loginFilter implements Filter
{
    
   
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
   
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        CurrentUser session = (CurrentUser) req.getSession().getAttribute("loggedAs");
       
        
        if(session!=null)
            System.out.println(session);
        //Login session = (Login) FacesContext.getCurrentInstance().getExternalContext().getSession(false).g
        
        //HttpSession httpSession = SessionBean.getSession();
        //Login session = (Login) SessionBean.getSession().getAttribute("loggedAs");
        
        String url = req.getRequestURI();
        
        //if request is for forum or logout and there's no session redirect to login.xhtml
        //if a request is for login and there's a session redirect to forum.xhtml
        //if a request is for logout remove the session then redirect to login.xhtml
        
        //System.out.println("session attribute : "+session.isIsLoggedIn());
        
        //System.out.println("Requested URI is : "+url);
        
        
        if(session == null || !session.isIsLoggedIn())
        {
            //System.out.println("Null session or isLoggedIn = false");
            if(session!=null)
            {
                 //System.out.println("session is not null "+session.isIsLoggedIn());
                 System.out.println("session is not null "+session.getRole());
                 System.out.println("session is not null "+session.getEmail());
                 System.out.println("session is not null "+session.getPassword());
            }
            else
            {
                System.out.println("Session is null");
            }
               
            
            if(url.contains("Etudiant") || url.contains("Professeur") || url.contains("Admin"))
            {
                System.out.println("Filter : contains");
                //res.sendRedirect(req.getServletContext().getContextPath()+"/Login.xhtml");
                chain.doFilter(request, response);
            }
            else
            {
                chain.doFilter(request, response);
            }
        }
        else
        {
            if(url.contains("Register") || url.contains("Login.xhtml") || !url.contains(session.getRole().name()))
            {
                res.sendRedirect(req.getServletContext().getContextPath()+"/Home.xhtml");
            }
            else if(url.contains("Logout.xhtml") )
            {
                //req.getSession().removeAttribute("currentUser");
                //req.getSession().removeAttribute("loogedAs");
                
                res.sendRedirect(req.getServletContext().getContextPath()+"/Login.xhtml");
            }
            else
            {
                //System.out.println("loginfilter - logged in : session.isLoggedin = "+session.isIsLoggedIn());
                chain.doFilter(request, response);
            }
                
              
            
        }
        
        
        
        
        
        
    }
    private static final Logger LOG = Logger.getLogger(loginFilter.class.getName());

    @Override
    public void destroy()
    {
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
