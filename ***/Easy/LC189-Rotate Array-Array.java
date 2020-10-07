//Follow up:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//Could you do it in-place with O(1) extra space?

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

//Solution 1 - 20 % beat
class Solution {
    public void rotate(int[] nums, int k) {
        while(k > 0)
        {
            int temp = nums[nums.length-1];
            for(int i = nums.length-1; i > 0; i--)
            {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }
}
//Solution 2 - 99% beat
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return;
        k = k % nums.length;
        //reverse all first is easier to count k
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        
    }
    void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
