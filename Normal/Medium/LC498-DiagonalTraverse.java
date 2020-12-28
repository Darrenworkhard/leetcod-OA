public class LC498_DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        List<Integer> ret = new ArrayList<>();
        int lenX = matrix[0].length;
        int lenY = matrix.length;
        int odd = 0;
        for(int x = 0; x < lenX; x++)
        {
            List<Integer> list = GetNumber(matrix, x, 0);
            if(odd % 2 == 0)
            {
                Collections.reverse(list);
            }
            odd++;
            ret.addAll(list);
        }
        for(int y = 1; y < lenY; y++)
        {
            List<Integer> list = GetNumber(matrix, lenX-1, y);
            if(odd % 2 == 0)
            {
                Collections.reverse(list);
            }
            odd++;
            ret.addAll(list);
        }
        int[] ans = new int[ret.size()];
        int index = 0;
        for(int i : ret)
        {
            ans[index++] = i;
        }
        
        return ans;
    }
    
    List<Integer> GetNumber(int[][] matrix, int x, int y)
    {
        List<Integer> ret = new ArrayList<>();
        while(x >= 0 && y < matrix.length)
        {
            ret.add(matrix[y][x]);
            x--;
            y++;
        }
        return ret;
    }

}
