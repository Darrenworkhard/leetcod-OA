class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int i : nums)
        {
            sum += i;
        }
        int rest = sum - x;
        if(rest == 0) return nums.length;
        //Find the longest subarray
        int l = 0;
        int subSum = 0;
        int ret = -1;

        for(int r = 0; r < nums.length; r++)
        {
            subSum += nums[r];
            while(subSum > rest && l < r)
            {
                subSum -= nums[l];
                l++;
            }
            if(subSum == rest)
                ret = Math.max(r-l+1 ,ret);
        }
        return ret == -1 ? ret : nums.length - ret;
    }
}