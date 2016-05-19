/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.MessageDAO;
import Entities.MessageEntity;
import java.util.List;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
public class Services
{
    public static List<MessageEntity> getMessagesOf(String email)
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();
       
       MessageDAO msgDAO = new MessageDAO(MessageEntity.class, ds);
       return msgDAO.getAllMessagesOf(email);
 
    }
    
    public static int countUnreadMessages(List<MessageEntity> msgs)
    {
        int count = 0;
        for(MessageEntity m : msgs)
        {
            if(m.isLus())
                count++;                
        }      
        return count;
    }
    
    public static List<MessageEntity> getUnreadMessagesOf(String email)
    {
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();
       
       MessageDAO msgDAO = new MessageDAO(MessageEntity.class, ds);
       return msgDAO.getAllMessagesOf(email);
 
    }
    
    
}
