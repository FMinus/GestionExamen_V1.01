package DAO;

import Entities.EtudiantEntity;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

public class DAOEtudiant
{
   private String dbServer;
   private String dbName;
   private String collectionName;
   private int port;
   
   
   public DAOEtudiant()
   {
       super();
   }

    public DAOEtudiant(String dbServer, String dbName, int port)
    {
        this.dbServer = dbServer;
        this.dbName = dbName;
        this.port = port;
    }
   
   
   public List<EtudiantEntity> getAllEtudiants(String term,String value)
   {
       List<EtudiantEntity> etuList;
       try (MongoClient mongoClient = new MongoClient(dbServer,port))
       { 
           Morphia morphia = new Morphia();
           morphia.map(EtudiantEntity.class);
           
           Datastore ds = morphia.createDatastore(mongoClient, dbName);
           
           etuList = ds.find(EtudiantEntity.class, term,value).asList();
       }
        
        return etuList;
   }
   
   public void insertEtudiant(EtudiantEntity etudiant)
   {
       try (MongoClient mongoClient = new MongoClient(dbServer,port))
       {
           Morphia morphia = new Morphia();
           morphia.map(EtudiantEntity.class);
           
           Datastore ds = morphia.createDatastore(mongoClient, dbName);
           ds.save(etudiant);
       }      
   }
   
   public EtudiantEntity loginEtudiant(String email,String password)
   {
       //List<EtudiantEntity> etuList;
       
       EtudiantEntity etudiant;
       
       try (MongoClient mongoClient = new MongoClient(dbServer,port))
       { 
           Morphia morphia = new Morphia();
           morphia.map(EtudiantEntity.class);
           
           Datastore ds = morphia.createDatastore(mongoClient, dbName);
          
           //etuList = ds.find(EtudiantEntity.class,"email:",email,"password:",password);
           
           Query<EtudiantEntity> query = ds.createQuery(EtudiantEntity.class).limit(1);
           
           query.and
            (
                    query.criteria("email").equal(email),
                    query.criteria("password").equal(password)
            );
           
           etudiant = (EtudiantEntity) query.get();
           //etuList = query.asList();
       }
        
        return etudiant;
   }
  
    
}
