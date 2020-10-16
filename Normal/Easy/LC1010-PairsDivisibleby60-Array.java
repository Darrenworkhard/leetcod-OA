//Solution 1 - 99%
class Solution {
    int count = 0;
    
    public int numPairsDivisibleBy60(int[] time) {
        if(time.length == 1) return 0;
        int[] array = new int[501];
        for(int i = 0; i < time.length; i++)
        {
            array[time[i]] += 1;
        }
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != 0)
            {
                int remain = 60 - (i % 60);
                while(remain <= 500)
                {
                    if(remain > i && array[remain] != 0)
                    {
                        count += array[remain] * array[i];
                    }
                    
                    remain += 60;
                }
            }
        }
        int num = 30;
        while(num <= 500)
        {
            int c = array[num];
            if(c > 1)
            {
                count += c * (c-1) / 2;
            }
            num += 30;
        }
        return count;
    }
}
//Solution 2 - 83%
class Solution {
     public int numPairsDivisibleBy60(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }

}
