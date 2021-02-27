package Good.Medium;
import java.util.*;

public class LC_581_ShortestUnsortedSubarray {
    //O(n), O(n)
    public int findUnsortedSubarray_S1(int[] nums) {
        Deque<Integer> dq = new LinkedList<>();
        int l = nums.length-1, r = 0;
        for(int i = 0; i < nums.length; i++)
        {
            while(!dq.isEmpty() && nums[dq.peekFirst()] > nums[i])
            {
                l = Math.min(dq.pollFirst(), l);
            }
            dq.addFirst(i);
        }
        dq.clear();
        for(int i = nums.length - 1; i >= 0; i--) 
        {
            while(!dq.isEmpty() && nums[dq.peekFirst()] < nums[i])
            {
                r = Math.max(dq.pollFirst(), r);
            }
            dq.addFirst(i);
        }
        return l >= r ? 0 : r - l + 1;
    }

    //O(nlogn) O(n)
    public int findUnsortedSubarray_S2(int[] nums) {
        int[] cNums = nums.clone();
        Arrays.sort(cNums);
        int l = nums.length , r = 0; 
        for(int i = 0; i < nums.length; i++)
        {
            l = i;
            if(nums[i] != cNums[i])
                break;       
        }
        for(int i = nums.length-1; i >= 0; i--)
        {
            r = i;
            if(nums[i] != cNums[i])
                break;
        }
        //System.out.println(l+"/"+r);
        if(r == 0 && l == nums.length-1)
            return 0;
        return r - l + 1;
    }
}
