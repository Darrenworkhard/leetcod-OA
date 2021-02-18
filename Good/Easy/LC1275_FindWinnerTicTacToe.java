package Good.Easy;

public class LC1275_FindWinnerTicTacToe {
    public String tictactoe(int[][] moves) {
        char[][] graph = new char[3][3];
        
        for(int i = 0; i < moves.length; i++)
        {
            char c = i % 2 == 0 ? 'X' : 'O';
            graph[moves[i][0]][moves[i][1]] = c;
        }
        //System.out.println(graph[2][2] + "/");
        for(int x = 0; x < 3; x++)
        {
            if(graph[0][x] != 'X' && graph[0][x] != 'O') continue;
            boolean hasWinner = check(graph, x, 0, new int[]{1, 0});
            if(hasWinner)
            {
                return graph[0][x] == 'X' ? "A" : "B";
            }
            if(x == 0)
            {
                boolean checkDiagnal = check(graph, x, 0, new int[]{1, 1});
                if(checkDiagnal)
                {
                    return graph[0][x] == 'X' ? "A" : "B";
                }
            }
            if(x == 2)
            {
                boolean checkDiagnal = check(graph, x, 0, new int[]{1, -1});
                if(checkDiagnal)
                {
                    return graph[0][x] == 'X' ? "A" : "B";
                }
            }
        }
        for(int y = 0; y < 3; y++)
        {
            if(graph[y][0] != 'X' && graph[y][0] != 'O') continue;
            boolean hasWinner = check(graph, 0, y, new int[]{0, 1});
            if(hasWinner)
            {
                return graph[y][0] == 'X' ? "A" : "B";
            }
        }
  
        return moves.length == 9 ? "Draw" : "Pending";
    }
    
    boolean check(char[][] moves, int x, int y, int[] dir)
    {
        char c = moves[y][x];
        
        return moves[y+dir[0]][x+dir[1]] == c && moves[y+dir[0]+dir[0]][x+dir[1]+dir[1]] == c;
    }
}
