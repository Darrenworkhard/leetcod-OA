//LC239
//Time complexity : O(N), since each element is processed exactly twice - it's index added and then removed from the deque. 
//Space complexity : O(N), since O(N - k + 1)is used for an output array and O(k) for a deque. 

import java.util.*;
public class DiskSpace_SlidingWindow {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;
            
            ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
                updateDeque(nums, i, k, deq);
            }
            
            int [] output = new int[n - k + 1];
            output[0] = nums[deq.getFirst()];
            
            for (int i = k; i < n; i++) {
                updateDeque(nums, i, k, deq);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
        
        private void updateDeque(int[] nums, int i, int k, ArrayDeque<Integer> deq) {
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           
                deq.removeLast();
            
            deq.addLast(i);
        }
    }
}
