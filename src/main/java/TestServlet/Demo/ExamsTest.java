/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package TestServlet.Demo;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.ExamenDAO;
import DAO.MongoDao.ModuleDAO;
import Entities.ExamenEntity;
import Entities.ModuleEntity;
import java.util.Calendar;
import java.util.Date;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Ayoub
 */
public class ExamsTest
{
    public static void main(String[] args)
    {
        MongoConnectionManager mongo = MongoConnectionManager.getInstance();
        Datastore ds = mongo.getDatastore();
        
        ExamenDAO examenDAO = new ExamenDAO(ExamenEntity.class,ds);
        ModuleDAO moduleDAO = new ModuleDAO(ModuleEntity.class, ds);
        ModuleEntity module = moduleDAO.findByName("GPI");
        
        long minute=60000;
        long hour = minute * 60;
        
        Calendar date = Calendar.getInstance();
        long now = date.getTimeInMillis();
        
        Date twoHoursAgo = new Date(now - 2*hour);
        Date twoHoursLater = new Date(now + 2*hour);
        
        examenDAO.updateDateExamen(twoHoursAgo, twoHoursLater, module);
        
    }
    
}
