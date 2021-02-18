class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] count = new int[nums.length];
        Arrays.fill(count,1);
        int[] length = new int[nums.length];
        int maxLength = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    if(length[i] <= length[j])
                    {
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }
                    else if(length[j] + 1 == length[i])
                    {
                        //Same number
                        count[i] += count[j];
                    }
                }
            }
            
            if(maxLength < length[i])
            {
                maxLength = length[i];
                ans = count[i];
            }
            else if(maxLength == length[i])
                ans += count[i];
                
        }
        //Simplify to above
        // for(int i = 0; i < length.length; i++)
        // {
        //    maxLength = Math.max(maxLength, length[i]);
        // }
        // for(int i = 0; i < length.length; i++)
        // {
        //     if(length[i] == maxLength)
        //     {
        //         ans += count[i];
        //     }
        // }
        return ans;
    }
}
