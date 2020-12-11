//Same speed but clean code
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++)
        {
            int lo = i == 0 ? lower : nums[i-1]+1;
            int hi = i == nums.length ? upper : nums[i]-1;
            if(hi - lo >= 0)
            {
                ret.add(GetString(lo, hi));
            }
        }

        return ret;
    }

    String GetString(int lower, int upper)
    {
        if(lower == upper)
        {
            return String.valueOf(lower);
        }
        else
        {
            return lower + "->" + upper;
        }
    }
}

//Original I write
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        if(nums.length == 0)
        {
            ret.add(GetString(lower, upper));
            return ret;
        }
        int curIdx = 0;
        int lo = lower;
        if(lower < nums[0])
            ret.add(GetString(lower, nums[0]-1));
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] - nums[i-1] > 1)
            {
                ret.add(GetString(nums[i-1]+1, nums[i]-1));
            }
        }
        
        if(upper > nums[nums.length-1])
            ret.add(GetString(nums[nums.length-1]+1, upper));
        
        return ret;
    }
    String GetString(int lower, int upper)
    {
        if(lower == upper)
        {
            return String.valueOf(lower);
        }
        else
        {
            return lower + "->" + upper;
        }
    }
}