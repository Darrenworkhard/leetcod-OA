class Solution {
    //Dfs
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        if(pairs.size() == 0)
        {
            for(int i = 0; i < pairs.size(); i++)
            {
                if(!words1[i].equals(words2[i]))
                    return false;
            }
            return true;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        buildGraph(map, pairs);
        for(int i = 0; i < words1.length; i++)
        {
            if(!dfs(words1[i], words2[i], pairs, map, new HashSet<>()))
                return false;
        }
        return true;
    }
    HashMap<String, List<String>> buildGraph(HashMap<String, List<String>> map, List<List<String>> pairs)
    {
        for(List<String> list : pairs)
        {
            map.putIfAbsent(list.get(0), new ArrayList<>());
            map.putIfAbsent(list.get(1), new ArrayList<>());
            
            map.get(list.get(0)).add(list.get(1));
            map.get(list.get(1)).add(list.get(0));
        }
        return map;
    }
    boolean dfs(String source, String target, List<List<String>> pairs
                , HashMap<String, List<String>> map, HashSet<String> visited)
    {
        visited.add(source);
        if(source.equals(target))
            return true;
        List<String> list = map.get(source);
        if(list == null) return false;
        for(int i = 0; i < list.size(); i++)
        {
            if(!visited.contains(list.get(i)) && dfs(list.get(i), target, pairs, map, visited))
                return true;
        }
        return false;
    }
}
