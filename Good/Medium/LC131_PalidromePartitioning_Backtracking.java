import java.util.*;
//DP O(n*2^n)
class LC131_PalidromePartitioning_Backtracking {
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        dfs(s, 0, new ArrayList<>(), dp, len);
        
        return ret;
    }
    void dfs(String s, int str, List<String> cur, boolean[][] dp, int len)
    {
        if(str >= len)
        {
            ret.add(new ArrayList<>(cur));
        }
        char[] cA = s.toCharArray();
        for(int end = str; end < len; end++)
        {
            //Key point end - str <= 1, ex: aba, abba
            if(cA[str] == cA[end] && (end - str <= 1 || dp[str+1][end-1]))
            {
                dp[str][end] = true;
                cur.add(s.substring(str, end+1));
                dfs(s, end+1, cur, dp, len);
                cur.remove(cur.size()-1);
            }
        }
    }
}
//Backtracking O(n*2^n)
class LC131_PalidromePartitioning_BacktrackingS2 {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return list;
    }
    
    private void dfs(String s, int start, List<String> curL){
        if(start >= s.length()) list.add(new ArrayList<>(curL));
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                //O(N)
                curL.add(s.substring(start, end + 1));
                dfs(s, end + 1, curL);
                curL.remove(curL.size() - 1);
            }
        }
    }
    
    //(O(N))
    private boolean isPalindrome(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}