/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



import Enums.Filiere;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Enumerated;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author AbdelMajid
 */
@Entity("filiere")
public class FiliereEntity 
{
    @Id
    private ObjectId id;
    
    @Enumerated
    private Filiere filiere;
    @Reference
    List<ModuleEntity> listModule=new ArrayList<>();

    public FiliereEntity(Filiere filiere) 
    {
        this.filiere = filiere;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<ModuleEntity> getListModule() {
        return listModule;
    }

    public void setListModule(List<ModuleEntity> listModule) {
        this.listModule = listModule;
    }
    

}
