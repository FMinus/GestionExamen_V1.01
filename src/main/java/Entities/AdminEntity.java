/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Metier.Admin;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Ayoub
 */
public class AdminEntity extends UserEntity
{

    public ObjectId getId()
    {
        return id;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }

    public AdminEntity(String firstName, String lastName, String email, String password, Date dateOfBirth, String urlAvatar)
    {
        super(firstName, lastName, email, password, dateOfBirth, urlAvatar);
    }

    public AdminEntity()
    {
    }
    
    public Admin toAdmin()
    {
        return new Admin(getFirstName(), getLastame(), getDateOfBirth(), getEmail(), getUrlAvatar(), getPassword());
    }
}
