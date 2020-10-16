class Solution {
    int[][] dirction = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    boolean ans = false;

    public boolean hasPath(int[][] maze, int[] start, int[] target) {
        boolean[][] used = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            if(cur[0] == target[0] && cur[1] == target[1])
                return true;
            for(int[] dis : dirction)
            {
                int[] newCur = new int[]{cur[0], cur[1]};
                //y == 0 - x move
                if(dis[0] == 0)
                {
                    while(newCur[1] >= 0 && newCur[1] < maze[0].length && maze[newCur[0]][newCur[1]] == 0)
                    {
                        newCur[1] += dis[1];
                    }
                    newCur[1] -= dis[1];
                }
                else
                {
                    while(newCur[0] >= 0 && newCur[0] < maze.length && maze[newCur[0]][newCur[1]] == 0)
                    {
                        newCur[0] += dis[0];
                    }
                    newCur[0] -= dis[0];
                }
                if(!used[newCur[0]][newCur[1]])
                {
                    used[newCur[0]][newCur[1]] = true;
                    q.add(newCur);
                }
            }
        }
        
        return false;
    }
  
}
