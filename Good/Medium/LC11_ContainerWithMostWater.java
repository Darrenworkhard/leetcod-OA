package Good.Medium;

public class LC11_ContainerWithMostWater {
    //two pointer
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while(l < r)
        {
            int minlen = Math.min(height[l], height[r]);
            max = Math.max((r - l)* minlen, max);
            if(height[l] <= height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}

