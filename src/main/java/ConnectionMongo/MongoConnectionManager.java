/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ConnectionMongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;



public final class MongoConnectionManager
{
    private static final MongoConnectionManager INSTANCE = new MongoConnectionManager();
    private static final String DB_NAME = "GestionExamen";
    
    private Morphia morphia = null;
    private Datastore datastore = null;
    private MongoClient mongoClient = null;
    
    private MongoConnectionManager()
    {
        morphia = new Morphia();
        try
        {
            mongoClient = new MongoClient();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        datastore = morphia.createDatastore(mongoClient, DB_NAME);
    }
    
    
    public static MongoConnectionManager getInstance()
    {
        return INSTANCE;
    }
    
    public Morphia getMorphia() {
        return morphia;
    }
    
    public void setMorphia(Morphia morphia)
    {
        this.morphia = morphia;
    }
    
    public Datastore getDatastore() {
        return datastore;
    }
    
    public void setDatastore(Datastore datastore)
    {
        this.datastore = datastore;
    }
    
    public MongoClient getMongoClient()
    {
        return mongoClient;
    }
    
    public void setMongoClient(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }
    
    public static String getDB_NAME()
    {
        return DB_NAME;
    }
    
    
    
}
