class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // base cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        // Build the graph with the adjacency list
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        // Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with the edges
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer neighbor = neighbors.get(leaf).iterator().next();
                // remove the edge along with the leaf node
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepare for the next round
            leaves = newLeaves;
        }

        // The remaining nodes are the centroids of the graph
        return leaves;
    }
}

//5%
class Solution {
    HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    //Priori
    int min = Integer.MAX_VALUE;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(edges.length == 0)
        {
            ans.add(0);
            return ans;
        }
        buildGraph(edges);
        //Trim
        HashMap<Integer, HashSet<Integer>> graph1 = graph;
        while(graph.size() > 2)
        {
            List<Integer> remove = new ArrayList<>();
            List<Integer> removeLeave = new ArrayList<>();
            for(Integer key : graph.keySet())
            {
                HashSet<Integer> s = graph.get(key);
                if(s.size() == 1)
                {
                    for(int i : s)
                    {
                        removeLeave.add(i);  
                    }
                    remove.add(key);
                }
            }
            for(int i : remove)
            {
                for(Integer key : removeLeave)
                {
                   graph.get(key).remove(i);
                }
                graph.remove(i);
            }
        }
        for(Integer key : graph.keySet())
        {
            HashSet<Integer> s = new HashSet<>();
            s.add(key);
            int count = dfs(s, 0, key);
            if(min >= count)
            {
                if(min > count)
                {
                    ans.clear();
                }
                ans.add(key);
            }
            min = Math.min(min, count);
        }
        return ans;
    }
    void buildGraph(int[][] edges)
    {
        for(int i = 0; i < edges.length; i++)
        {
            graph.putIfAbsent(edges[i][0], new HashSet<>());
            graph.putIfAbsent(edges[i][1], new HashSet<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
    }
    int dfs(HashSet<Integer> used, int count, int current)
    {
        Set<Integer> lists = graph.get(current);
        int newCount = count;
        for(int i : lists)
        {
            if(!used.contains(i))
            {
                used.add(i);
                newCount = Math.max(dfs(used, count+1, i), newCount);
            }
        }
        return newCount;
    }
}