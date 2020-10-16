//DFS
class Solution {
    //Visited friend
    boolean[] visited = new boolean[0];
    public int findCircleNum(int[][] M) {
        visited = new boolean[M.length];
        int ans = 0;
        for(int student = 0; student < M.length; student++)
        {
            if(!visited[student])
            {
                dfs(M, student);
                ans++;
            }
        }
        return ans;
    }
    void dfs(int[][]M, int student)
    {
        if(visited[student])
            return;
        
        visited[student] = true;
        //this student connection friend
        for(int friend = 0; friend < M[student].length; friend++)
        {
            if(M[student][friend] == 1)
                dfs(M, friend);
        }
    }

} 
