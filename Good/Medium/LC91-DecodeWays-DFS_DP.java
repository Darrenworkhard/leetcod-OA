//https://www.youtube.com/watch?v=OjEHST4SXfE&ab_channel=HuaHua
//DP O(n)
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        int w1 = 1;
        int w2 = 1;
        for(int i = 1; i < s.length(); i++)
        {
            int cur = 0;
            if(!isValid(s.charAt(i)) && !isValid(s.charAt(i-1), s.charAt(i))) return 0;
            if(isValid(s.charAt(i)))
                cur += w1;
            if(isValid(s.charAt(i-1), s.charAt(i)))
                cur += w2;
            
            w2 = w1;
            w1 = cur;
        }
        return w1;
    }
    boolean isValid(char c)
    {
        if(c == '0')
            return false;
        
        return true;
    }
    boolean isValid(char c1, char c2)
    {
        //String s = c1 + "" + c2 + "";
        //if(s.compareTo("1") == -1 || s.compareTo("26") == 1)
        int num = (c1 - '0') * 10 + c2 - '0';
        if(c1 == '0' || num < 1 || num > 26)
            return false;
        
        return true;
    }
}
//O(n) because no need copy substring?
class Solution {
     
    public int numDecodings(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;    
        char[] c = s.toCharArray();
        return dfs(map, 0, s.length()-1, c);           
    }
    int dfs(HashMap<Integer, Integer> map, int l, int r, char[] c)
    {
        if(map.containsKey(l)) return map.get(l);
        if(l < c.length && c[l] == '0') return 0;
        //*** "" should count 1
        if(l >= r) return 1;
        
        
        int subCount = dfs(map, l+1, r, c);
        int num = (c[l] - '0') * 10 + (c[l + 1] - '0');
        if(num > 0 && num < 27)
            subCount += dfs(map, l+2, r, c);
        
        map.put(l, subCount);
        return subCount;
    }
}

//O(n^2)
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
   public int numDecodings(String s) {
       int count = 0;        
       return dfs(s);           
   }
   int dfs(String s)
   {
       if(map.containsKey(s)) return map.get(s);
       if(s.length() > 0 && s.toCharArray()[0] == '0') return 0;
       if(s.length() <= 1) return 1;
       
       int subCount = dfs(s.substring(1));
       int num = Integer.valueOf(s.substring(0,2));
       if(num > 0 && num < 27)
           subCount += dfs(s.substring(2));
       
       map.put(s, subCount);
       return subCount;
   }
}