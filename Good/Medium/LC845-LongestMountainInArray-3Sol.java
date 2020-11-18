//DP
class Solution {
    public int longestMountain(int[] A) {
        int N = A.length, res = 0;
        int[] up = new int[N], down = new int[N];
        for (int i = N - 2; i >= 0; --i) if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
        for (int i = 0; i < N; ++i) {
            if (i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }
}
//Two Pointer
class Solution {
    public int longestMountain(int[] A) {
        int base = 0;
        int len = A.length;
        int ans = 0;
        while(base < len-1)
        {
            int end = base;
            if(end < len-1 && A[end] < A[end+1])
            {
                //Find peak;
                while(end < len -1 && A[end] < A[end+1])
                    end++;
                //Find boundry
                while(end < len -1 && A[end] > A[end+1])
                    end++;
                
                ans = Math.max(end-base+1, ans);
            }
            base = Math.max(end, base+1);
        }
        return ans;
    }
}
//Brute force
class Solution {
    public int longestMountain(int[] A) {
        int count = 0;
        int max = 0;
        for(int i = 1; i < A.length-1; i++)
        {  
            if(A[i] > A[i-1] && A[i] > A[i+1])
            {
                int up = 0;
                for(int u = i; u > 0; u--)
                {
                    if(A[u] > A[u-1])
                        up++;
                    if(A[u] < A[u-1])
                        break;
                }
                int down = 0;
                for(int d = i; d < A.length-1; d++)
                {
                    if(A[d] > A[d+1])
                        down++;
                    if(A[d] < A[d+1])
                        break;
                }
                if(down + up + 1 >= 3)
                    max = Math.max(down+up+1, max);
            }
        }
        return max;
    }
}