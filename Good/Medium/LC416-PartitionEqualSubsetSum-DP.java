class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i : nums)
        {
            sum += i;
        }
        if(sum % 2 != 0)
            return false;
        boolean[][] used = new boolean[nums.length][sum/2+1];
        return dfs(nums, 0, sum/2, used);

    }
    boolean dfs(int[] nums, int n, int subSum, boolean[][] used)
    {
        if(subSum == 0)
        {
            used[n][subSum] = true;
            return true;
        }
            
        if(n == nums.length || subSum < 0)
        {
            return false;
        }
        
        if(used[n][subSum])
            return true;
        
        used[n][subSum] = dfs(nums, n+1, subSum, used) || dfs(nums, n+1, subSum - nums[n], used);
        return used[n][subSum];
    }
}