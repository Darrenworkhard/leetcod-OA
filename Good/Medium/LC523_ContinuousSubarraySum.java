package Good.Medium;
import java.util.*;

public class LC523_ContinuousSubarraySum {
    //O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        // deal with case [0,0] 0, nums = [1, 5] k = 6, at i=1 map need zero
        map.put(0, -1);
        for(int i =0;i< nums.length;i++){
            sum+= nums[i];
            if(k != 0)
                sum = sum % k;
            if(map.containsKey(sum)){
                if ( i - map.get(sum)  >1)
                    return true;
            }else{
                map.put(sum, i);
            }
                
        }
        return false;
    }


    //O(n^2)
    boolean ans = false;
    public boolean checkSubarraySum_TLE(int[] nums, int k) {
        if(nums.length < 2) return false;
        if(k == 0)
        {
            for(int i = 0; i < nums.length-1; i++)
            {
               if(nums[i] == 0 && nums[i+1] == 0)
                   return true;
            }
            return false;
        }

        int sum = 0;
        for(int i : nums)
        {
            sum += i;
        }
        checkSum(nums, k, 0, nums.length-1, sum);
        
        return ans;
    }
    void checkSum(int[] nums, int k, int l, int r, int cursum)
    {
        if(r == l) return;
        if(cursum % k == 0)
        {
            ans = true;
            return;
        }
        if(!ans)
        {
            checkSum(nums, k, l+1, r, cursum-nums[l]);
            checkSum(nums, k, l, r-1, cursum-nums[r]);          
        }  
    }
}
