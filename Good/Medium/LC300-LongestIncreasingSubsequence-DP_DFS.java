//Solution 1 70%
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int current = 1;
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                {
                    current = Math.max(dp[j]+1 ,current);
                }          
            }
            ans = Math.max(current, ans);
            dp[i] = current;
        }
        return ans;
    }
}
//Solution 2 5% 
class Solution {
    int max = 0;
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++)
        {
            Stack stack = new Stack<>();
            
            dfs(stack, nums, i);
        }
        return max;
    }
    void dfs(Stack<Integer> stack, int[] nums, int index)
    {  
        stack.add(nums[index]);
        for(int i = index+1; i < nums.length; i++)
        {
            if(stack.peek() >= nums[i])
            {
                Stack<Integer> s = new Stack<Integer>();
                s.addAll(stack);
                while(!s.isEmpty() && s.peek() >= nums[i])
                {
                    s.pop();
                }
                if(!s.isEmpty())
                    dfs(s, nums, i);
            }
            else
                stack.add(nums[i]);
        }
        if(stack.size() > max)
        {
            max = stack.size();
        }
    }
}