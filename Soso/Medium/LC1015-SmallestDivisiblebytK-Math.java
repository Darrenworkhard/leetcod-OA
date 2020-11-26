class Solution {
    public int smallestRepunitDivByK(int K) {
        int n = 0;
        if(K % 2 == 0 || K % 5 == 0) return -1;
        //Why only to K?
        //We only run the loop K times at most, not K+1. This is because if it does not stop in the previous K loop
        //it will continue the K+1-th iteration, which must have repeated remainder. Therefore, it is not necessary to check the K+1-th iteration.
        //if K = 3 and 111 can find the answer then after 111111 can't find also.
        for(int i = 1; i <= K; i++)
        {
            //do % instently to avoid overflow, and also if num is so big the divide operation will become n(logn)
            n = (n * 10 + 1) % K;
            if(n == 0)
                return i;
        }
        return -1;
    }
}