/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int min = 0;
        int max = target - reader.get(0);
    
        while(min <= max)
        {
            int mid = min + (max-min) / 2;
            int number = reader.get(mid);
            if(number == target)
                return mid;
            else if(number > target)
                max = mid-1;
            else if(number < target)
                min = mid+1;
        }
        return -1;
    }
}