/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers;

import Metier.EtudiantMetier;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Ayoub
 */
public class SessionLoginListener implements HttpSessionListener
{
    private static int totalActiveSessions;
    
    @Inject EtudiantMetier etudiant;
      
    
    
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        totalActiveSessions++;
        //System.out.println("Session Created : "+totalActiveSessions);
        
        HttpSession session = se.getSession();
        
        //fired every time the session gets created : new user 
        //reloading does not create a new session 
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        totalActiveSessions--;
        
    }
    
}
