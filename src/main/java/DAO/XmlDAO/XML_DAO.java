package DAO.XmlDAO;

import Entities.ExamenEntity;
import Entities.ResponseEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.*;

/**
 *
 * @author AbdelMajid
 */
public class XML_DAO implements IXML{
    
    @Override
    public void toXML(ExamenEntity exam) 
    {
        try 
        {
            JAXBContext context=JAXBContext.newInstance(ExamenEntity.class);
            Marshaller ms=context.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(exam, new File("e:/EXAMEN"+exam.getModule().getModuleName()+""+exam.getId()+".xml"));
            ms.marshal(exam, System.out);
        }
        catch (JAXBException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public ExamenEntity to_Object(String xmlFile) 
    {
        ExamenEntity exam=null;
        try
        {
            JAXBContext context=JAXBContext.newInstance(ExamenEntity.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            exam=(ExamenEntity) unmarshaller.unmarshal(new File("e:/"+xmlFile+".xml"));
            
            
        }
        catch (JAXBException ex) 
        {
            ex.printStackTrace();
        }
        return exam;
    }
    
    @Override
    public HashMap<String, List<String>> parcourir_xml(ExamenEntity exam)
    {
        List<String> response=new ArrayList<>();
        String question="";
        HashMap<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<exam.getQuestions().size();i++)
        {
            question =exam.getQuestions().get(i).getQuestion();
            
            for(ResponseEntity b:exam.getQuestions().get(i).getResponses())
            {
                response.add(b.getReponse());
            }
            
            map.put(question, response);
            System.out.println(response.size());
            
            question="";
            response.clear();
            
        }
        return map;
    }
    
    
}
