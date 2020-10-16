class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        //Double time faster Why ?
        //Arrays.sort(points, (p1, p2) -> p1[1] > Integer.MAX_VALUE - p2[1] ? p1[1] / 10000 - p2[1] / 10000 : p1[1] - p2[1] );
        Arrays.sort(points, (a,b) -> a[1] > b[1] ? 1 : -1);
        int ans = 1;
        int end = points[0][1];
        
        for(int i = 0; i < points.length; i++)
        {
            if(points[i][0] <= end)
                continue;
            else
            {
                end = points[i][1];
                ans++;
            }
        }
        return ans;
    }
}
