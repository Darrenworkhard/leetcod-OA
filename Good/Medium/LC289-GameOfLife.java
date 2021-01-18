class Solution {
    int[][] dir = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
    public void gameOfLife(int[][] board) {
        for(int x = 0; x < board[0].length; x++)
        {
            for(int y = 0; y < board.length; y++)
            {
                board[y][x] = chackstatus(board, x, y);
            }
        }
        
        for(int x = 0; x < board[0].length; x++)
        {
            for(int y = 0; y < board.length; y++)
            {
                if(board[y][x] == -1)
                    board[y][x] = 0;
                else if(board[y][x] == -2)
                    board[y][x] = 1;
            }
        }
    }
    int chackstatus(int[][] board, int x, int y)
    {
        int countlive = 0;
        int current = board[y][x];
        for(int[] i : dir)
        {
            int newX = i[0] + x;
            int newY = i[1] + y;
            if(newX < 0 || newX >= board[0].length || newY < 0 || newY >= board.length)
                continue;
            
            if(board[newY][newX] == 0 || board[newY][newX] == -2)
                countdie++;
            else if(board[newY][newX] == 1 || board[newY][newX] == -1)
                countlive++;
        }
        if(current == 1 && countlive < 2)
            //alive but will change to die
            return -1;
        else if(current == 1 && (countlive == 2 || countlive == 3))
            return current;
        else if(current == 1 && countlive > 3)
            return -1;
        else if(current == 0 && countlive == 3)
            //die but will alive;
            return -2;
        
        return current;
    }
}