/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controllers;

import Metier.Etudiant;
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
    
    //@Inject Etudiant etudiant;
      
    
    
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        //HttpSession session = se.getSession();
       
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        totalActiveSessions--;
        
    }
    
}
