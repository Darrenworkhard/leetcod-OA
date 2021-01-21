class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int ret = 0;
        for(int x = 0; x < grid[0].length; x++)
        {
            for(int y = 0; y < grid.length; y++)
            {
                if(grid[y][x] == '1')
                {
                    dfs(grid, x, y);
                    ret++;
                }           
            }
        }
        
        return ret;
    }
    void dfs(char[][] grid, int x, int y)
    {
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == '0')
            return;
        
        grid[y][x] = '0';
        for(int[] dir : dirs)
        {
            dfs(grid, x+dir[0], y+dir[1]);
        }
        
    }
}