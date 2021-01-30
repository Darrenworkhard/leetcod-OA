class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
        }
        //point
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }
        List<Integer> word1FrequencyList = new ArrayList<>(word1Map.values());
        List<Integer> word2FrequencyList = new ArrayList<>(word2Map.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
        //point
        return word1FrequencyList.equals(word2FrequencyList);
    }
}

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] w1Array = new int[26];
        int[] w2Array = new int[26];
        for(int i = 0; i < word1.length(); i++)
        {
            w1Array[word1.charAt(i)-'a']++;
            w2Array[word2.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++)
        {
            if(w1Array[i] == 0 && w2Array[i] != 0 || w1Array[i] != 0 && w2Array[i] == 0)
                return false;
        }
        Arrays.sort(w1Array);
        Arrays.sort(w2Array);
        for(int i = 0; i < 26; i++)
        {
            if(w1Array[i] != w2Array[i])
                return false;
        }
        return true;
    }
}