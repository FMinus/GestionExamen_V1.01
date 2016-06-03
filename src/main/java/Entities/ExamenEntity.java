/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.mongodb.morphia.annotations.*;


/**
 *
 * @author AbdelMajid
 */

@XmlRootElement(name="Examen")
@Entity(value = "examen" ,noClassnameStored = true)
public class ExamenEntity extends BaseEntity implements Serializable
{
    @Temporal(value = TemporalType.DATE)
    private Date dateDebut;
    
    @Temporal(value = TemporalType.DATE)
    private Date dateFin;
    
    private String nomFichierXML;
    
    private  List<QuestionEntity> questions=new ArrayList<>();
    
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

    public String getNomFichierXML()
    {
        return nomFichierXML;
    }

    public void setNomFichierXML(String nomFichierXML)
    {
        this.nomFichierXML = nomFichierXML;
    }

    public ModuleEntity getModule()
    {
        return module;
    }

    public void setModule(ModuleEntity module)
    {
        this.module = module;
    }

    
    
    
    public List<QuestionEntity> getQuestions() 
    {
        return questions;
    }
    
    @XmlElement
    public void setQuestions(List<QuestionEntity> questions) 
    {
        this.questions = questions;
    }
   
    
    public ExamenEntity() 
    {        
    }

    public ExamenEntity(Date dateDebut, Date dateFin, ModuleEntity module , String nomFichierXML)
    {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nomFichierXML = nomFichierXML;
        this.module = module;
    }

    @Override
    public String toString()
    {
        return "ExamenEntity{" + "dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nomFichierXML=" + nomFichierXML + ", questions=" + questions + ", module=" + module + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.dateDebut);
        hash = 61 * hash + Objects.hashCode(this.dateFin);
        hash = 61 * hash + Objects.hashCode(this.nomFichierXML);
        hash = 61 * hash + Objects.hashCode(this.questions);
        hash = 61 * hash + Objects.hashCode(this.module);
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
        if ( ! Objects.equals(this.nomFichierXML, other.nomFichierXML))
        {
            return false;
        }
        if ( ! Objects.equals(this.dateDebut, other.dateDebut))
        {
            return false;
        }
        if ( ! Objects.equals(this.dateFin, other.dateFin))
        {
            return false;
        }
        if ( ! Objects.equals(this.questions, other.questions))
        {
            return false;
        }
        if ( ! Objects.equals(this.module, other.module))
        {
            return false;
        }
        return true;
    }
   
    
    
   
    
     
     
    
}
