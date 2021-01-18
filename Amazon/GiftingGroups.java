//similar 
//Union-find
class Solution {
    
    class UF{
        int[] Parents;
        int[] Rank;
        UF(int n)
        {
            Parents = new int[n+1];
            Rank = new int[n+1];
            for(int i = 0; i < n; i++)
            {
                //Assume every node is it's own parent
                Parents[i] = i;
            }
        }
        int Find(int val)
        {
            //Path compression
            //Find until parent is it's self
            while(Parents[val] != val)
            {
                //Chage every parent to their parent
                Parents[val] = Parents[Parents[val]];
                val = Parents[val];
            }
            return val;
        }
        boolean Union(int v, int u)
        {
            int parentV = Find(v);
            int parentU = Find(u);
            if(parentV == parentU)
                return false;
            if(Rank[parentV] > Rank[parentU])
            {
                //Union smaller rank array to bigger rank
                //Parents[parentU] = parentV;
                // for(int i = 0; i < Parents.length; i++)
                // {
                //     if(Parents[i] == parentU)
                //     {
                //         Parents[i] = parentV;
                //     }
                // }
                Rank[parentV]++;
            }
            else
            {
                //Parents[parentV] = parentU;
                // for(int i = 0; i < Parents.length; i++)
                // {
                //     if(Parents[i] == parentV)
                //     {
                //         Parents[i] = parentU;
                //     }
                // }
                Rank[parentU]++;
            }
            return true;
        }
    }
    public int findCircleNum(int[][] M) {
        int ans = 0;
        UF uf = new UF(M.length);

        for(int student = 0; student < M.length; student++)
        {
            for(int friends = 0; friends < M[student].length; friends++)
            {
                if(M[student][friends] == 1)
                {
                    uf.Union(student, friends);
                }
            }
            
        }
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < M.length; i++)
        {
            s.add(uf.Parents[i]);
        }
        return s.size();
    } 

    //DFS
    public int findCircleNum2(int[][] M) {
        boolean[] visited = new boolean[M.length + 1];
        int circle = 0;
        for(int i = 0; i < M.length; i++)
        {
            if(!visited[i])
            {
                dfs(M, i, visited);
                circle++;
            }
        }
        return circle;
    }
    void dfs(int[][] M, int node, boolean[] visited)
    {
        int[] friends = M[node];
        visited[node] = true;
        for(int i = 0; i < friends.length; i++)
        {
            if(friends[i] == 1 && !visited[i])
                dfs(M, i, visited);
        }
        
    }
    
} 

