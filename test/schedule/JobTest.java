/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schedule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class JobTest {
    
    public JobTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of weight method, of class Job.
     */
    @Test
    public void testWeight() {
        System.out.println("Gets job weight");
        Job j = new Job(23, 10);
        assertEquals(j.weight(), 23);
    }

    /**
     * Test of length method, of class Job.
     */
    @Test
    public void testLength() {
        System.out.println("Gets job length");
        Job j = new Job(2, 32);
        assertEquals(j.length(), 32);
    }

    /**
     * Test of character method, of class Job.
     */
    @Test
    public void testCharacterPos() {
        System.out.println("Gets job character if it is positive");
        Job j = new Job(5, 2);
        assertEquals(j.character(), 3);
    }
    
    /**
     * Test of character method, of class Job.
     */
    @Test
    public void testCharacterZero() {
        System.out.println("Gets job character if it is zero");
        Job j = new Job(6, 6);
        assertEquals(j.character(), 0);
    }
    
    /**
     * Test of character method, of class Job.
     */
    @Test
    public void testCharacterNeg() {
        System.out.println("Gets job character if it is negative");
        Job j = new Job(6, 20);
        assertEquals(j.character(), -14);
    }

    /**
     * Test of order method, of class Job.
     */
    @Test
    public void testCompareToNeg() {
        System.out.println("Gets -1 if target job has higher character");
        Job j1 = new Job(5, 2);
        Job j2 = new Job(6, 5);
        assertEquals(j1.compareTo(j2), -1);
    }
    
    /**
     * Test of order method, of class Job.
     */
    @Test
    public void testCompareToPos() {
        System.out.println("Gets +1 if target job has lower character");
        Job j1 = new Job(6, 6);
        Job j2 = new Job(4, 1);
        assertEquals(j1.compareTo(j2), 1);
    }

    
    /**
     * Test of order method, of class Job.
     */
    @Test
    public void testCompareToNeg2() {
        System.out.println("Gets -1 if jobs have equal characters but target weight is higher");
        Job j1 = new Job(8, 5);
        Job j2 = new Job(4, 1);
        assertEquals(j1.compareTo(j2), -1);
    }

    /**
     * Test of order method, of class Job.
     */
    @Test
    public void testCompareToPos2() {
        System.out.println("Gets +1 if jobs have equal characters but target weight is lower");
        Job j1 = new Job(6, 2);
        Job j2 = new Job(10, 6);
        assertEquals(j1.compareTo(j2), 1);
    }

    
    
}
