/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Metier.EtudiantMetier;
import DAO.DAOEtudiant;

public class Register
{
    public void registerEtudiant(EtudiantMetier etudiant)
    {
        DAOEtudiant daoEtudiant = new DAOEtudiant("localhost","GestionExamen",27017);
        
        daoEtudiant.insertEtudiant(etudiant.toEtudiantEntity());
    }
    
}
