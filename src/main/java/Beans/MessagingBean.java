/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.MessageDAO;
import Entities.MessageEntity;
import Metier.User;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.mongodb.morphia.Datastore;

@ManagedBean
@SessionScoped
public class MessagingBean implements Serializable
{
    //use that we'll send a message to : 
    private User user;
    
    private MessageEntity message = new MessageEntity();
    
    @ManagedProperty(value="#{home.user.email}")
    private String emailFrom;

    
    
    public String getEmailFrom()
    {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom)
    {
        this.emailFrom = emailFrom;
    }
    
     
    public MessageEntity getMessage()
    {
        return message;
    }

    public void setMessage(MessageEntity message)
    {
        this.message = message;
    }
    
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
    
    
    public void attrListener(ActionEvent event)
    {
 
	emailFrom = (String)event.getComponent().getAttributes().get("emailfrom");
 
    }
    
    public String someAction(User u)
    {
        System.out.println("Test Action : ");
        
        user = u;
        //System.out.println(user.toString());
        
        
        
        return "Message.xhtml?faces-redirect=true";
    }
    
    public String sendMessage(String emailFrom)
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();
       
       MessageDAO messageDAO = new MessageDAO(MessageEntity.class, ds);
       
       //message.setEmailFrom(user.getEmail());
       
       String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("me");
       
        System.out.println("message from : "+emailFrom);
        System.out.println("message to : "+user.getEmail());
        System.out.println("message subject : "+message.getSubject());
        System.out.println("message : "+message.getMessage());
        
        message.setEmailFrom(emailFrom);
        message.setEmailTo(user.getEmail());
        message.setLus(false);
        
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        message.setDateEnvoi(cal.getTime());
        
        
        messageDAO.save(message);
                
       return "";
    }
}
