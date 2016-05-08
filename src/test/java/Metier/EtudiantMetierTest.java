/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entities.EtudiantEntity;
import Enums.Filiere;
import java.util.Date;
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
public class EtudiantMetierTest
{
    
    public EtudiantMetierTest()
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
     * Test of getFirstName method, of class EtudiantMetier.
     */
    @Test
    public void testGetFirstName()
    {
        System.out.println("getFirstName");
        EtudiantMetier instance = new EtudiantMetier();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class EtudiantMetier.
     */
    @Test
    public void testGetLastName()
    {
        System.out.println("getLastName");
        EtudiantMetier instance = new EtudiantMetier();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class EtudiantMetier.
     */
    @Test
    public void testGetEmail()
    {
        System.out.println("getEmail");
        EtudiantMetier instance = new EtudiantMetier();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class EtudiantMetier.
     */
    @Test
    public void testGetPassword()
    {
        System.out.println("getPassword");
        EtudiantMetier instance = new EtudiantMetier();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFiliere method, of class EtudiantMetier.
     */
    @Test
    public void testGetFiliere()
    {
        System.out.println("getFiliere");
        EtudiantMetier instance = new EtudiantMetier();
        Filiere expResult = null;
        Filiere result = instance.getFiliere();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class EtudiantMetier.
     */
    @Test
    public void testGetDateOfBirth()
    {
        System.out.println("getDateOfBirth");
        EtudiantMetier instance = new EtudiantMetier();
        Date expResult = null;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrlAvatar method, of class EtudiantMetier.
     */
    @Test
    public void testGetUrlAvatar()
    {
        System.out.println("getUrlAvatar");
        EtudiantMetier instance = new EtudiantMetier();
        String expResult = "";
        String result = instance.getUrlAvatar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class EtudiantMetier.
     */
    @Test
    public void testSetFirstName()
    {
        System.out.println("setFirstName");
        String firstName = "";
        EtudiantMetier instance = new EtudiantMetier();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class EtudiantMetier.
     */
    @Test
    public void testSetLastName()
    {
        System.out.println("setLastName");
        String lastame = "";
        EtudiantMetier instance = new EtudiantMetier();
        instance.setLastName(lastame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class EtudiantMetier.
     */
    @Test
    public void testSetEmail()
    {
        System.out.println("setEmail");
        String email = "";
        EtudiantMetier instance = new EtudiantMetier();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class EtudiantMetier.
     */
    @Test
    public void testSetPassword()
    {
        System.out.println("setPassword");
        String password = "";
        EtudiantMetier instance = new EtudiantMetier();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFiliere method, of class EtudiantMetier.
     */
    @Test
    public void testSetFiliere()
    {
        System.out.println("setFiliere");
        Filiere filiere = null;
        EtudiantMetier instance = new EtudiantMetier();
        instance.setFiliere(filiere);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfBirth method, of class EtudiantMetier.
     */
    @Test
    public void testSetDateOfBirth()
    {
        System.out.println("setDateOfBirth");
        Date dateOfBirth = null;
        EtudiantMetier instance = new EtudiantMetier();
        instance.setDateOfBirth(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrlAvatar method, of class EtudiantMetier.
     */
    @Test
    public void testSetUrlAvatar()
    {
        System.out.println("setUrlAvatar");
        String urlAvatar = "";
        EtudiantMetier instance = new EtudiantMetier();
        instance.setUrlAvatar(urlAvatar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class EtudiantMetier.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        EtudiantMetier instance = new EtudiantMetier();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class EtudiantMetier.
     */
    @Test
    public void testHashCode()
    {
        System.out.println("hashCode");
        EtudiantMetier instance = new EtudiantMetier();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class EtudiantMetier.
     */
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Object obj = null;
        EtudiantMetier instance = new EtudiantMetier();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toEtudiantEntity method, of class EtudiantMetier.
     */
    @Test
    public void testToEtudiantEntity()
    {
        System.out.println("toEtudiantEntity");
        EtudiantMetier instance = new EtudiantMetier();
        EtudiantEntity expResult = null;
        EtudiantEntity result = instance.toEtudiantEntity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Register method, of class EtudiantMetier.
     */
    @Test
    public void testRegister()
    {
        System.out.println("Register");
        EtudiantMetier instance = new EtudiantMetier();
        instance.Register();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Login method, of class EtudiantMetier.
     */
    @Test
    public void testLogin()
    {
        System.out.println("Login");
        EtudiantMetier instance = new EtudiantMetier();
        instance.Login();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
