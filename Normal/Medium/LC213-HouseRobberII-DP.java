class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        //From first to end
        int rob = 0;
        int norob = 0;
        for(int i = 0; i < nums.length-1; i++)
        {
            int temp = rob;
            rob = nums[i] + norob;
            norob = Math.max(temp, norob);
        }
        int max = Math.max(rob, norob);
        //From second to end
        int rob2 = 0;
        int norob2 = 0;
        for(int i = 1; i < nums.length; i++)
        {
            int temp = rob2;
            rob2 = nums[i] + norob2;
            norob2 = Math.max(temp, norob2);
        }
        int max2 = Math.max(rob2, norob2);
        return Math.max(max, max2);
    }
}
