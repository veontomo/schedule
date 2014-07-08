/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schedule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


/**
 *
 * @author Andrea
 */
public class Schedule {
    
    /**
     * Hash containing jobs
     */
    private ArrayList<Job> _queue;
    
    /**
     * Completion time (available after sorting)
     */
    private ArrayList<Integer> _completionTime;
    
    
    private int _weightedSum;
    
    public Schedule()
    {
        this._queue = new ArrayList();
        this._completionTime = new ArrayList();
        this._weightedSum = 0;
    }
    /**
     * Number of jobs in the schedule
     * @return 
     */
    public int size()
    {
        return this._queue.size();
    }
    
    /**
     * Adds jobs
     * @param j 
     */
    public void addJob(Job j)
    {
//        System.out.println("adding job");
        if (this._queue.add(j)){
//            System.out.println("job is added");
        } else {
            System.out.println("job is NOT added");
        };
    }
    
//    class Comp implements Comparator<Job> {
//
//        public int compare(Job j1, Job j2) {
//            return j1.compareTo(j2);
//        }
//    }
//    Comp comp = new Comp();

    
    private void sort(Comparator<Job> comp)
    {
       this._queue.sort(comp);
    }
    
    public void schedule(Comparator<Job> comp)
    {
        this.sort(comp);
        int i, 
            len = this.size(), 
            counter = 0,
            w = 0;
        Job j;
        for (i = 0; i < len; i++){
            j = this.getJob(i);
            counter += j.length();
//            System.out.println("current completion time: "  + counter);
            this._completionTime.add(counter);
            w += counter * j.weight();
        }
        this._weightedSum = w;
        System.out.println("total completion time: "  + counter + ", weighted sum " + w);
                
    
    }
        
    
    /**
     * Gets job from job card number i
     *
     * @param i
     * @return
     */
    public Job getJob(int i) {
        return _queue.get(i);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateFormat df;
        df = new SimpleDateFormat("HH:mm:ss");
        System.out.println("loading graph" + df.format(new Date()));
        BufferedReader br = null;
        String fileName = "f:\\programmazione\\courses\\algo2\\homework1\\jobs.txt";
        Schedule sched = new Schedule();
        try {
            Integer counter = 0;
            Integer weight, length;
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileName));
            int total = Integer.parseInt(br.readLine());
            String[] data;
            
            while ((sCurrentLine = br.readLine()) != null) {
                counter++;
                data = sCurrentLine.trim().split(" ");
                if (data.length != 2) {
                    throw new IllegalArgumentException("Line must contain exactly two numbers!");
                }
                weight = Integer.parseInt(data[0]);
                length = Integer.parseInt(data[1]);
                Job j = new Job(weight, length);
                sched.addJob(j);
                counter++;
                
//                if (counter % 10000 == 0){
//                    System.out.println("" + counter + ": " + g.maxNodeNum() );
//                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Schedule contains " + sched.size() + " jobs. " + df.format(new Date()));
        System.out.println("Sorting schedule... " + df.format(new Date()));
        
        class Comp implements Comparator<Job> {

            public int compare(Job j1, Job j2) {
                return j1.compareTo(j2);
            }
        }
        Comp comp = new Comp();
        
        class CompFract implements Comparator<Job> {

            public int compare(Job j1, Job j2) {
                return j1.compareToFraction(j2);
            }
        }
        CompFract compFract = new CompFract();
        
        
        sched.schedule(compFract);
        System.out.println("Finished sorting schedule... " + df.format(new Date()));
        int i;
        for (i = 0; i < 10000; i++){
//            System.out.println("job  " + i + ": " + sched.getJob(i).show());
        }
//        System.out.println("Ordering graph " + df.format(new Date()));
//        System.out.println("Fragmetizing is over " + df.format(new Date()));
//        System.out.println(g.show());
//        System.out.println(g.getLeaderInfo());
//        System.out.println(g.show());

//        System.out.println(g.showAnswer());
    }
    
}
