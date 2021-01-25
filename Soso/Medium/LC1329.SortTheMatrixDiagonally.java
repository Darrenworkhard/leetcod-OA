package Soso.Medium;
import java.util.*;

public class LC1329.SortTheMatrixDiagonally {

    class Solution {
        public int[][] diagonalSort1(int[][] mat) {
            for(int x = mat[0].length; x >= 0; x--)
            {
                List<Integer> list = dfs(mat, x, 0, new ArrayList<Integer>());
                Collections.sort(list);
                sort(mat, x, 0, list, 0);
            }
            for(int y = 1; y < mat.length; y++)
            {
                List<Integer> list = dfs(mat, 0, y, new ArrayList<Integer>());
                Collections.sort(list);
                sort(mat, 0, y, list, 0);
            }
           return mat;
        }
        List<Integer> dfs(int[][] mat, int x, int y, List<Integer> list)
        {
            if(x >= mat[0].length || y >= mat.length)
                return list;
            
            list.add(mat[y][x]);
            
            return dfs(mat, x+1, y+1, list);
        }
        void sort(int[][] mat, int x, int y, List<Integer> list, int cur)
        {
            if(list.size() == cur)
                return;
            
            mat[y][x] = list.get(cur);
            
            sort(mat, x+1, y+1, list, cur+1);
        }
    }

    public int[][] diagonalSort2(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int x = 0; x < mat[0].length; x++)
        {
            for(int y = 0; y < mat.length; y++)
            {
                map.putIfAbsent(y-x, new PriorityQueue<>());
                
                map.get(y-x).add(mat[y][x]);
            }
        }
        
        for(int x = 0; x < mat[0].length; x++)
        {
            for(int y = 0; y < mat.length; y++)
            {
               mat[y][x] = map.get(y-x).remove();
            }
        }
        return mat;
    }
}
