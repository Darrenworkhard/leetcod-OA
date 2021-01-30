public class LC1631-PathWithMinimumEffort {
    class Solution {
        //Backtracking TLE O(3^M*N)
        int minEffort = Integer.MAX_VALUE;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int minimumEffortPath(int[][] heights) {
            int xLen = heights[0].length;
            int yLen = heights.length;
            if(xLen == 1 && yLen == 1) return 0;
            boolean[][] visited = new boolean[yLen][xLen];
            visited[0][0] = true;
            dfs(heights, 0, 0, xLen, yLen, Integer.MIN_VALUE, visited);
            
            return minEffort;
        }
        void dfs(int[][] heights, int x, int y, int xLen, int yLen, int curEffort, boolean[][] visited)
        {
            if(x == xLen - 1 && y == yLen - 1)
            {
                minEffort = Math.min(curEffort, minEffort);
                return;
            }
            for(int[] dir : dirs)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newX >= xLen || newY < 0 || newY >= yLen || visited[newY][newX])
                    continue;
    
                int newEffort = Math.max(curEffort, Math.abs(heights[y][x] - heights[newY][newX]));
                visited[newY][newX] = true;
                dfs(heights, newX, newY, xLen, yLen, newEffort, visited);
                visited[newY][newX] = false;
            }
        }
    }
    class Solution {
        //Dijkstra's Algorithm
        //O(m⋅nlog(m⋅n))
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int minimumEffortPath(int[][] heights) {
            //int[] x, y, diff
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
            int xlen = heights[0].length, ylen = heights.length;
            int[][] differenceMatrix = new int[ylen][xlen];
            
            boolean[][] visited = new boolean[ylen][xlen];
            for(int i = 0; i < differenceMatrix.length; i++)
                Arrays.fill(differenceMatrix[i], Integer.MAX_VALUE);
            differenceMatrix[0][0] = 0;
            pq.add(new int[] {0, 0, 0});
            
            while(!pq.isEmpty())
            {
                int[] cur = pq.poll();
                if(cur[0] == xlen-1 && cur[1] == ylen-1)
                    return cur[2];
                visited[cur[1]][cur[0]] = true;
                for(int[] dir : dirs)
                {
                    int newX = dir[0] + cur[0];
                    int newY = dir[1] + cur[1];
                    if(!isValid(newX, newY, xlen, ylen) || visited[newY][newX])
                        continue;
                    int curdiff = Math.abs(heights[newY][newX]-heights[cur[1]][cur[0]]);
                    //ex : 1,10,6 should be 9 not 4
                    int maxdiff = Math.max(curdiff, differenceMatrix[cur[1]][cur[0]]);
                    if(differenceMatrix[newY][newX] > maxdiff)
                    {
                        differenceMatrix[newY][newX] = maxdiff;
                        pq.add(new int[]{newX, newY, maxdiff});
                    }
                }
            }
            return differenceMatrix[ylen-1][xlen-1];
        }
        boolean isValid(int newX, int newY, int xlen, int ylen)
        {
            if(newX < 0 || newX >= xlen || newY < 0 || newY >= ylen)
                return false;
            
            return true;
        }
    }
}
