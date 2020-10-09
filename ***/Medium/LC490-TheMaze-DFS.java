class Solution {
    int[][] dirction = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    boolean ans = false;

    public boolean hasPath(int[][] maze, int[] start, int[] target) {
        boolean[][] used = new boolean[maze.length][maze[0].length];

        dfs(maze, start, target, used);
        return ans;
    }
    boolean dfs(int[][] maze, int[] cur, int[] target, boolean[][] used)
    {
        if(cur[0] == target[0] && cur[1] == target[1])
        {
            ans = true;
            return true;
        }
        
        for(int[] dir : dirction)
        {

            int[] newCur = new int[]{cur[0], cur[1]};
            int x = dir[1];
            int y = dir[0];
            int newx = newCur[1];
            //move horizon
            if(y == 0)
            {
                //Untill touch to will
                while(newCur[1] >= 0 && newCur[1] < maze[0].length && maze[newCur[0]][newCur[1]] == 0)
                {
                    newCur[1] += dir[1];
                }
                newCur[1] -= dir[1];
            }
            else
            {
                 //Untill touch to will
                while(newCur[0] >= 0 && newCur[0] < maze.length && maze[newCur[0]][newCur[1]] == 0)
                {
                    newCur[0] += dir[0];
                }
                newCur[0] -= dir[0];
            }
            if(!used[newCur[0]][newCur[1]])
            {
                used[newCur[0]][newCur[1]] = true;
                dfs(maze, new int[]{newCur[0], newCur[1]}, target, used);
            }

            if(ans)
                break;
            
        }
        
        return false;
    }
   
}
