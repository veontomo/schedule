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
public class ScheduleTest {
    
    public ScheduleTest() {
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
     * Test of addJob method, of class Schedule.
     */
    @Test
    public void testScheduleJobIfEmpty() {
        System.out.println("schedules unique job");
        Job j = new Job(10, 2);
        Schedule sched = new Schedule();
        sched.addJob(j);
        sched.schedule();
        assertEquals(sched.getJob(0), j);
    }

    
    /**
     * Test of addJob method, of class Schedule.
     */
    @Test
    public void testScheduleJob2() {
        System.out.println("schedules two jobs if they are inserted in decreasing order");
        Job j1 = new Job(10, 2); // 10 - 2 = 8
        Job j2 = new Job(2, 1);  // 2 - 1 = 1
        Schedule sched = new Schedule();
        sched.addJob(j1);
        sched.addJob(j2);
        sched.schedule();
        assertEquals(sched.getJob(0), j1);
        assertEquals(sched.getJob(1), j2);
    }

    /**
     * Test of addJob method, of class Schedule.
     */
    @Test
    public void testScheduleJob3() {
        System.out.println("schedules two jobs if they are inserted in increasing order");
        Job j1 = new Job(10, 2); // 10 - 2 = 8
        Job j2 = new Job(2, 1);  // 2 - 1 = 1
        Schedule sched = new Schedule();
        sched.addJob(j2);
        sched.addJob(j1);
        sched.schedule();
        assertEquals(sched.getJob(0), j1);
        assertEquals(sched.getJob(1), j2);
    }
    
    @Test
    public void testScheduleJob4() {
        System.out.println("schedules two jobs if they have equal difference, but"
                + "weights are in decreasing order");
        Job j1 = new Job(10, 8); // 10 - 8 = 2
        Job j2 = new Job(4, 2);  // 4 - 2 = 2
        Schedule sched = new Schedule();
        sched.addJob(j1);
        sched.addJob(j2);
        sched.schedule();
        assertEquals(sched.getJob(0), j1);
        assertEquals(sched.getJob(1), j2);
    }

    @Test
    public void testScheduleJob5() {
        System.out.println("schedules two jobs if they have equal difference, but"
                + "weights are in increasing order");
        Job j1 = new Job(10, 8); // 10 - 8 = 2
        Job j2 = new Job(4, 2);  // 4 - 2 = 2
        Schedule sched = new Schedule();
        sched.addJob(j2);
        sched.addJob(j1);
        sched.schedule();
        assertEquals(sched.getJob(0), j1);
        assertEquals(sched.getJob(1), j2);
    }

    
    @Test
    public void testScheduleJob6() {
        System.out.println("schedules six jobs");
        Job j1 = new Job(10, 8); // 10 - 8 = 2
        Job j2 = new Job(4, 3);  // 4 - 3 = 1
        Job j3 = new Job(1, 3); // 1 - 3 = -2
        Job j4 = new Job(3, 2);  // 3 - 2 = 1
        Job j5 = new Job(3, 1); // 3 - 1 = 2
        Job j6 = new Job(1, 1);  // 1 - 1 = 0
        // j1 j5 j2 j4 j6 j3
        Schedule sched = new Schedule();
        sched.addJob(j2);
        sched.addJob(j1);
        sched.addJob(j3);
        sched.addJob(j4);
        sched.addJob(j5);
        sched.addJob(j6);
        sched.schedule();
        assertEquals(sched.getJob(0), j1);
        assertEquals(sched.getJob(1), j5);
        assertEquals(sched.getJob(2), j2);
        assertEquals(sched.getJob(3), j4);
        assertEquals(sched.getJob(4), j6);
        assertEquals(sched.getJob(5), j3);
    }
    
    
    /**
     * Test of main method, of class Schedule.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Schedule.main(args);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
