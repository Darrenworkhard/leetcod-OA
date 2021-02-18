package Normal.Medium;

public class LC1578_MinimumDeletionCostRepeating {
    public int minCost(String s, int[] cost) {
        char[] cA = s.toCharArray();
        int costans = 0;
        for(int i = 1; i < cA.length; i++)
        {
            int sum = cost[i-1];
            int max = cost[i-1];
            boolean repeat = false;
            while(i < cA.length && cA[i] == cA[i-1])
            {
                repeat = true;
                sum += cost[i];
                max = Math.max(max, cost[i]);
                i++;
            }
            if(repeat)
                costans += sum - max;
        }
        return costans;
    }
}
