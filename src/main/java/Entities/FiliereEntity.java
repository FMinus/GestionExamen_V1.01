/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



import Enums.FiliereEnum;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Enumerated;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author AbdelMajid
 */
@Entity("filiere")
public class FiliereEntity extends BaseEntity
{
    
    @Enumerated
    private FiliereEnum filiere;
    
    @Reference
    List<ModuleEntity> listModule=new ArrayList<>();

    public FiliereEntity()
    {
    }
    
    

    public FiliereEntity(FiliereEnum filiere) 
    {
        this.filiere = filiere;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) 
    {
        this.id = id;
    }

    public FiliereEnum getFiliere() 
    {
        return filiere;
    }

    public void setFiliere(FiliereEnum filiere) {
        this.filiere = filiere;
    }

    public List<ModuleEntity> getListModule() {
        return listModule;
    }

    public void setListModule(List<ModuleEntity> listModule) {
        this.listModule = listModule;
    }
    

}
