class Solution {
    //T O(C)
    HashMap<Character, HashSet<Character>> graph = new HashMap<>();
    HashMap<Character, Integer> degree = new HashMap<>();
    boolean cycle = false;
    StringBuilder curMaxSb = new StringBuilder();
    public String alienOrder(String[] words) {
        for (String s : words) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                if(!degree.containsKey(c))
                    degree.put(c, 0);
            }
        }
        for(int i = 0; i < words.length-1; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                if(words[i+1].length() <= j)
                    return  "";
                
                if(words[i].charAt(j) != words[i+1].charAt(j))
                {
                    buildGraph(words[i].charAt(j), words[i+1].charAt(j));
                    break;
                }
               
            }
        }
        HashMap<Character, HashSet<Character>> graph1 = graph;
        HashMap<Character, Integer> degree1 = degree;
        //BFS
        StringBuilder ret = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(char c : degree.keySet())
        {
            if(degree.get(c) == 0)
                q.add(c);
        }
        while(!q.isEmpty())
        {
            char c = q.poll();
            ret.append(c);
            HashSet<Character> children = graph.get(c);
            if(children == null)
                continue;
            for(char child : children)
            {
                degree.put(child, degree.get(child)-1);
                if(degree.get(child) == 0)
                    q.add(child);
            }
        }

        return ret.length() == degree.keySet().size() ? ret.toString() : "";
    }

    void buildGraph(char parent, char child)
    {

        if(!graph.get(parent).contains(child))
        {
             graph.get(parent).add(child);     
             degree.put(child, degree.getOrDefault(child,0)+1);
        }
       
    }
}