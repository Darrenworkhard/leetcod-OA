//Reference 
//https://www.youtube.com/watch?v=n3s9Q7GtfB4&ab_channel=HuaHua
class Solution {
    class UF {
        int[] Parents;
        int[] Ranks;
        UF(int n)
        {
            Parents = new int[n];
            Ranks = new int[n];
            for(int i = 0; i < n; i++)
            {
                Parents[i] = i;
            }
        }
        int Find(int num)
        {
            //Path compress
            while(Parents[num] != num)
            {
                Parents[num] = Parents[Parents[num]];
                num = Parents[num];
            }
            return num;
        }
        void Union(int v, int u)
        {
            int ParentV = Find(v);
            int ParentU = Find(u);
            if(ParentV == ParentU) return;
            if(Ranks[ParentV] < Ranks[ParentU])
            {
                Parents[ParentV] = ParentU;
                for(int i = 0; i < Parents.length; i++)
                {
                    if(Parents[i] == ParentU)
                        Parents[i] = ParentV;
                }
                Ranks[ParentU]++;
            }
            else
            {
                //Parents[ParentU] = ParentV;
                for(int i = 0; i < Parents.length; i++)
                {
                    if(Parents[i] == ParentU)
                        Parents[i] = ParentV;
                }
                Ranks[ParentV]++;
            }
        }
    }
    public int regionsBySlashes(String[] grid) {
        
        UF uf = new UF(4 * grid.length * grid.length);
        int index = 0;
        int len = grid.length-1;
        for(int y = 0; y < grid.length; y++)
        {
            for(int x = 0; x < grid.length; x++)
            {
                char s = grid[y].charAt(x);
                switch(s)
                {
                    case '/':
                        uf.Union(index + 0, index + 3);
                        uf.Union(index + 1, index + 2);
                        break;
                    case '\\':
                        uf.Union(index + 0, index + 1);
                        uf.Union(index + 2, index + 3);
                        break;
                     case ' ':
                        uf.Union(index + 0, index + 1);
                        uf.Union(index + 0, index + 2);
                        uf.Union(index + 0, index + 3);
                        break;           
                }
                if(x < len)
                {
                    //(index + 4) next column graph
                    //merge to next graph
                    uf.Union(index + 1, (index + 4) + 3);
                }
                if(y < len)
                {
                    //(index + 4 * grid.length) next row graph
                    uf.Union(index + 2, index + 4 * grid.length + 0);
                }
                index += 4;
            }
       
        }
        //count regions
        HashSet<Integer> set = new HashSet<>();
        for(int num : uf.Parents)
        {
            set.add(num);
        }
        return set.size();
    }
    
}
