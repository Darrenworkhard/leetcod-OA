import java.util.*;

public class BinarySearch{

    public static void main(String[] arg)
    {
        BinarySearch search = new BinarySearch();
        search.search();

    }
    void search()
    {

        int regular = regularSearch(new int[]{1,2,3,4,5},6);
        int left = leftSearch(new int[]{1,2,2,4},0);
        int right = right_bound(new int[]{1,2,2,4,4},0);

        System.out.println(regular);
        System.out.println(left);
        System.out.println(right);
    }

    //Regular search
    int regularSearch(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; // 注意
    
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid; 
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    //Lower search
    int leftSearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        if(left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    //upper search
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }

        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;
    }
}