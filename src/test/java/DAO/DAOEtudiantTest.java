/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.EtudiantEntity;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ayoub
 */
public class DAOEtudiantTest
{
    
    public DAOEtudiantTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getAllEtudiants method, of class DAOEtudiant.
     */
    @Test
    public void testGetAllEtudiants()
    {
        System.out.println("getAllEtudiants");
        String term = "";
        String value = "";
        DAOEtudiant instance = new DAOEtudiant();
        List<EtudiantEntity> expResult = null;
        List<EtudiantEntity> result = instance.getAllEtudiants(term, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertEtudiant method, of class DAOEtudiant.
     */
    @Test
    public void testInsertEtudiant()
    {
        System.out.println("insertEtudiant");
        EtudiantEntity etudiant = null;
        DAOEtudiant instance = new DAOEtudiant();
        instance.insertEtudiant(etudiant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginEtudiant method, of class DAOEtudiant.
     */
    @Test
    public void testLoginEtudiant()
    {
        System.out.println("loginEtudiant");
        String email = "";
        String password = "";
        DAOEtudiant instance = new DAOEtudiant();
        List<EtudiantEntity> expResult = null;
        List<EtudiantEntity> result = instance.loginEtudiant(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
