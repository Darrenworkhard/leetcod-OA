class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ret = new int[k];
        int lastIndex = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++)
        {
            //point stack.size() + nums.length - i > k (size in window)
            while(!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + nums.length - i > k)
            {
                stack.pop();
            }
            if(stack.size() < k)
                stack.add(nums[i]);
            
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}