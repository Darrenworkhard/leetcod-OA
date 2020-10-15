//Solution 1 75%
//PriorityQueue
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (x,y) -> {
                return x[0] - y[0];
        });
        PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        q.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++)
        {
            int val = q.peek()[1];
            if(intervals[i][0] >= val)
            {
                q.poll();
            }
            q.add(intervals[i]);
        }
        return q.size();
    }
}
//Solution 2 75%
//Dfs
class Solution {
    Set<Integer> used = new HashSet<>();
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (x,y) -> {
                return x[0] - y[0];
        });
        int ans = 0;
        for(int i = 0; i < intervals.length; i++)
        {
            if(!used.contains(i))
            {
                ans++;
                used.add(i);
                dfs(intervals, intervals[i][1], i);
            }
        }
        return ans;
    }
    void dfs(int[][] intervals, int current, int index)
    {
        for(int i = index; i < intervals.length; i++)
        {
            if(!used.contains(i) && intervals[i][0] >= current)
            {
                used.add(i);
                dfs(intervals, intervals[i][1], i);
                return;
            }
        }
    }
}
