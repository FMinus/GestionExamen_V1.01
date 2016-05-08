/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import org.bson.types.ObjectId;
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
public class BaseEntityTest
{
    
    public BaseEntityTest()
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
     * Test of getId method, of class BaseEntity.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        BaseEntity instance = new BaseEntityImpl();
        ObjectId expResult = null;
        ObjectId result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class BaseEntity.
     */
    @Test
    public void testSetId()
    {
        System.out.println("setId");
        ObjectId id = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class BaseEntity.
     */
    @Test
    public void testGetVersion()
    {
        System.out.println("getVersion");
        BaseEntity instance = new BaseEntityImpl();
        Long expResult = null;
        Long result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVersion method, of class BaseEntity.
     */
    @Test
    public void testSetVersion()
    {
        System.out.println("setVersion");
        Long version = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setVersion(version);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BaseEntityImpl extends BaseEntity
    {
    }
    
}
