/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginFilter;
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
        
        Login session = (Login) req.getSession().getAttribute("login");
        
        String url = req.getRequestURI();
        
        //if request is for forum or logout and there's no session redirect to login.xhtml
        //if a request is for login and there's a session redirect to forum.xhtml
        //if a request is for logout remove the session then redirect to login.xhtml
        
        //System.out.println("session attribute : "+session.isIsLoggedIn());
        
        //System.out.println("Requested URI is : "+url);
        
        if(session == null || !session.isIsLoggedIn())
        {
            //System.out.println("Null session or isLoggedIn = false");
            
            if(url.contains("Home.xhtml") || url.contains("Logout.xhtml"))
            {
                res.sendRedirect(req.getServletContext().getContextPath()+"/Login.xhtml");
            }
            else
            {
                chain.doFilter(request, response);
            }
        }
        else
        {
            if(url.contains("RegisterEtudiant.xhtml") || url.contains("Login.xhtml"))
            {
                res.sendRedirect(req.getServletContext().getContextPath()+"/Home.xhtml");
            }
            else if(url.contains("Logout.xhtml") )
            {
                req.getSession().removeAttribute("login");
                res.sendRedirect(req.getServletContext().getContextPath()+"/Login.xhtml");
            }
            else
            {
                //System.out.println("loginfilter - logged in : session.isLoggedin = "+session.isIsLoggedIn());
                chain.doFilter(request, response);
            }
                
              
            
        }
        
        
        
        
        
        
    }

    @Override
    public void destroy()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
