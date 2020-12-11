//dp
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
//slow
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(time);
        int ret = 0;
        for(int i = 0; i < time.length; i++)
        {      
            int num = time[i];
            int remain = 60 - (time[i] % 60) ;
            while(remain <= num)
            {
                if(map.containsKey(remain))
                {    
                    ret += map.get(remain);
                }
                remain += 60;
            }
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return ret;
    }
}