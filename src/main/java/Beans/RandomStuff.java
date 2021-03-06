/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import Enums.FiliereEnum;
import Metier.Etudiant;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class RandomStuff implements Serializable
{
    private static ArrayList<Etudiant> etudiantList2 = etudiantList =
            new ArrayList<Etudiant>(
                    Arrays.asList
                                (new Etudiant("ayoub","deqqaq",FiliereEnum.GI,"ayoub@mail",null,"Test","None"),
                                        new Etudiant("rajad","majid",FiliereEnum.GI,"majid@mail",null,"tiesto","None"),
                                        new Etudiant("jacob","deqqaq",FiliereEnum.GI,"ayoub@mail",null,"Testo","None"),
                                        new Etudiant("jamal","deqqaq",FiliereEnum.GI,"ayoub@mail",null,"Testaa","None")
                                ));;
    
    
    private static ArrayList<Etudiant> etudiantList;
    
    public RandomStuff()
    {
        
        
        
    }
    
    public static ArrayList<Etudiant> getEtudiantList()
    {
        return etudiantList;
    }
    
    public static void setEtudiantList(ArrayList<Etudiant> etudiantList)
    {
        RandomStuff.etudiantList = etudiantList;
    }
    
    public static boolean isListEmpty()
    {
        return etudiantList.isEmpty();
    }
    
    public String displayBirthDay(Date t)
    {
        Date today;
        String output;
        SimpleDateFormat formatter;
        
        formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        output = formatter.format(t);
        
        return output;
    }
    
}
