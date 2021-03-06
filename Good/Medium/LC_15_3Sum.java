package Good.Medium;
import java.util.*;

public class LC_15_3Sum {
    //Two pointer and solve LC_16 3sum closet
    public List<List<Integer>> threeSum_S1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while(l < r)
            {
                if(nums[l] + nums[r] + nums[i] == 0)
                {
                    ret.add(List.of(nums[i], nums[l], nums[r]));
                    while(l+1 < nums.length && nums[l] == nums[l+1])
                    {
                        l++;
                    }
                    while(r-1 >= 0 && nums[r] == nums[r-1])
                    {
                        r--;
                    }
                    r--;
                    l++;
                }
                else if(nums[l] + nums[r] + nums[i] < 0)
                    l++;
                else if(nums[l] + nums[r] + nums[i] > 0)
                    r--;
            }
        }
        return ret;
    }
    
    //No sort for original structure
    //N(O^2)
    public List<List<Integer>> threeSum_S2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<List<Integer>> temp = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            HashSet<Integer> set = new HashSet<>();
            int target = 0 - nums[i];
            for(int j = i+1; j < nums.length; j++)
            {
                int remain = target - nums[j];
                if(set.contains(remain))
                {
                    List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], remain));
                    Collections.sort(list);
                    temp.add(list);
                }
                set.add(nums[j]);
            }
        }
        for(List<Integer> arr : temp)
        {
           ret.add(arr);
        }
        return ret;
       
    }
}
