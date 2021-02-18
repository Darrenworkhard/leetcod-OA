package Good.Hard;

import java.util.*;

//DP O(n)
class LC42_TrappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int[] dpleft = new int[height.length];
        int[] dpright = new int[height.length];
        dpleft[0] = height[0];
        for(int i = 1; i < height.length; i++)
        {
            dpleft[i] = Math.max(dpleft[i-1], height[i]);
        }
        dpright[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--)
        {
            dpright[i] = Math.max(dpright[i+1], height[i]);
        }
        int ans = 0;
        for(int i = 1; i < height.length; i++)
        {
            ans += Math.min(dpleft[i], dpright[i]) - height[i];
        }
        return ans;
    }

    //Stack
    public int trap_S2(int[] height) {
        int ans = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < height.length; i++)
        {
            //use while not if ex : 1,0,0,2
            while(!dq.isEmpty() && height[i] > height[dq.peekFirst()])
            {
                int gap = dq.pollFirst();
                if(dq.isEmpty())
                    continue;
                int distance = i - dq.peekFirst() - 1;
                int minContainer = Math.min(height[i], height[dq.peekFirst()]) - height[gap];
                ans += minContainer * distance;
            }
            dq.addFirst(i);
        }
        
        return ans;
    }

    //Brout force O(n^2)
    public int trap_S3(int[] height) {
        int ans = 0;
        for(int i = 0; i < height.length; i++)
        {
            int l = 0, r = 0;
            for(int j = i-1; j >= 0; j--)
            {
                l = Math.max(l, height[j]);
            }
            for(int j = i+1; j < height.length; j++)
            {
                r = Math.max(r, height[j]);
            }
            int minTrap = Math.min(r, l);
            if(height[i] < minTrap)
            {
                ans += minTrap - height[i];
            }
        }
        return ans;
    }
}
