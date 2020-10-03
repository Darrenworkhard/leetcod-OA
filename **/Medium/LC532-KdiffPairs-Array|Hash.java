class Solution {
//Aarray Solution
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int slow = 0;
        int fast = 1;
        int ans = 0;
        while(fast < nums.length)
        {
            if(nums[fast] - nums[slow] == k)
            {
                ans++;
                fast++;
                //Need Unique number
                while(fast < nums.length && nums[fast] == nums[fast-1])
                       fast++;
            }
            else if(nums[fast] - nums[slow] < k)
            {
                fast++;
            }
            else
            {
                slow++;
            }
            if(slow == fast)
                fast++;
        }
        return ans;
    }
}
//HashMap Solution
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for(int key : map.keySet())
        {
            if(k == 0)
            {
                if(map.get(key) > 1)
                    ans++;
            }    
            else 
            {
                //Like two some
                int remain = k + key;
                if(map.containsKey(remain))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
