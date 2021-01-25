package Normal.Medium;
import java.util.*;

public class LC1679-MaxNumberOfK {
    //O(N)
    public int maxOperations(int[] nums, int k) {
        if(nums.length == 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for(int num : nums)
        {
            int complement = k - num;
            if(map.getOrDefault(complement, 0) > 0)
            {
                int count = map.get(complement);
                map.put(complement, count-1);
                ret++;
            }
            else
                map.put(num, map.getOrDefault(num, 0)+1);
        }
        return ret;
    }
    //O(NLOGN)
    public int maxOperations2(int[] nums, int k) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int ret = 0;
        while(l < r)
        {
            int sum = nums[l] + nums[r];
            if(sum == k)
            {
                l++;
                r--;
                ret++;
            }
            else if(sum < k)
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return ret;
    }
}
