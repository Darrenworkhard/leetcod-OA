//Seperate two part, left and right
//Select sorted part to select condition
//33
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0;
        int r = nums.length-1;
        while(l < r)
        {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            //left part is sorted because the other side is blurry
            if(nums[l] <= nums[mid])
            {
                if(nums[l] <= target && nums[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }
            //right side is sorted
            else
            {
                if(nums[mid] <= target && nums[r] >= target)
                    l = mid;
                else
                    r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
//81
//we get O(N)O(N) worst case (with duplicates) vs O(\log N)O(logN) best case complexity (without duplicates).
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0;
        int r = nums.length-1;
        while(l < r)
        {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return true;
            //left part is sorted because the other side is blurry
            if(nums[l] < nums[mid])
            {
                if(nums[l] <= target && nums[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }
            //right side is sorted
            else if(nums[l] > nums[mid])
            {
                if(nums[r] >= target && nums[mid] <= target)
                    l = mid;
                else
                    r = mid - 1;
            }
            else
                //nums[i] == nums[mid] 
                //shuffle delete i
                //1131
                l++;
        }
        
        return nums[l] == target;
    }
}