package Good.Medium;

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //from back find the first decending index
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0)
        {
            int j = nums.length-1;
            while(nums[j] <= nums[i]) j--;          
            swap(nums, i, j);
        }
        reverse(i+1, nums.length-1, nums); 
    }
    void swap(int nums[], int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void reverse(int k, int j, int[] nums)
    {
        while(k < j)
        {
            swap(nums, k, j);
            k++;
            j--;
        }
    }
}