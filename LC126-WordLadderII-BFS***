class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() == 0) return ans;
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return ans;
        
        Queue<Pair<String, List<String>>> qM = new LinkedList<>();        
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        Pair<String, List<String>> map = new Pair<>(beginWord, subList);
        qM.add(map);
        Set<String> visited = new HashSet<>();
        Boolean findAns = false;
        
        while(!qM.isEmpty())
        {
            int size = qM.size();
            visited = new HashSet<>();
            for(int i = 0; i < size; i++)
            {
                Pair<String, List<String>> pair = qM.poll();
                String s = pair.getKey();
                List<String> list = pair.getValue();
                char[] cArray = s.toCharArray();
                for(int c = 0; c < cArray.length; c++)
                {
                    char temp = cArray[c];
                    for(char j = 'a'; j <= 'z'; j++)
                    {
                        cArray[c] = j;
                        String newS = new String(cArray);
                        if(newS.equals(endWord))
                        {
                            list.add(endWord);
                            ans.add(new ArrayList<>(list));
                            findAns = true;
                        }
                        else if(wordSet.contains(newS))
                        {
                            list.add(newS);
                            Pair<String, List<String>> newPair= new Pair<>(newS, new ArrayList<>(list));
                            qM.add(newPair);
                            list.remove(list.size() - 1);
                            wordSet.remove(newS);
                            visited.add(newS);
                        }
                        else if(visited.contains(newS))
                        {
                            list.add(newS);
                            Pair<String, List<String>> newPair= new Pair<>(newS, new ArrayList<>(list));
                            qM.add(newPair);
                            list.remove(list.size() - 1);
                        }
                    }
                    cArray[c] = temp;
                }
            }
            
            if(findAns)
                break;
        }
        
        return ans;
    }
}
