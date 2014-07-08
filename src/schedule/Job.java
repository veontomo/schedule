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
    
    public int compareToFraction(Job j){
        float fr1 = (float) (this.weight()/this.length());
        float fr2 = (float) (j.weight() / j.length());
        return fr1 > fr2 ? 1 : -1; 
    }
    
    public String show()
    {
        return "weight: " + this.weight() + ", length: " + this.length();
    }
    public static void main(String[] args)
    {
    }
}
