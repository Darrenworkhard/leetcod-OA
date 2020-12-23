//3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        int[] iA = new int[256];
        Arrays.fill(iA,-1);
        char[] cA = s.toCharArray();
        int max = 0;
        int l = 0, r = 0;
        while(r < cA.length)
        {
            int charIndex = cA[r];
            if(iA[charIndex] != -1 && iA[charIndex] >= l)
            {
                l = iA[charIndex]+1;
                iA[charIndex] = r;
            }
            else
                iA[charIndex] = r;  
            
            r++;
            max = Math.max(r-l, max);
        }  
        return max;
    }
}
//one sol for all
//340
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() * k == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cA = s.toCharArray();
        int max = 0;
        int l = 0, r = 0;
        while (r < s.length())
        {
            map.put(cA[r], r++);
            if(map.size() >= k+1)
            {
                int minIndex = Collections.min(map.values());
                char c = cA[minIndex];
                map.remove(c);
                l = minIndex+1;
            }
            max = Math.max(r-l, max);
        }
        return max;
    }
}

//one sol for all
//159
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0) return 0;
        //if(s.length() * k == 0) return 0;
        int slow = 0;
        int fast = 0;
        char[] cA = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        while(fast < s.length())
        {
            //(change 2 to k will the same to 340)
            if(!map.containsKey(cA[fast]) && map.size() >= 2)
            {
                max = Math.max(fast-slow, max);
                //remove(change 2 to k will the same to 340)
                while(map.size() >= 2)
                {
                    map.put(cA[slow], map.get(cA[slow])-1);
                    
                    if(map.get(cA[slow]) == 0)
                        map.remove(cA[slow]);
                    
                    slow++;
                }
            }
            map.put(cA[fast], map.getOrDefault(cA[fast],0)+1);
            fast++;  
        }
        max = Math.max(fast-slow, max);
        return max;
    }
}