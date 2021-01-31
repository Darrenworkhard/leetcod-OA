//T(M^2N^2)
//S(MN)

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.size() == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[2] - y[2]);
        //start
        pq.add(new int[] {0,0,0});
        int col = forest.get(0).size();
        int row = forest.size();
        for(int i = 0; i < col; i++)
        {
            for(int j = 0; j < row; j++)
            {
                if(forest.get(j).get(i) != 0)
                    pq.add(new int[]{j, i, forest.get(j).get(i)});
            }
        }
        
        int totalStep = 0;
        while(pq.size() > 1)
        {
            int[] cur = pq.poll();
            //System.out.println(cur[0] + " "+ cur[1] + " " + cur[2] );
            int[] next = pq.peek();
            //System.out.println(cur + " "+ next);
            int step = getStep(forest, cur, next, col, row);
            //System.out.println(step);
            if(step == -1)
                return -1;
            totalStep += step;
        }
        return totalStep;
    }
    int getStep(List<List<Integer>> forest, int[] sor, int[] tar, int col, int row)
    {
        if(sor[0] == tar[0] && sor[1] == tar[1]) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sor[0], sor[1]});
        int step = 1;
        boolean[][] visited = new boolean[row][col];
        while(q.size() != 0)
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] cur = q.poll();
                for(int[] dir : dirs)
                {
                    int newX = cur[1] + dir[1];
                    int newY = cur[0] + dir[0];
                    if(newX < 0 || newX >= col || newY < 0 || newY >= row || forest.get(newY).get(newX) == 0
                       || visited[newY][newX])
                        continue;
                    
                    if(newX == tar[1] && newY == tar[0])
                        return step;
                    
                    visited[newY][newX] = true;
                    q.add(new int[] {newY, newX});
                }
            }
            step++;
        }
        return -1;
    }
}