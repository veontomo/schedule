/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package schedule;

/**
 *
 * @author Andrea
 */
public class Job implements Comparable<Job>{

    /**
     * job weight 
     */
    private int weight;
    
    /**
     * job length
     */
    private int length;
    
    /**
     * Job weight getter
     * 
     * @return int
     */
    public int weight()
    {
        return this.weight;
    }
    
    /**
     * Job length getter
     *
     * @return int
     */
    public int length() {
        return this.length;
    }
    
    public Job(int w, int l)
    {
        this.weight = w;
        this.length = l;
    }
    
    public int character()
    {
        return this.weight - this.length;
    }
    
    public int compareTo(Job j){
        if (this.character() > j.character()){
            return -1;
        }
        if (this.character() < j.character()) {
            return 1;
        }
        if (this.weight() > j.weight()){
            return -1;
        }
        return 1;
    }
    
    public static void main(String[] args)
    {
    }
}
