/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.mongodb.morphia.annotations.*;


/**
 *
 * @author AbdelMajid
 */
@Entity(value = "examen" ,noClassnameStored = true)
public class ExamenEntity extends BaseEntity
{
    @Temporal(value = TemporalType.DATE)
    private Date dateDebut;
    
    @Temporal(value = TemporalType.DATE)
    private Date dateFin;
    
    @Reference
    private ModuleEntity module;

    public Date getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
    }

    public ModuleEntity getModule()
    {
        return module;
    }

    public void setModule(ModuleEntity module)
    {
        this.module = module;
    }

    public ExamenEntity()
    {
    }

    public ExamenEntity(Date dateDebut, Date dateFin, ModuleEntity module)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.module = module;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.dateDebut);
        hash = 13 * hash + Objects.hashCode(this.dateFin);
        hash = 13 * hash + Objects.hashCode(this.module);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final ExamenEntity other = (ExamenEntity) obj;
        if ( ! Objects.equals(this.dateDebut, other.dateDebut))
        {
            return false;
        }
        if ( ! Objects.equals(this.dateFin, other.dateFin))
        {
            return false;
        }
        if ( ! Objects.equals(this.module, other.module))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Examen{" + "dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", module=" + module + '}';
    }
    
    
    
    
    
    
     
     
    
}
