class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int ans = words.length;
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].equals(word1))
                index1 = i;
            else if(words[i].equals(word2))
                index2 = i;
            if(index1 != -1 && index2 != -1)
            {
                ans = Math.min(Math.abs(index1 - index2), ans);
            }
        }
        return ans;
    }
}