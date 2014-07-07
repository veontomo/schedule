/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schedule;

import java.util.HashMap;
import java.util.Set;


/**
 *
 * @author Andrea
 */
public class Schedule {
    
    /**
     * An object store job instance inside the schedule
     */
    public class JobCard
    {
        /**
         * job to schedule
         */
        private Job _job;
        
        /**
         * time of job completion
         */
        private int _completionTime;
        
        /**
         * job getter
         * @return Job
         */
        public Job job()
        {
            return this._job;
        }
        
        /**
         * Completion tme getter
         * @return int
         */
        public int getCompletionTime()
        {
            return this._completionTime;
        }
        
        public void setCompletionTime(int t)
        {
            this._completionTime = t;
        }
        
        
    }
    
    private JobCard[] _schedule;
    
    /**
     * Schedules the job
     * @param j 
     */
    public void scheduleJob(Job j)
    {
        /// !!! stub
    }
    
    /**
     * Returns position of the job among the schedule in case it is to be scheduled.
     * @param j
     * @return 
     */
    public int jobPos(Job j)
    {
        /// !!! stub
        return 0;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
