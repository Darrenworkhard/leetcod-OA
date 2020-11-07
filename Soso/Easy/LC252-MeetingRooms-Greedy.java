class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) return true;
        Arrays.sort(intervals, (x,y) -> x[0] < y[0] ? -1 : 1);
        int cur = intervals[0][1];
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] < cur)
                return false;
            else
                cur = Math.max(cur,intervals[i][1]);
        }
        return true;
    }
}