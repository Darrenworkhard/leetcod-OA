class Solution {
    //UF
    class UF {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        
        UF(List<List<String>> pairs)
        {
            for(List<String> pair : pairs)
            {
                String v = pair.get(0);
                String u = pair.get(1);
                map.putIfAbsent(v, v);
                map.putIfAbsent(u, u);
                rank.putIfAbsent(v, 1);
                rank.putIfAbsent(u, 1);
                String parentV = Find(v);
                String parentU = Find(u);
                if(parentV != parentU)
                {
                    if(rank.get(parentV) < rank.get(parentU))
                    {
                        for(String key : map.keySet())
                        {
                            if(map.get(key).equals(parentV))
                            {
                                map.put(key, parentU);
                            }
                        }
                        rank.put(parentU, rank.get(parentU)+1);
                    }
                    else
                    {
                        for(String key : map.keySet())
                        {
                            if(map.get(key).equals(parentU))
                            {
                                map.put(key, parentV);
                            }
                        }
                        rank.put(parentV, rank.get(parentV)+1);
                    }
                }
            }
        }
        String Find(String word)
        {
            if(map.containsKey(word) && !word.equals(map.get(word)))
            {
                word = Find(map.get(word));
            }
            
            return word;
        }
    }
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        UF uf = new UF(pairs);
        for(int i = 0; i < words1.length; i++)
        {
            // if(words1[i].equals(words2[i]))
            //     continue;
            if(!uf.Find(words1[i]).equals(uf.Find(words2[i])))
                return false;
        }
        return true;
    }
}
