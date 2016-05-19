/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServlet;

import ConnectionMongo.MongoConnectionManager;
import DAO.MongoDao.FiliereDAO;
import DAO.MongoDao.ModuleDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.*;
import Enums.FiliereEnum;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;

public class App  {
    public static void main(String[] args) 
    {
       //ServiceMorphia morphia=new ServiceMorphia();
       //Datastore dt=morphia.getDatastore();
       
       MongoConnectionManager mongo = MongoConnectionManager.getInstance();     
       Datastore ds = mongo.getDatastore();
       
       /*
       AdminDAO admindao = new AdminDAO(AdminEntity.class, ds);
       AdminEntity admin = new AdminEntity("jalil", "messaf", "admin@mail.com", "admin", null, "[B@71844c48.png");
       
       //admindao.save(admin);
       
       EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
       
       EtudiantEntity etudiant = new EtudiantEntity();
       etudiant.setEmail("ensa@mail.com");
       etudiant.setFirstName("anas");
       
       etudiantDAO.updateEtudiant(etudiant);
       */
       
       /*
       ProfessorEntity p = new ProfessorEntity();
       p.setEmail("testProf@mail.com");
       p.setFirstName("prof");
       p.setLastame("prof");
       p.setPassword("prof");
       p.setDateOfBirth(null);
       p.setUrlAvatar("[B@1d33e602");
       
       ModuleEntity m1 = new ModuleEntity("Metaeuristique", p);
       ModuleEntity m2 = new ModuleEntity("GPI", p);
       ModuleEntity m3 = new ModuleEntity("Android", p);
       ModuleEntity m4 = new ModuleEntity("Programmation System", p);
       ModuleEntity m5 = new ModuleEntity("Oracle", p);
       ModuleEntity m6 = new ModuleEntity("Francais", p);
       ModuleEntity m7 = new ModuleEntity("Anglais", p);
       
       List<ModuleEntity> list = new ArrayList<>();
       
       list.add(m1);
       list.add(m2);
       list.add(m3);
       list.add(m4);
       list.add(m5);
       list.add(m6);
       list.add(m7);
       
       
       
       FiliereEntity filiere = new FiliereEntity(FiliereEnum.GI, list);
       
       
       
       
       
       
       profDao.save(p);
       
       p.setModules(list);
       
       moduledao.save(m1);
       moduledao.save(m2);
       moduledao.save(m3);
       moduledao.save(m4);
       moduledao.save(m5);
       moduledao.save(m6);
       moduledao.save(m7);
       
       profDao.save(p);
       
       filieredao.save(filiere);
        
      */
       
       
       ProfessorDAO profDao = new ProfessorDAO(ProfessorEntity.class, ds);
       ModuleDAO moduledao = new ModuleDAO(ModuleEntity.class, ds);
       
       FiliereDAO filieredao = new FiliereDAO(FiliereEntity.class, ds);
       List<ModuleEntity> list = filieredao.getList(FiliereEnum.GI);
       
        System.out.println("modules : "+list);
               
                
    }
    
    
    
    
}
    
    

