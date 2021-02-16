package AlgorithmReview;
import java.util.*;

public class Dijkstras {
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
