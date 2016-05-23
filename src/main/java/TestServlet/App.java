/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServlet;

import ConnectionMongo.MongoConnectionManager;
import Controllers.Admin.OpAdmin;
import DAO.MongoDao.AdminDAO;
import DAO.MongoDao.EtudiantDAO;
import DAO.MongoDao.FiliereDAO;
import DAO.MongoDao.ModuleDAO;
import DAO.MongoDao.ProfessorDAO;
import Entities.*;
import Enums.FiliereEnum;
import Metier.Etudiant;
import Metier.Professor;
import Metier.User;
import java.util.ArrayList;
import java.util.Date;
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
       
       
       ProfessorEntity p = new ProfessorEntity();
       
       ProfessorDAO profDao = new ProfessorDAO(ProfessorEntity.class, ds);
       
       //ProfessorEntity p = profDao.getByEmail("testProf@mail.com");
       
       
       
       p.setEmail("prof@mail.com");
       p.setFirstName("prof");
       p.setLastame("prof");
       p.setPassword("prof");
       p.setDateOfBirth(new Date());
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
       
       
       ModuleDAO moduledao = new ModuleDAO(ModuleEntity.class, ds);
       
       
       
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
       
       FiliereDAO filieredao = new FiliereDAO(FiliereEntity.class, ds);
       filieredao.save(filiere);
        
      
       
       
       
       
       EtudiantDAO etudiantDAO = new EtudiantDAO(EtudiantEntity.class, ds);
       AdminDAO adminDAO = new AdminDAO(AdminEntity.class, ds);
       
       
       
       
       //List<ModuleEntity> list = filieredao.getList(FiliereEnum.GI);
       
       //System.out.println("modules : "+list);
       /*
       OpAdmin adminOp = new OpAdmin();
       
       List<FiliereEntity> listfFiliereEntitys = adminOp.getAllFilieres();
       List<ModuleEntity> listmod = listfFiliereEntitys.get(0).getListModule();
       
       System.out.println("modules : "+listmod);
     
       //ProfessorEntity p = profDao.getByEmail("testProf@mail.com");
       
       //System.out.println("prof : "+p);
       //System.out.println("modules : "+p.modules);
       
       
       //ModuleEntity m = new ModuleEntity("Sport", p);
       
       //profDao.addModuleTo(p, m);
       
       //p = profDao.getByEmail("testProf@mail.com");
       
        //System.out.println("after update module : "+p.getModules());
           
       
       //EtudiantEntity e = etudiantDAO.findByEmail("ensa@mail.com");
       //System.out.println("etudiant : "+e);
       
       //AdminEntity admin = adminDAO.findByEmail("admin@mail.com");
       
       //System.out.println("after convert to admin metier : "+admin.toAdmin());
       
       /*
       User etudiant = new Etudiant();
       
       if(etudiant instanceof Etudiant)
           System.out.println("yes");
               
       if(etudiant instanceof Professor)
           System.out.println("no");
        */
    }
    
    
    
    
}
    
    

