/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Morphia;

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
public class ServiceMorphia {
    private Morphia morphia;
    private Datastore datastore;

    public ServiceMorphia() {
        
            MongoClient client=new MongoClient("localhost" , 27017);
            this.morphia=new Morphia();
            String DBname="G_ETUD";
            this.datastore=morphia.createDatastore(client, DBname);
        
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

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }
    
    
    
}
