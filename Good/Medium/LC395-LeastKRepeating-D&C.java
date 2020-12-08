//Divide and conquer (speed up)
class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() == 0 || s.length() < k) return 0;
        
        return dfs(s.toCharArray(), 0, s.length(), k);
    }
    int dfs(char[] cA, int start, int end, int k)
    {
        if(start > end) 
            return 0;
        int[] mem = new int[27];
        for(int i = start; i < end; i++)
        {
            mem[cA[i]-'a'] += 1;
        }
        int sum = 0;
        for(int i = start; i < end; i++)
        {
            if(mem[cA[i]-'a'] >= k) continue;
            //Speed up find next char count biggent than k
            int nextIndex = i+1;
            while(nextIndex < end && mem[cA[nextIndex]-'a'] < k) nextIndex++;

            return Math.max(dfs(cA, start, i, k),dfs(cA, nextIndex, end, k));

        }
        return (end - start);
       
    }
}

//Divide and conquer
class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() == 0 || k > s.length()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        if(Collections.min(map.values()) >= k)
        {
            int ret = 0;
            for(char c : map.keySet())
            {
                ret += map.get(c);
            }
            return ret;
        }
        char invalidC = 0;
        for(char c : map.keySet())
        {
            if(map.get(c) < k)
            {
                invalidC = c;
                break;
            }
        }
        int index = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(invalidC == s.charAt(i))
            {
                index = i;
                break;
            }
        }
        return Math.max(longestSubstring(s.substring(0, index), k), longestSubstring(s.substring(index+1, s.length()), k));
    }
}

//(TLE)
class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cA = s.toCharArray();
        int max = 0;
        for(int i = 0; i < cA.length; i++)
        {
            for(int j = i; j < cA.length; j++)
            {
                map.put(cA[j], map.getOrDefault(cA[j],0)+1);
                if(Collections.min(map.values()) >= k)
                    max = Math.max(max, j-i+1);
            }
            map = new HashMap<>();
        }
        return max;
    }
}