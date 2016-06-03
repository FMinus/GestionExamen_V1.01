/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import Enums.Role;
import Metier.Etudiant;
import Metier.User;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class TimerExamen
{
   
    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*/5", second = "0", persistent = false)
    public void myTimer()
    {
        System.out.println("Timer event: " + new Date());
        
        /*
        CurrentUser currentUser;
        currentUser = (CurrentUser) SessionBean.getIsLoggedIn();
        
        if(currentUser == null)
            System.out.println("user is null");
        else
            System.out.println("user : "+currentUser);
        */
}
    
}
