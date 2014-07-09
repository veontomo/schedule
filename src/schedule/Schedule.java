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
import java.math.BigInteger;


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
    
    
    private BigInteger _weightedSum;
    
    public Schedule()
    {
        this._queue = new ArrayList();
        this._completionTime = new ArrayList();
        this._weightedSum = new BigInteger(String.valueOf(0));
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
        this._completionTime = new ArrayList();
        int i, 
            len = this.size(), 
            counter = 0
            ;
        BigInteger w = new BigInteger(String.valueOf(0)), wCopy, tmp, 
                zero = new BigInteger(String.valueOf(0));
        Job j;
        for (i = 0; i < len; i++){
            j = this.getJob(i);
            counter += j.length();
//            System.out.println("current completion time: "  + counter);
            this._completionTime.add(counter);
            
            wCopy = w;
            tmp = new BigInteger(String.valueOf(counter * j.weight()));
            w = w.add(tmp);
            if (w.compareTo(zero) == -1){
                throw new IllegalArgumentException("" + wCopy + " +  " + tmp + " = " + w );
            }
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
        String fileName = "c:\\Users\\Andrea\\Documents\\courses\\algo2\\schedule\\jobs_test1.txt";
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
        
        System.out.println("Non-optimal schedule... " + df.format(new Date()));
        sched.schedule(comp);
        System.out.println("Finished non-optimal scheduling... " + df.format(new Date()));
        
        System.out.println("Optimal schedule... " + df.format(new Date()));
        sched.schedule(compFract);
        System.out.println("Finished sorting schedule... " + df.format(new Date()));
//        int i;
//        for (i = 0; i < sched.size()/100; i++){
//            System.out.println("job  " + i + ": " + sched.getJob(i).show());
//        }
//        System.out.println("Ordering graph " + df.format(new Date()));
//        System.out.println("Fragmetizing is over " + df.format(new Date()));
//        System.out.println(g.show());
//        System.out.println(g.getLeaderInfo());
//        System.out.println(g.show());

//        System.out.println(g.showAnswer());
    }
    
}
