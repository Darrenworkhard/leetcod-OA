//Slow
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
//Fast bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.add(beginWord);
        dict.remove(beginWord);
        while(!queue.isEmpty())
        {
            int size = queue.size();            
            for(int i = 0; i < size; i++)
            {
                String cur = queue.poll();
                char[] wordUnit = cur.toCharArray();
                for(int j = 0; j < wordUnit.length; j++) {
                    char temp = wordUnit[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        wordUnit[j] = c;
                        String newWord = new String(wordUnit);
                        
                        if(dict.contains(newWord)) {
                            if(newWord.equals(endWord)) return ans + 1;
                            else
                            {
                                queue.offer(newWord);
                                dict.remove(newWord);
                            }
                           
                        }
                    }
                    wordUnit[j] = temp;
                }
            }
            ans++;
        }
        return 0;
        
    }
}
//Super fast biodirction bfs
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet= new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> beginUsed = new HashSet<>(beginSet);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> endUsed = new HashSet<>(endSet);
        int step = 0;
        while(beginSet.size() > 0 || endSet.size() > 0)
        {
            step++;
            Set<String> newSet = new HashSet<>();
            if(step % 2 == 1)
            {
                for(String s : beginSet)
                {
                    char[] c = s.toCharArray();
                    for(int j = 0; j < c.length; j++)
                    {
                        char temp = c[j];
                        for(char i = 'a'; i <= 'z'; i++)
                        {
                            c[j] = i;
                            String newS = new String(c);
                            if(wordSet.contains(newS) && !beginUsed.contains(newS))
                            {
                                if(endSet.contains(newS))
                                    return step + 1;
                                else
                                {
                                    beginUsed.add(newS);
                                    newSet.add(newS);
                                }     
                            }
                        }
                        beginSet = newSet;
                        c[j] = temp;
                    }
                   
                }
            }
            else
            {
                for(String s : endSet)
                {
                    char[] c = s.toCharArray();
                    for(int j = 0; j < c.length; j++)
                    {
                        char temp = c[j];
                        for(char i = 'a'; i <= 'z'; i++)
                        {
                            c[j] = i;
                            String newS = new String(c);
                            if(wordSet.contains(newS) && !endUsed.contains(newS))
                            {
                                if(beginSet.contains(newS))
                                    return step + 1;
                                else
                                {
                                    endUsed.add(newS);
                                    newSet.add(newS);
                                }   
                            }
                        }
                        endSet = newSet;
                        c[j] = temp;
                    }
                   
                }
            }
        }
        return 0;
    }
}
