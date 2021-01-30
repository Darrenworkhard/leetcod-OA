class Solution {
    // DP solution

    // only 5 %
    int count = 0;
    public int countCornerRectangles(int[][] grid) {
        for(int x = 0; x < grid[0].length; x++)
        {
            for(int y = 0; y < grid.length; y++)
            {
                if(grid[y][x] == 1)
                    dfs(grid, x, y);
            }
        }
        return count;
    }
    void dfs(int[][] grid, int x, int y)
    {
        for(int i = 1; i <= grid[0].length-x; i++)
        {
            for(int j = 1; j <= grid.length-y; j++)
            {
                boolean valid = isValid(grid, x+i, y) && isValid(grid, x, y+j) && isValid(grid, x+i, y+j);
                if(valid)
                    count++;
            }
            
        }
    }
    boolean isValid(int[][] grid, int x, int y)
    {
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == 0)
            return false;
        
        return true;
    }
}