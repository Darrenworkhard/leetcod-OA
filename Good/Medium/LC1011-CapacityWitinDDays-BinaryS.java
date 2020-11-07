class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0;
        int hi = 0;
        for(int i : weights)
        {
            hi += i;
            lo = Math.max(lo, i);
        }
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            int count = 1;
            for(int i : weights)
            { 
                if(sum + i > mid)
                {
                    count++;
                    sum = 0;
                }
                sum += i;
            }
            if(D < count)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}