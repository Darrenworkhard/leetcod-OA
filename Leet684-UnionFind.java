class Solution {
    class UN
    {
        int[] parent;
        int[] rank;
        UN(int n)
        {
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 0; i < n; i++)
            {
                parent[i] = i;
                //rank[i] = i;
            }
        }
        int find(int num)
        {
            //not path compression
            // if(parent[num] != num)
            // {
            //     int par = parent[num];
            //     num = find(par);
            // }
            
            //path compression
            while(parent[num] != num)
            {
                parent[num] = parent[parent[num]];
                num = parent[num];
            }
            return num;
        }
        boolean union(int v, int u)
        {
            //find number belonging parent
            int parentu = find(u);
            int parentv = find(v);
            if(parentu == parentv) return false;
            //Compare parent renk
            if(rank[parentu] > rank[parentv])
            {
                //v marge to u
                parent[parentv] = parentu;
                rank[parentu]++;
            }
            else if(rank[parentu] <= rank[parentv])
            {
                parent[parentu] = parentv;
                rank[parentv]++;
            }
            
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UN un = new UN(edges.length);
        for(int[] e : edges)
        {
            if(!un.union(e[0], e[1]))
            {
                return e;
            }
        }
        return null;
    }
}
