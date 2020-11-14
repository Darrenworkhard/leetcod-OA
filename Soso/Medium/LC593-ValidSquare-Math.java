class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dists = new int[] {d(p1, p2), d(p1, p3), d(p1, p4), d(p2, p3), d(p2, p4), d(p3, p4)};
        Arrays.sort(dists);
        return (dists[0] == dists[1] && dists[1] == dists[2] && dists[2] == dists[3] && dists[3] < dists[4] && dists[4] == dists[5]);
    }
    
    private int d(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
//Mine
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean isSquare = true;
        int[][] array = new int[4][];
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;
        array[3] = p4;
        for(int i = 0; i < array.length; i++)
        {  
            if(!dfs(array, i))
                return false;
        }
        
        return isSquare;
    }
    boolean dfs(int[][] array, int index)
    {
        boolean isAngles = false;
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length; j++)
            {
                if(j != i && j != index && i != index)
                {
                    double a = Math.pow(Math.abs(array[index][0] - array[j][0]),2) + Math.pow(Math.abs(array[index][1] - array[j][1]),2);
                    double b = Math.pow(Math.abs(array[index][0] - array[i][0]),2) + Math.pow(Math.abs(array[index][1] - array[i][1]),2);
                    double c = Math.pow(Math.abs(array[i][0] - array[j][0]),2) + Math.pow(Math.abs(array[i][1] - array[j][1]),2);
                    
                    if(c != 0 && c == a + b && a == b)
                        isAngles = true;
                }
            }
        }
        return isAngles;
    }
}