//(O^2) fast
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int startIndex = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int curMax = Math.max(palindromelength(s, i, i), palindromelength(s, i, i+1));
            if(max < curMax)
            {
                max = curMax;
                startIndex = i - (curMax - 1) / 2;
            }     
        }
        return s.substring(startIndex, startIndex + max);
        
    }
    int palindromelength(String s, int l, int r)
    {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }
        return r - l - 1;
    }
}


//(O^3) slow
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        HashMap<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = s.length()-1; j >= i; j--)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    if(max < j-i+1 && isPalindrome(map, s, i, j))
                    {
                        max = j-i+1;
                        ans = s.substring(i, j+1);
                        break;
                    }
                }
            }
        }
        return ans;
    }
    boolean isPalindrome(HashMap<String, Boolean> map, String s, int start, int end)
    {
        String newString = s.substring(start,end+1);
        if(map.containsKey(newString))
            return map.get(newString);
        char[] c = s.toCharArray();
        while(start <= end)
        {
            if(c[start++] != c[end--])
            {
                map.put(newString, false);
                return false;
            }
                
        }
        map.put(newString, true);
        return true;
    }
}