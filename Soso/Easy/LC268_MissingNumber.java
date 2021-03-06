package Soso.Easy;

public class LC268_MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += i+1;
            sum -= nums[i];
        }
        return sum;
    }
}
