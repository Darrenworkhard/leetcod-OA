//https://www.youtube.com/watch?v=mKUsbABiwBI&t=90s&ab_channel=%E5%B0%8F%E5%B0%8F%E7%A6%8FLeetCode
//https://www.youtube.com/watch?v=wUgWX0nc4NY&ab_channel=WilliamFiset

class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); 
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] lowLink = new int[n];
        for(List<Integer> con : connections)
        {
            buildGraph(con.get(0), con.get(1));
        }
        while(n > 0)
        {
            lowLink[--n] = -1;
        }
        dfs(0, -1, 0, lowLink);
        
        return ret;

    }
    int dfs(int cur, int par, int lvl, int[] lowLink)
    {
        lowLink[cur] = lvl+1;
        if(map.get(cur) != null)
            for(int child : map.get(cur))
            {
                if(child == par)
                {
                    continue;
                }    
                //not visited
                else if(lowLink[child] == -1)
                {
                    lowLink[cur] = Math.min(lowLink[cur], dfs(child, cur, lvl+1, lowLink));
                }   
                else
                    lowLink[cur] = Math.min(lowLink[cur], lowLink[child]);    
            }
        //System.out.println(lvl+1 + "/" + cur);
        if(lowLink[cur] == lvl+1 && cur != 0)
        {
            ret.add(Arrays.asList(cur, par));
        }
        
        return lowLink[cur];
    }
    void buildGraph(int from, int to)
    {
        map.putIfAbsent(from, new ArrayList<>());
        map.get(from).add(to);
        
        // map.putIfAbsent(to, new ArrayList<>());
        // map.get(to).add(from);
    }
}