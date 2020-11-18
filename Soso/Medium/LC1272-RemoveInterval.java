//Time complexity : O(N)\mathcal{O}(N)O(N) since it's one pass along the input array.
//Space complexity : O(1)\mathcal{O}(1)O(1) without considering O(N)\mathcal{O}(N)O(N) space for the output list.

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] removed) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] nums : intervals)
        {
            //inside
            if(nums[0] >= removed[0] && nums[1] <= removed[1])
                continue;
            //oitside
            else if(nums[0] < removed[0] && nums[1] > removed[1])
            {
                ans.add(Arrays.asList(new Integer[]{nums[0], removed[0]}));
                ans.add(Arrays.asList(new Integer[]{removed[1], nums[1]}));
            }
            //left
            else if(nums[0] < removed[1] && nums[1] > removed[1])
            {
                ans.add(Arrays.asList(new Integer[]{removed[1], nums[1]}));
            }
            //right
            else if(nums[0] < removed[0] && nums[1] > removed[0])
                ans.add(Arrays.asList(new Integer[]{nums[0], removed[0]}));
            else
                ans.add(Arrays.asList(new Integer[]{nums[0], nums[1]}));
            
        }
        return ans;
    }
}