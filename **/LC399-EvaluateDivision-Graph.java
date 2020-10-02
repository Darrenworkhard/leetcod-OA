class Solution {
    //Variable, graph ans value
    Map<String, HashMap<String, Double>> variableMap = new HashMap<>();
    Set<String> visited = new HashSet<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //Builde graph
        buildGraph(equations, values);
        
        //DFS
        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++)
        {
            visited = new HashSet<>();
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1));
        }
        
        return ans;
        
    }
    double dfs(String start, String end)
    {
        //Rueries ariable not in equations 
        if(!variableMap.containsKey(start))
            return -1;
        //Find value;
        if(variableMap.get(start).containsKey(end))
        {
            return variableMap.get(start).get(end);
        }
        visited.add(start);
        HashMap<String, Double> neightbour = variableMap.get(start);
        for(String s : neightbour.keySet())
        {
            if(!visited.contains(s))
            {
                double value = dfs(s, end);
                if(value != -1)
                    return variableMap.get(start).get(s) * value;
            }
        }
        
        //No connection found
        return -1;
      
    }
    void buildGraph(List<List<String>> equations, double[] values)
    {
        for(int i = 0; i < equations.size(); i++)
        {
            String root = equations.get(i).get(0);
            String node = equations.get(i).get(1);
            variableMap.putIfAbsent(root, new HashMap<String, Double>());
            variableMap.putIfAbsent(node, new HashMap<String, Double>());
            variableMap.get(root).put(node, values[i]);
            variableMap.get(node).put(root, 1/values[i]);
        }
    }
    
}
