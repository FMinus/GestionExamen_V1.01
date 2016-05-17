/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.Date;

/**
 *
 * @author Ayoub
 */
public class Admin extends User       
{

    public Admin(String firstName, String lastName, Date dateOfBirth, String email, String urlAvatar, String password)
    {
        super(firstName, lastName, dateOfBirth, email, urlAvatar, password);
    }

    public Admin()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
    
    
    
}
