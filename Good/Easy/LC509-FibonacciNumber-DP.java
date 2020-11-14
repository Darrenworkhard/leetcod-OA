//Space O(1)
class Solution {
    public int fib(int N) {
        if(N == 0) return 0;
        int pre1 = 0;
        int pre2 = 1;
       
        for(int i = 2; i <= N; i++)
        {
            int fibsum = pre1+pre2;
            pre1 = pre2;
            pre2 = fibsum;
        }
        return pre2;
    }
}
//Space O(n)
class Solution {
    public int fib(int N) {
        if(N == 0) return 0;
        int[] array = new int[N+1];
        array[1] = 1;
        for(int i = 2; i <= N; i++)
        {
            array[i] = array[i-1]+array[i-2];
        }
        return array[N];
    }
}