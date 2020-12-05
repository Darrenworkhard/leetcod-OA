//1D
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] mem = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            mem[i] = new StringBuilder();
        
        char[] cA = s.toCharArray();
        int x = 0, y = 0;
       
        for(int i = 0; i < cA.length; i++)
        {         
            mem[y].append(cA[i]);
            if(x % (numRows-1) == 0)
            {
                y++;
                if(y == numRows)
                {
                    y = y-2;
                    x++;
                }     
            }
            else
            { 
                x++;
                y--;
            }
        }
        // int curRow = 0;
        // boolean goingDown = false;
        // for (char c : s.toCharArray()) {
        //     rows.get(curRow).append(c);
        //     if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
        //     curRow += goingDown ? 1 : -1;
        // }
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < mem.length; i++)
        {
            ret.append(mem[i]);
        }
        return ret.toString();
    }
}

//2D
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[][] mem = new char[numRows][s.length()];
        char[] cA = s.toCharArray();
        int x = 0, y = 0;
        for(int i = 0; i < cA.length; i++)
        {
            char c = cA[i];
            mem[y][x] = c;
            if(x % (numRows-1) == 0)
            {
                y++;
                if(y == numRows)
                {
                    y = y-2;
                    x++;
                }     
            }
            else
            { 
                x++;
                y--;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < mem.length; i++)
        {
            for(int j = 0; j < s.length(); j++)
            {
                if(mem[i][j] != 0)
                    sb.append(mem[i][j]);
            }
        }
        return sb.toString();
    }
}