/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XmlDAO;

import Entities.ExamenEntity;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author AbdelMajid
 */
public interface IXML {
    public void toXML(ExamenEntity examen) ;
    public ExamenEntity to_Object(String xmlFile);
    public HashMap<String,List<String>> parcourir_xml(ExamenEntity exam);
    
    
    
    
}
