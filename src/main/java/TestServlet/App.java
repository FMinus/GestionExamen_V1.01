/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServlet;

import DAO.IDAO.DAO.EtudiantDAO;
import DAO.IDAO.DAO.ProfessorDAO;
import DAO.IDAO.IDAO;
import Entities.*;
import Controllers.Morphia.ServiceMorphia;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.* ;
import sun.applet.Main;

/**
 *
 * @author AbdelMajid
 */
public class App  {
    public static void main(String[] args) 
    {
       //ServiceMorphia morphia=new ServiceMorphia();
       //Datastore dt=morphia.getDatastore();
        
        System.out.println("Current working directory : " + System.getProperty("user.dir"));
      
    }
}
    
    

