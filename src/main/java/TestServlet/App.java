/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServlet;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.EtudiantDAO;
import Entities.*;
import java.util.List;

import org.mongodb.morphia.Datastore;

public class App  {
    public static void main(String[] args) 
    {
       //ServiceMorphia morphia=new ServiceMorphia();
       //Datastore dt=morphia.getDatastore();
        
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();
       
       Datastore ds = mongo.getDatastore();
       
       
       EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
       
       List<EtudiantEntity> etu = etudiantDAO.findAllEtudiants();
      
       
      
      
        
                
    }
    
    
}
    
    

