class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.add(beginWord);
        while(!queue.isEmpty())
        {
            int size = queue.size();            
            for(int i = 0; i < size; i++)
            {
                String s = queue.poll();
                for(int j = 0; j < wordList.size(); j++)
                {
                    String word = wordList.get(j);
                    if(!used.contains(word) && onlyOneWordDifferent(s, word))
                    {
                        if(word.equals(endWord))
                            return ans + 1;
                        else
                        {
                            used.add(word);
                            queue.add(word);
                        }
                    }                
                }                
            }
            ans++;
        }
        return 0;
        
    }
    boolean onlyOneWordDifferent(String a, String b)
    {
        int countDiff = 0;
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) != b.charAt(i))
                countDiff++;
            
            if(countDiff > 1)
                return false;
        }
        return countDiff == 1;
    }
}
