/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import org.mongodb.morphia.annotations.Entity;

@Entity("message")
public class MessageEntity extends BaseEntity
{
    private String emailFrom;
    
    private String emailTo;
    
    private String message;
    
    private Date dateEnvoi;
    
    private boolean lus;
    
    private String subject;

    public MessageEntity()
    {
    }

    public MessageEntity(String emailFrom, String emailTo, String message, Date dateEnvoi, boolean lus)
    {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
        this.lus = lus;
    }
    
    

    public Date getDateEnvoi()
    {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi)
    {
        this.dateEnvoi = dateEnvoi;
    }

    public boolean isLus()
    {
        return lus;
    }

    public void setLus(boolean lus)
    {
        this.lus = lus;
    }
    
    
    
    public String getEmailFrom()
    {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom)
    {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo()
    {
        return emailTo;
    }

    public void setEmailTo(String emailTo)
    {
        this.emailTo = emailTo;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    

    @Override
    public String toString()
    {
        return "MessageEntity{" + "emailFrom=" + emailFrom + ", emailTo=" + emailTo + ", message=" + message + '}';
    }
    
    
}
