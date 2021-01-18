class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] nums = new int[n+2];
        int max = 0;
        nums[0] = 0;
        nums[1] = 1;
        int len = n % 2 == 0 ? n / 2 : (n - 1) / 2;
        for(int i = 1; i <= len; i++)
        {
            nums[2 * i] = nums[i];
            if(2 * i <= n)
                max = Math.max(nums[2 * i], max);
            nums[2 * i + 1] = nums[i] + nums[i+1];
            if(2 * i + 1 <= n)
                max = Math.max(nums[2 * i + 1], max);
            
        }
        return max;
    }
}