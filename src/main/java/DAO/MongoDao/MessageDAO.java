/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MongoDao;

import Entities.MessageEntity;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;


public class MessageDAO extends BasicDAO<MessageEntity, Object>
{
    
    public MessageDAO(Class<MessageEntity> entityClass, Datastore ds)
    {
        super(entityClass, ds);
    }
    
    public MessageEntity findMessageBySender(String email)
    {
        return createQuery().field("emailFrom").equal(email).get();
    }
    
    public MessageEntity findMessageByReciever(String email)
    {
        return createQuery().field("emailTo").equal(email).get();
    }
    
    public String getMessageFromEntity(MessageEntity m)
    {
        return m.getMessage();
    }
    
    public List<MessageEntity> getAllMessagesOf(String email)
    {
        return createQuery().field("emailTo").equal(email).asList();
    }
    
    public List<MessageEntity> getUnreadMessages(String email)
    {
        Query<MessageEntity> query = createQuery();       
        query.and
        (
            query.criteria("emailTo").equal(email),
            query.criteria("lus").equal(false)
        );  
       return query.asList();
    }
   
    
    
    
}
