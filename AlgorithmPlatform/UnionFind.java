public class UnionFind {
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
                Parents[parentU] = parentV;
                // 1.Union here or at the last step
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
                Parents[parentV] = parentU;
                // 1.Union here or at the last step
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
}
