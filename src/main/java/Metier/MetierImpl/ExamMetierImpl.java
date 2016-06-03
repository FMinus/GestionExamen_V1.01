/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.MetierImpl;

import DAO.XmlDAO.*;
import Entities.ExamenEntity;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author AbdelMajid
 */
public class ExamMetierImpl implements ExamMetierI
{
    private XML_DAO xml_dao=new XML_DAO();

    public void setXml_dao(XML_DAO xml_dao) {
        this.xml_dao = xml_dao;
    }

    @Override
    public ExamenEntity getExam(String xml_file) {
      return  xml_dao.to_Object(xml_file);    }

    @Override
    public void sendExam(ExamenEntity e) {
        xml_dao.toXML(e);
    }

    @Override
    public HashMap<String, List<String>> parcourir_xml(ExamenEntity e) {
        return  xml_dao.parcourir_xml(e);
    }
    
}
