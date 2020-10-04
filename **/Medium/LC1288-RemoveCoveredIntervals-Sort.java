class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> x[0] == y[0] ? x[1] > y[1] ? -1 : 1 : x[0] - y[0]);
        int ans = 1;
        int end = intervals[0][1];
        for(int num = 1; num < intervals.length; num++)
        {
            if(intervals[num][1] > end)
            {
                end = intervals[num][1];
                ans++;
            }
        }
        return ans;
    }
}
