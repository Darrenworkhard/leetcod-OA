class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        double[][] tower = new double[101][101];
        tower[0][0] = poured;
        for(int y = 0; y <= query_row; y++)
        {
            for(int x = 0; x <= y; x++)
            {
                double remain = (tower[y][x] - 1)/2;
                if(remain > 0)
                {
                    tower[y+1][x] += remain;
                    tower[y+1][x+1] += remain;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}