/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionMongo;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import org.mongodb.morphia.*;


/**
 *
 * @author AbdelMajid
 */
@Singleton
public class ServiceMorphia 
{
    
    private Morphia morphia;
    private Datastore datastore;
    private final String serverIp = "localhost";
    private final int serverPort = 27017;
    private final String databaseName = "GestionExamen";
    MongoClient client;
    
    public ServiceMorphia() 
    {
          try 
          {
            client=new MongoClient(serverIp , serverPort);         
            this.morphia=new Morphia();          
            this.datastore=morphia.createDatastore(client, databaseName);   
            morphia.mapPackage("Entities");
            
          }
          catch(Exception e)
          {
              throw new RuntimeException("Error initializing mongo db", e);
          }
        
    }

    public Morphia getMorphia() {
        return morphia;
    }

    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }

    public Datastore getDatastore() {
        return datastore;
    }

    public void setDatastore(Datastore datastore) 
    {
        this.datastore = datastore;
    }
    
    public void closeConnection()
    {   
        client.close();       
    }
    
    
}
