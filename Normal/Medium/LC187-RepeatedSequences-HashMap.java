class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 9) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        int i = 0;
        int j = 9;
        List<String> ans = new ArrayList<>();
        while(j < s.length())
        {
            String newS = s.substring(i, j+1);
            if(!set.contains(newS) || ans.contains(newS))
                set.add(newS);
            else
            {
                ans.add(newS);
            }
            i++;
            j++;
        }
        return ans;
    }
}
