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
    private int _weight;
    
    /**
     * job length
     */
    private int _length;
    
    /**
     * Job weight getter
     * 
     * @return int
     */
    public int weight()
    {
        return this._weight;
    }
    
    /**
     * Job length getter
     *
     * @return int
     */
    public int length() {
        return this._length;
    }
    
    public Job(int w, int l)
    {
        this._weight = w;
        this._length = l;
    }
    
    public int character()
    {
        return this._weight - this._length;
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
    
    public double frac()
    {
       return (double) this.weight()/this.length(); 
    }
    
    public int compareToFraction(Job j){
        double fr1 = this.frac();
        double fr2 = j.frac();
        if (fr1 > fr2){
            return -1;
        }
        if (fr1 < fr2) {
            return 1;
        }
        return 0;
    }
    
    public String show()
    {
        return "weight: " + this.weight() + ", length: " + this.length() + ", character: " + this.character() + ", fraction: " + this.frac();
    }
    public static void main(String[] args)
    {
    }
}
