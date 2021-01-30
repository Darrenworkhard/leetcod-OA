public class LC733-FloodFill {
    class Solution {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int xlen = image[0].length;
            int ylen = image.length;
            boolean[][] used = new boolean[ylen][xlen];
            dfs(image, image[sr][sc], newColor, sc, sr, xlen, ylen, used);
            image[sr][sc] = newColor;
            return image;
        }
        void dfs(int[][] image, int oldColor, int newColor, int x, int y, int xlen, int ylen, boolean[][] used)
        {
            
            for(int[] dir : dirs)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newX >= xlen || newY < 0 || newY >= ylen || image[newY][newX] != oldColor || used[newY][newX])
                    continue;
                used[newY][newX] = true;
                image[newY][newX] = newColor;
                dfs(image, oldColor, newColor, newX, newY, xlen, ylen, used);
            }
        }
        
    }
}
