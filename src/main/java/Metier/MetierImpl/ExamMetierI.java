/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.MetierImpl;

import Entities.ExamenEntity;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author AbdelMajid
 */
public interface ExamMetierI {
    public ExamenEntity getExam(String xml_file);
    public void sendExam(ExamenEntity e);
    public HashMap<String, List<String>> parcourir_xml(ExamenEntity e);    
}
