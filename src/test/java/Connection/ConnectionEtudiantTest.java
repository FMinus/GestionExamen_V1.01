/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Metier.EtudiantMetier;
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
public class ConnectionEtudiantTest
{
    
    public ConnectionEtudiantTest()
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
     * Test of registerEtudiant method, of class ConnectionEtudiant.
     */
    @Test
    public void testRegisterEtudiant()
    {
        System.out.println("registerEtudiant");
        EtudiantMetier etudiant = null;
        ConnectionEtudiant instance = new ConnectionEtudiant();
        instance.registerEtudiant(etudiant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginEtudiant method, of class ConnectionEtudiant.
     */
    @Test
    public void testLoginEtudiant()
    {
        System.out.println("loginEtudiant");
        String email = "";
        String password = "";
        ConnectionEtudiant instance = new ConnectionEtudiant();
        boolean expResult = false;
        boolean result = instance.loginEtudiant(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
