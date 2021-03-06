package Normal.Easy;

public class LC645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        if(nums.length == 0) return ans;
        int[] array = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            array[nums[i]-1] += 1;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(array[i] == 0)
                ans[1] = i+1;
            else if(array[i] == 2)
                ans[0] = i+1;
            
        }         
         
        return ans[0] == 0 ? new int[0] : ans;
    }
}
