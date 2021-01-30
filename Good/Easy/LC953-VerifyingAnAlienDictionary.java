class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cA = order.toCharArray();
        for(int i = 0; i < cA.length; i++)
        {
            //h : 0, l : 1 ...
            map.put(cA[i], i);
        }
        int maxLen = 0;
        for(int i = 0; i < words.length-1; i++)
        {
            int len = words[i].length();
            for(int j = 0; j < len; j++)
            {
                int indexWord1 = map.get(words[i].charAt(j));
                if(j >= words[i+1].length())
                    return false;
                int indexWord2 = map.get(words[i+1].charAt(j));
                if(indexWord1 > indexWord2)
                    return false;
                else if(indexWord1 < indexWord2)
                    break;
            }
        }
       
        return true;
    }
}