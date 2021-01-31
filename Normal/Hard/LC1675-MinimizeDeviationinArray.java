package Normal.Hard;
import java.util.*;
class Solution {

     // T O(Klog(N))
     public int minimumDeviationPQ(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        int min = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i : nums)
        {
            //even
            if(i % 2 == 0)
            {
                pq.add(i);
                min = Math.min(i, min);
            }  
            else
            {
                pq.add(i*2);
                min = Math.min(i*2, min);
            }
        }
        
        while(!pq.isEmpty())
        {
            int currentMax = pq.poll();
            //[3,5] = [6,5]
            diff = Math.min(diff, Math.abs(currentMax - min));
            if(currentMax % 2 != 0)
            {
                return diff ;
            }     
            else
            {
                currentMax /= 2;
                min = Math.min(currentMax, min);
                pq.add(currentMax);
            }
        }
        return diff;
  
    }

    public int minimumDeviationTreeSet(int[] nums) {
        
        TreeSet<Integer> ts=new TreeSet<>();
        
        for(int i:nums){
            if(i%2==1) i*=2;
            ts.add(i);
        }
        
        int diff=Integer.MAX_VALUE;
        
        while(true){
            int max=ts.last();
            int min=ts.first();
            
            diff=Math.min(diff,max-min);
            if(max%2==0){
                ts.remove(max);
                ts.add(max/2);
            }
            else{
                break;
            }
        }
        
        return diff;
    }
}
public class LC1675-MinimizeDeviationinArray {
    class Solution {
        public int minimumDeviation(int[] nums) {
            
            TreeSet<Integer> ts=new TreeSet<>();
            
            for(int i:nums){
                if(i%2==1) i*=2;
                ts.add(i);
            }
            
            int diff=Integer.MAX_VALUE;
            
            while(true){
                int max=ts.last();
                int min=ts.first();
                
                diff=Math.min(diff,max-min);
                if(max%2==0){
                    ts.remove(max);
                    ts.add(max/2);
                }
                else{
                    break;
                }
            }
            
            return diff;
        }
    }
}
