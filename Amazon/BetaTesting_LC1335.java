<<<<<<< HEAD
//https://www.youtube.com/watch?v=l95VELZWJig&ab_channel=%E4%B8%83%E4%BA%BA%E5%B0%8F%E7%B5%84-%E8%AB%8B%E6%8F%90%E9%80%9F%E8%A7%80%E7%9C%8B%21%21

//T O(N^2K)
//S O(NK)
class Solution {
=======
//T:O(N2D)
//S:O(ND)
public class BetaTesting_LC1335 {
>>>>>>> 7e570a8f2d647da88ce115816e7e1a4f88a526a6
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] dp = new int[d][n];
        dp[0][0] = jobDifficulty[0];
        int max = jobDifficulty[0];
        for(int i = 1; i < n; i++)
        {
            //max = Math.max(dp[0][i-1], jobDifficulty[i]);
            max = Math.max(max, jobDifficulty[i]);
            dp[0][i] = max;
        }
        
        for(int i = 1; i < d; i++)
        {
            for(int j = i; j < n; j++)
            {
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
<<<<<<< HEAD
                //由當前往回推包再一起
                //2851 d = 3;
=======
>>>>>>> 7e570a8f2d647da88ce115816e7e1a4f88a526a6
                for(int k = j; k >= i; k--)
                {
                    localMax = Math.max(jobDifficulty[k], localMax);
                    dp[i][j] = Math.min(dp[i-1][k-1] + localMax, dp[i][j]);
                }
            }
        }
        return dp[d-1][n-1];
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 7e570a8f2d647da88ce115816e7e1a4f88a526a6
