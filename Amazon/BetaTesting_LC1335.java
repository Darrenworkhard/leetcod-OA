//T:O(N2D)
//S:O(ND)
public class BetaTesting_LC1335 {
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
                for(int k = j; k >= i; k--)
                {
                    localMax = Math.max(jobDifficulty[k], localMax);
                    dp[i][j] = Math.min(dp[i-1][k-1] + localMax, dp[i][j]);
                }
            }
        }
        return dp[d-1][n-1];
    }
}
