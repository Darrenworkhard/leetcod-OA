class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int xlen = matrix[0].length;
        int ylen = matrix.length;
        for(int y = 0; y < ylen; y++)
        {
            if(matrix[y][xlen-1] >= target)
            {
                //Binary search
                int min = 0;
                int max = xlen - 1;
                //need consider min = max ex:[1]
                while(min <= max)
                {
                    int mid = (min + max) /2;
                    if(matrix[y][mid] == target)
                        return true;
                    else if(matrix[y][mid] < target)
                    {
                        min = mid+1;
                    }
                    else
                    {
                        max = mid-1;
                    }
                }
                break;
            }
        }
        return false;
    }
}
