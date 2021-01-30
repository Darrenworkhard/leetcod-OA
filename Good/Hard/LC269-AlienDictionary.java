public class LC269-AlienDictionary {
    
}


class Solution {
    HashMap<Character, HashSet<Character>> graph = new HashMap<>();
    HashMap<Character, Integer> degree = new HashMap<>();
    boolean cycle = false;
    StringBuilder curMaxSb = new StringBuilder();
    public String alienOrder(String[] words) {
        String ret = "";
        for(int i = 0; i < words.length-1; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                if(words[i+1].length() <= j)
                    return  "";
                
                if(!degree.containsKey(words[i].charAt(j)))
                    degree.put(words[i].charAt(j), 0);
                
                if(words[i].charAt(j) != words[i+1].charAt(j))
                {
                    buildGraph(words[i].charAt(j), words[i+1].charAt(j));
                    break;
                }
               
            }
        }
        HashMap<Character, Integer> abc = degree;
        for(char c : abc.keySet())
        {
            if(degree.get(c) == 0)
            {
                isCycle(c, new boolean[26]);
                if(cycle)
                    return "";
                
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                createPath(c, sb);
                ret += curMaxSb.toString();
                curMaxSb = new StringBuilder();
            }
        }
        return ret;
    }

    void buildGraph(char parent, char child)
    {
        graph.putIfAbsent(parent, new HashSet<>());
        graph.get(parent).add(child);
             
        degree.put(child, degree.getOrDefault(child,0)+1);
    }

    //can't use dfs ["qb","qts","qs","qa","s"]
    void isCycle(char cur, boolean[] visited)
    {
        HashSet<Character> children = graph.get(cur);
        if(children == null) return;
        String s = "";
        visited[cur-'a'] = true;
        for(char c : children)
        {
            if(visited[c-'a'])
            {
                cycle = true;
            }
            else if(!cycle)
            {
                isCycle(c, visited);
            }
        }
    }
    void createPath(char cur, StringBuilder sB)
    {
        HashSet<Character> children = graph.get(cur);
        if(children == null)
        {
            if(sB.length() > curMaxSb.length())
                curMaxSb = new StringBuilder(sB.toString());
            
            return;
        }
        
        for(char c : children)
        {
            createPath(c, sB.append(c));
            sB.delete(sB.length()-1, sB.length());
        }
    }
    
}