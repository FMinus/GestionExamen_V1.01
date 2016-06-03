/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServlet.Demo;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.MessageDAO;
import Entities.MessageEntity;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
public class NotificationTest
{
    public static void main(String[] args)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        MessageDAO messageDAO = new MessageDAO(MessageEntity.class, ds);
        
        messageDAO.markAllAsUnRead();
    }
    
}
