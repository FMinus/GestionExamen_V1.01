/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginFilter;
import Beans.CurrentUser;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Ayoub
 */
public class loginFilter implements Filter
{
    @Inject CurrentUser user;
    
    @Inject CurrentUser temp;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
      
   
    }
    
    @SuppressWarnings(value = "")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        //CurrentUser session = (CurrentUser) req.getSession().getAttribute("loggedAs");
        //Etudiant etudiant = (Etudiant) req.getSession().getAttribute("currentUser");
         
        try
        {
         HttpSession session = req.getSession(false);
         
         
         
         
         temp = (session != null) ? (CurrentUser) session.getAttribute("loggedAs") : null;
         
         if(temp!=null)
             user = temp;
         
         String url = req.getRequestURI();
        /*
        if(user != null)
            System.out.println("user is "+user);
        else
            System.out.println("Fuck you it's now null");
        */
        
        if(url.contains("resources"))
                chain.doFilter(request, response);
        
        if(session == null || !user.isIsLoggedIn())
        {
            //System.out.println("back to login "+url);
            
            if(url.contains("/Etudiant") || url.contains("/Professeur") || url.contains("/Admin"))
            {       
                res.sendRedirect(req.getServletContext().getContextPath()+"/Login.xhtml");
                
            }
            
            if(url.contains("/Login.xhtml") || url.contains("/Register.xhtml"))
            {
                chain.doFilter(request, response);
            }        
        }
        else
        {
            if(!url.contains(user.getRole().toString()) || url.contains("/Login.xhtml") || url.contains("/Register.xhtml"))
            {
                res.sendRedirect(req.getServletContext().getContextPath()+"\\Views\\"+user.getRole().toString()+"\\Home"+user.getRole().toString()+".xhtml");
               
                       
            }
            
            
        }
        }
        catch(Exception e)
        {
            
        }

        chain.doFilter(request, response);
        
        
        
    }

    @Override
    public void destroy()
    {
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
