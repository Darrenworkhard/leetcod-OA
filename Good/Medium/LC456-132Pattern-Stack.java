//Solution 1 O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int min = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--)
        {
            if(nums[i] < min)
            {
                return true;
            }
            while(!s.isEmpty() && nums[i] > s.peek())
            {
                min = s.pop();
            }
            s.add(nums[i]);
        }
        
        return false;
    }
}
//Solution 1 O(n^2) better brute force
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int min = nums[0];
        for(int i = 1; i < nums.length-1; i++)
        {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
            {
                for(int j = i; j < nums.length; j++)
                {
                    if(nums[j] < nums[i] && nums[j] > min)
                        return true;
                }
                min = nums[i];
            }
            else
            {
                min = Math.min(min, nums[i]);
            }
        }
        return false;
    }
}