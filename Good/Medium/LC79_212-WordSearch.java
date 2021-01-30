public class WordSearch {
    class TrieSolution {
        
    }
    class DFSSolution {
        //79 - T O(N⋅3L), S O(L)
        //212 - T O(L*N⋅3L), S O(L)
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        boolean ans = false;

        //212
        public List<String> findWords(char[][] board, String[] words) {
            List<String> ret = new ArrayList<>();
            for(String s : words)
            {
                if(exist(board, s))
                {
                    ret.add(s);
                }
                ans = false;
            }
            return ret;
        }


        //79
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for(int x = 0; x < board[0].length; x++)
            {
                for(int y = 0; y < board.length; y++)
                {
                    if(board[y][x] == word.charAt(0) && !ans)
                    {
                        visited[y][x] = true;
                        dfs(board, word, 1, x, y, visited);
                        visited[y][x] = false;
                    }
                }
            }
            return ans;
        }
        void dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited)
        {
            if(word.length() == index)
            {
                ans = true;
                return;
            }
            visited[y][x] = true; //<- faster than ln 36
            for(int[] dir : dirs)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newY < 0 || newX >= board[0].length || newY >= board.length || board[newY][newX] != word.charAt(index) || visited[newY][newX] || ans)
                    continue;

                //visited[newY][newX] = true;
                dfs(board, word, index+1, newX, newY, visited);
                //visited[newY][newX] = false;
    
            }
            visited[y][x] = false; //<- faster than ln 38
        }
    }
}
