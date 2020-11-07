//1283Lower bound binary search
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 0;
        for(int i : nums)
            hi = Math.max(hi, i);
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) /2;
            double sum = 0;
            for(int i : nums)
            {
                //-1 always make sure int >= 1;
                //Faster than above
                sum += (mid + i - 1) / mid;
                //sum += Math.ceil((double)i / mid);
                
            }
            if(threshold < sum)
            {
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return lo;
    }
}

//875
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 0;
        for(int i : piles)
        {
            hi = Math.max(hi, i);
        }
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int spend = 0;
            for(int i : piles)
            {
                spend += (mid + i - 1) / mid;
            }
            if(H < spend)
            {
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return lo;
    }
}